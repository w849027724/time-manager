package com.time.manager.cms.controller.app;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.entity.UserExper;
import com.time.manager.cms.entity.UserInfo;
import com.time.manager.cms.entity.UserPlanTimes;
import com.time.manager.cms.entity.UserStat;
import com.time.manager.cms.security.IgnoreToken;
import com.time.manager.cms.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wlj
 **/
@RestController
@RequestMapping("/app/user")
@Api(tags = "app用户管理")
@RequiredArgsConstructor
public class UserController {
    private final UserInfoService userInfoService;
    private final UserStatService userStatService;
    private final UserExperService userExperService;
    private final PlanUserDayService planUserDayService;
    private final UserPlanTimesService userPlanTimesService;

    @GetMapping("/login")
    @ApiOperation("用户登录")
    public R login(
            @RequestParam("userName") String userName,
            @RequestParam("userPassword") String userPassword
    ) {
        List<UserInfo> list = userInfoService.list(Wrappers.<UserInfo>query()
                .lambda().eq(UserInfo::getUserName, userName));
        if (list.size() > 0) {
            UserInfo userInfo1 = list.get(0);
            if (userInfo1.getUserPassword().equals(userPassword)) {
                planUserDayService.initDayPlanUserList(userInfo1.getUserId());
                return R.ok(userInfo1);
            }
        }
        return R.failed();
    }

    @IgnoreToken
    @GetMapping("/find/username")
    @ApiOperation("查询用户名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "userName", required = true, dataType = "Long", paramType = "query")
    })
    public R register(
            @RequestParam("userName") String userName
    ) {
        List<UserInfo> list = userInfoService.list(Wrappers.<UserInfo>query()
                .lambda().eq(UserInfo::getUserName, userName));
        return R.ok(list.size());
    }

    @IgnoreToken
    @PostMapping("/register")
    @ApiOperation("用户注册")
    public R register(@RequestBody UserInfo userInfo) {
        // 注册
        userInfo.setUserPassword(new BCryptPasswordEncoder().encode(userInfo.getUserPassword()));
        userInfo.setUserAvatar("");
        userInfoService.save(userInfo);
        // 用户经验
        UserExper userExper = new UserExper()
                .setUserExper(0L)
                .setUserId(userInfo.getUserId())
                .setLabelCode("1");
        userExperService.save(userExper);
        // 用户统计
        UserStat userStat = new UserStat()
                .setUserId(userInfo.getUserId())
                .setPlanFabulous(0)
                .setPlanFinish(0)
                .setPlanTotal(0);
        userStatService.save(userStat);
        // 用户计划次数
        UserPlanTimes userPlanTimes = new UserPlanTimes()
                .setClockInPlanNum(5L)
                .setLongPlanNum(1L)
                .setTimingPlanNum(5L);
        userPlanTimesService.save(userPlanTimes);
        return R.ok();
    }

}
