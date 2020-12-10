package com.time.manager.cms.controller.app;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.entity.PlanInfo;
import com.time.manager.cms.entity.PlanStat;
import com.time.manager.cms.entity.PlanUserDay;
import com.time.manager.cms.entity.UserInfo;
import com.time.manager.cms.service.*;
import com.time.manager.cms.vo.PlanInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wlj
 **/
@RestController
@RequestMapping("/app/find")
@Api(tags = "app发现管理")
@RequiredArgsConstructor
public class FindController {
    private final PlanInfoService planInfoService;
    private final PlanStatService planStatService;
    private final UserInfoService userInfoService;
    private final UserStatService userStatService;
    private final PlanUserDayService planUserDayService;

    @GetMapping("/list")
    @ApiOperation("发现列表")
    public R<List<PlanInfoVO>> findList() {
        List<PlanUserDay> list = planUserDayService.list(Wrappers.<PlanUserDay>query()
                .lambda().eq(PlanUserDay::getPlanDayStatus, 4)
                .orderByDesc(PlanUserDay::getModifiedTime));
        List<PlanInfoVO> result = new ArrayList<>(list.size());
        list.forEach(e -> {
            PlanInfoVO planInfoVO = new PlanInfoVO();
            PlanInfo byId = planInfoService.getById(e.getPlanId());
            BeanUtils.copyProperties(e, planInfoVO);
            BeanUtils.copyProperties(byId, planInfoVO);
            Long planId = e.getPlanId();
            PlanStat one = planStatService.getOne(Wrappers.<PlanStat>query().lambda().eq(PlanStat::getPlanId, planId));
            if (ObjectUtil.isNotNull(one)) {
                BeanUtils.copyProperties(one, planInfoVO);
            }
            UserInfo one1 = userInfoService.getOne(Wrappers.<UserInfo>query().lambda().eq(UserInfo::getUserId, e.getUserId()));
            if (ObjectUtil.isNotNull(one1)) {
                planInfoVO.setUserAvatar(one1.getUserAvatar()).setUserNickname(one1.getUserNickname());
            }
            result.add(planInfoVO);
        });
        return R.ok(result);
    }


    @PutMapping("/fabulous")
    @ApiOperation("用户点赞")
    public R findFabulous(@RequestBody PlanInfo planInfo) {
        List<PlanStat> list = planStatService.list(Wrappers.<PlanStat>query().lambda().eq(PlanStat::getPlanId, planInfo.getPlanId()));
        if (list.size() > 0) {
            PlanStat planStat = list.get(0);
            planStat.setPlanFabulous(planStat.getPlanFabulous() + 1);
            planStatService.updateById(planStat);

            userStatService.addFabulous(planInfo.getUserId());
        }
        return R.ok();
    }

    @PutMapping("/join")
    @ApiOperation("用户参加")
    public R findJoins(@RequestBody PlanInfo planInfo) {
        List<PlanStat> list = planStatService.list(Wrappers.<PlanStat>query().lambda().eq(PlanStat::getPlanId, planInfo.getPlanId()));
        if (list.size() > 0) {
            // 更新参加数
            PlanStat planStat = list.get(0);
            planStat.setPlanJoins(planStat.getPlanJoins() + 1);
            planStatService.updateById(planStat);

            PlanInfo byId = planInfoService.getById(planStat.getPlanId());
            byId.setPlanId(null).setUserId(planInfo.getUserId()).setPlanStatus(0);
            planInfoService.save(byId);

            planStat.setPlanStatId(null).setPlanId(byId.getPlanId()).setPlanJoins(0).setPlanFabulous(0).setPlanJoinUser("");
            planStatService.save(planStat);

            userStatService.addPlans(planInfo.getUserId());
        }
        return R.ok();
    }


}
