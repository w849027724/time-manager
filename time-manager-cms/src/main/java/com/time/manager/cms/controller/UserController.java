package com.time.manager.cms.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.entity.UserInfo;
import com.time.manager.cms.service.UserInfoService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wlj
 **/
@RestController
@RequestMapping("/user")
@Api(tags = "用户")
@RequiredArgsConstructor
public class UserController {
    private final UserInfoService userInfoService;

    @GetMapping("/info")
    public String getUserInfo() {
        return "左丽牛逼！！";
    }

    @PostMapping("/login")
    public R login(@RequestBody UserInfo userInfo) {
        List<UserInfo> list = userInfoService.list(Wrappers.<UserInfo>query()
                .lambda().eq(UserInfo::getUserName, userInfo.getUserName()));
        if (list.size() > 0) {
            UserInfo userInfo1 = list.get(0);
            if (userInfo1.getUserPassword().equals(userInfo.getUserPassword())) {
                return R.ok(userInfo1);
            }
        }
        return R.failed();
    }

}
