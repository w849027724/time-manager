package com.time.manager.cms.controller.app;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.entity.UserPlanTimes;
import com.time.manager.cms.service.UserPlanTimesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wlj
 **/
@RestController
@RequestMapping("/app/user/times")
@Api(tags = "app用户次数管理")
@RequiredArgsConstructor
public class UserTimesController {
    private final UserPlanTimesService userPlanTimesService;


    @GetMapping("/info")
    @ApiOperation("用户次数")
    public R<UserPlanTimes> login(
            @RequestParam(value = "userId", required = true) Long userId
    ) {
        UserPlanTimes one = userPlanTimesService.getOne(Wrappers.<UserPlanTimes>query().lambda().eq(UserPlanTimes::getUserId, userId));
        return R.ok(one);
    }

}
