package com.time.manager.cms.controller.app;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.entity.PlanInfo;
import com.time.manager.cms.entity.PlanStat;
import com.time.manager.cms.service.PlanInfoService;
import com.time.manager.cms.service.PlanStatService;
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


    @GetMapping("/get/plan/list")
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


    @PostMapping("/add/plan")
    @ApiOperation("发布计划")
    public R register(@RequestBody PlanInfo planInfo) {
        planInfoService.save(planInfo);
        PlanStat planStat = new PlanStat()
                .setPlanId(planInfo.getPlanId())
                .setPlanFabulous(0)
                .setPlanJoins(0);
        planStatService.save(planStat);
        return R.ok();
    }

    @PutMapping("/start/plan")
    @ApiOperation("开始计划")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "planId", value = "计划id", required = true, dataType = "Long", paramType = "query")
    })
    public R startPlan(
            @RequestParam("planId") Long planId
    ) {
        List<PlanInfo> list = planInfoService.list(Wrappers.<PlanInfo>query().lambda().eq(PlanInfo::getPlanId, planId));
        if (list.size() > 0) {
            PlanInfo planInfo = list.get(0);
            planInfo.setPlanStatus(2);
            planInfoService.updateById(planInfo);
        }
        return R.ok();
    }


}
