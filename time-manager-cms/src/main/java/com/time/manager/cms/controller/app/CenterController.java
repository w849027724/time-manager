package com.time.manager.cms.controller.app;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.entity.UserExper;
import com.time.manager.cms.entity.UserStat;
import com.time.manager.cms.service.UserExperService;
import com.time.manager.cms.service.UserStatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
@RequestMapping("/app/center")
@Api(tags = "app我的管理")
@RequiredArgsConstructor
public class CenterController {
    private final UserExperService userExperService;
    private final UserStatService userStatService;


    @GetMapping("/exper")
    @ApiOperation("获取用户经验")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "userId", required = true, dataType = "Long", paramType = "query")
    })
    public R getUserExper(
            @RequestParam("userId") Long userId
    ) {
        UserExper one = userExperService.getOne(Wrappers.<UserExper>query().lambda().eq(UserExper::getUserId, userId));
        return R.ok(one);
    }


    @GetMapping("/stat")
    @ApiOperation("获取用户统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "userId", required = true, dataType = "Long", paramType = "query")
    })
    public R getUserStat(
            @RequestParam("userId") Long userId
    ) {
        UserStat one = userStatService.getOne(Wrappers.<UserStat>query().lambda().eq(UserStat::getUserId, userId));
        return R.ok(one);
    }

}
