package com.time.manager.cms.controller.app;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.entity.UserExper;
import com.time.manager.cms.entity.UserInfo;
import com.time.manager.cms.entity.UserStat;
import com.time.manager.cms.service.PlanUserDayService;
import com.time.manager.cms.service.UserExperService;
import com.time.manager.cms.service.UserInfoService;
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
@RequestMapping("/app/user")
@Api(tags = "app用户管理")
@RequiredArgsConstructor
public class UserController {
    private final UserInfoService userInfoService;
    private final UserStatService userStatService;
    private final UserExperService userExperService;
    private final PlanUserDayService planUserDayService;

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


    @PostMapping("/register")
    @ApiOperation("用户注册")
    public R register(@RequestBody UserInfo userInfo) {
        // 注册
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
        return R.ok();
    }

}
