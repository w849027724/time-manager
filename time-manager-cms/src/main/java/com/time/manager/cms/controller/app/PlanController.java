package com.time.manager.cms.controller.app;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.entity.PlanInfo;
import com.time.manager.cms.entity.PlanStat;
import com.time.manager.cms.service.PlanInfoService;
import com.time.manager.cms.service.PlanStatService;
import com.time.manager.cms.service.UserExperService;
import com.time.manager.cms.service.UserStatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/list")
    @ApiOperation("我的计划列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "userId", required = true, dataType = "Long", paramType = "query")
    })
    public R getPlanList(
            @RequestParam("userId") Long userId
    ) {
        List<PlanInfo> list1 = planInfoService.list(Wrappers.<PlanInfo>query().lambda().eq(PlanInfo::getUserId, userId));
        return R.ok(list1);
    }


    @PostMapping("/add")
    @ApiOperation("发布计划")
    public R register(@RequestBody PlanInfo planInfo) {
        planInfoService.save(planInfo);
        PlanStat planStat = new PlanStat()
                .setPlanId(planInfo.getPlanId())
                .setPlanFabulous(0)
                .setPlanJoins(0);
        planStatService.save(planStat);
        userStatService.addPlans(planInfo.getUserId());
        return R.ok();
    }

    @PutMapping("/start/plan")
    @ApiOperation("开始计划")
    public R startPlan(@RequestBody PlanInfo planInfo) {
        List<PlanInfo> list = planInfoService.list(Wrappers.<PlanInfo>query().lambda().eq(PlanInfo::getPlanId, planInfo.getPlanId()));
        if (list.size() > 0) {
            PlanInfo planInfo2 = list.get(0);
            planInfo2.setPlanStatus(2);
            planInfoService.updateById(planInfo2);
        }
        return R.ok();
    }

    @PutMapping("/end/plan")
    @ApiOperation("开始计划")
    public R endPlan(@RequestBody PlanInfo planInfo) {
        List<PlanInfo> list = planInfoService.list(Wrappers.<PlanInfo>query().lambda().eq(PlanInfo::getPlanId, planInfo.getPlanId()));
        if (list.size() > 0) {
            PlanInfo planInfo1 = list.get(0);
            planInfo1.setPlanStatus(4);
            planInfoService.updateById(planInfo1);
            userExperService.addExper(planInfo1.getUserId(), planInfo1.getPlanSecond());
            userStatService.addFinishs(planInfo.getUserId());
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
