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
@RequestMapping("/app/find")
@Api(tags = "app发现管理")
@RequiredArgsConstructor
public class FindController {
    private final PlanInfoService planInfoService;
    private final PlanStatService planStatService;


    @GetMapping("/list")
    @ApiOperation("发现列表")
    public R findList() {
        List<PlanInfo> list = planInfoService.list();
        return R.ok(list);
    }


    @PutMapping("/fabulous")
    @ApiOperation("用户点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "planId", value = "planId", required = true, dataType = "Long", paramType = "query")
    })
    public R findFabulous(
            @RequestParam("planId") Long planId
    ) {
        List<PlanStat> list = planStatService.list(Wrappers.<PlanStat>query().lambda().eq(PlanStat::getPlanId, planId));
        if (list.size() > 0) {
            PlanStat planStat = list.get(0);
            planStat.setPlanFabulous(planStat.getPlanFabulous() + 1);
            planStatService.updateById(planStat);
        }
        return R.ok();
    }

    @PutMapping("/join")
    @ApiOperation("用户参加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "planId", value = "planId", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "userId", required = true, dataType = "Long", paramType = "query")
    })
    public R findFabulous(
            @RequestParam("planId") Long planId,
            @RequestParam("userId") Long userId
    ) {
        List<PlanStat> list = planStatService.list(Wrappers.<PlanStat>query().lambda().eq(PlanStat::getPlanId, planId));
        if (list.size() > 0) {
            // 更新参加数
            PlanStat planStat = list.get(0);
            planStat.setPlanJoins(planStat.getPlanJoins() + 1);
            planStatService.updateById(planStat);

            PlanInfo byId = planInfoService.getById(planStat.getPlanId());
            byId.setPlanId(null).setUserId(userId).setPlanStatus(0);
            planInfoService.save(byId);
        }
        return R.ok();
    }


}
