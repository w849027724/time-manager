package com.time.manager.cms.controller.app;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.entity.PlanInfo;
import com.time.manager.cms.entity.PlanStat;
import com.time.manager.cms.entity.PlanUserDay;
import com.time.manager.cms.service.*;
import com.time.manager.cms.vo.PlanInfoVO;
import com.time.manager.cms.vo.PlanViewVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wlj
 **/
@RestController
@RequestMapping("/app/plan")
@Api(tags = "app计划管理")
@RequiredArgsConstructor
public class PlanController {
    private final PlanInfoService planInfoService;
    private final PlanStatService planStatService;
    private final UserExperService userExperService;
    private final UserStatService userStatService;
    private final PlanUserDayService planUserDayService;


    @GetMapping("/list")
    @ApiOperation("我的计划列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "userId", required = true, dataType = "Long", paramType = "query")
    })
    public R<PlanViewVO> getPlanList(
            @RequestParam("userId") Long userId
    ) {
        // 获取今天 yyyy-MM-dd 打卡
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = LocalDateTime.now().format(df);
        List<PlanUserDay> list = planUserDayService.list(Wrappers.<PlanUserDay>query().lambda().eq(PlanUserDay::getPlanDay, format).eq(PlanUserDay::getUserId, userId));
        List<PlanInfoVO> result = new ArrayList<>(list.size());
        list.forEach(e -> {
            PlanInfoVO planInfoVO = new PlanInfoVO();
            BeanUtils.copyProperties(e, planInfoVO);
            PlanInfo byId = planInfoService.getById(e.getPlanId());
            BeanUtils.copyProperties(byId, planInfoVO);
            result.add(planInfoVO);
        });
        PlanViewVO planViewVO = new PlanViewVO();
        Map<Integer, List<PlanInfoVO>> collect = result.stream().collect(Collectors.groupingBy(PlanInfoVO::getPlanType));

        if (collect.containsKey(0)) {
            List<PlanInfoVO> planInfoVOS = collect.get(0);
            planViewVO.setCheckInList(planInfoVOS);
        }
        if (collect.containsKey(1)) {
            List<PlanInfoVO> planInfoVOS = collect.get(1);
            planViewVO.setTimingList(planInfoVOS);
        }
        if (collect.containsKey(2)) {
            List<PlanInfoVO> planInfoVOS = collect.get(2);
            planViewVO.setLongPlanInfo(planInfoVOS.get(0));
        }


        return R.ok(planViewVO);
    }


    @PostMapping("/add")
    @ApiOperation("发布计划")
    public R register(@RequestBody PlanInfo planInfo) {
        planInfo.setPlanStatus(0).setPlanTimes(0L);
        planInfoService.save(planInfo);
        PlanStat planStat = new PlanStat()
                .setPlanId(planInfo.getPlanId())
                .setPlanFabulous(0)
                .setPlanJoins(0);
        planStatService.save(planStat);
        userStatService.addPlans(planInfo.getUserId());
        planUserDayService.initDayPlanUserList(planInfo.getUserId());
        return R.ok();
    }

    @PutMapping("/start/plan")
    @ApiOperation("开始计划")
    public R startPlan(@RequestBody PlanUserDay planUserDay) {
        List<PlanUserDay> list = planUserDayService.list(Wrappers.<PlanUserDay>query()
                .lambda().eq(PlanUserDay::getPlanUserDayId, planUserDay.getPlanUserDayId()));
        if (list.size() > 0) {
            PlanUserDay planInfo2 = list.get(0);
            planInfo2.setPlanDayStatus(2);
            planUserDayService.updateById(planInfo2);
        }
        return R.ok();
    }

    @PutMapping("/end/plan")
    @ApiOperation("结束计划")
    public R endPlan(@RequestBody PlanInfoVO planInfoVO) {
        List<PlanUserDay> list = planUserDayService.list(Wrappers.<PlanUserDay>query()
                .lambda().eq(PlanUserDay::getPlanUserDayId, planInfoVO.getPlanUserDayId()));
        if (list.size() > 0) {
            PlanUserDay planUserDay = list.get(0);
            PlanInfo byId = planInfoService.getById(planInfoVO.getPlanId());
            planUserDay.setPlanDayStatus(4);
            if (byId.getPlanType() == 2) {
                planUserDay.setEndTime(LocalDateTime.now());
            }
            planUserDayService.updateById(planUserDay);
            // 一次的计划结束
            if (byId.getPlanFrequencyType() == 0) {
                byId.setPlanStatus(1);
                planInfoService.updateById(byId);
            }
            // 经验计算
            Long exper = 100L;
            if (byId.getPlanType() == 1) {
                exper = byId.getPlanSecond();
            }
            if (byId.getPlanType() == 2) {
                exper = 100L;
            }

            userExperService.addExper(planUserDay.getUserId(), exper);
            userStatService.addFinishs(byId.getUserId());
        }
        return R.ok();
    }

    @DeleteMapping("/del/{planId}")
    @ApiOperation("开始计划")
    public R delPlan(@PathVariable Long planId) {

        List<PlanInfo> list = planInfoService.list(Wrappers.<PlanInfo>query().lambda().eq(PlanInfo::getPlanId, planId));
        if (list.size() > 0) {
            PlanInfo planInfo = list.get(0);
            PlanStat one = planStatService.getOne(Wrappers.<PlanStat>query().lambda().eq(PlanStat::getPlanId, planInfo.getPlanId()));
            planStatService.removeById(one.getPlanStatId());
            planInfoService.removeById(planId);
        }

        return R.ok();
    }

}
