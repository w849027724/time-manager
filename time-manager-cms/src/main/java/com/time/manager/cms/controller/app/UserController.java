package com.time.manager.cms.controller.app;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.entity.UserExper;
import com.time.manager.cms.entity.UserInfo;
import com.time.manager.cms.entity.UserPlanTimes;
import com.time.manager.cms.entity.UserStat;
import com.time.manager.cms.security.IgnoreToken;
import com.time.manager.cms.security.SecurityConstants;
import com.time.manager.cms.security.SecurityUtils;
import com.time.manager.cms.security.TimeManagerUserDetails;
import com.time.manager.cms.service.UserExperService;
import com.time.manager.cms.service.UserInfoService;
import com.time.manager.cms.service.UserPlanTimesService;
import com.time.manager.cms.service.UserStatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    private final UserPlanTimesService userPlanTimesService;
    @Resource
    private RedissonClient redissonClient;

    @GetMapping("/logout")
    @ApiOperation("退出登录")
    public R logout() {
        TimeManagerUserDetails userInfo = SecurityUtils.getUserInfo();
        redissonClient.getBucket(SecurityConstants.KEY_TOKEN + userInfo.getToken()).delete();
        redissonClient.getBucket(SecurityConstants.TOKEN_USER + userInfo.getUserId()).delete();
        return R.ok();
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
                .setUserId(userInfo.getUserId())
                .setClockInPlanNum(5L)
                .setLongPlanNum(1L)
                .setTimingPlanNum(5L);
        userPlanTimesService.save(userPlanTimes);
        return R.ok();
    }

}
