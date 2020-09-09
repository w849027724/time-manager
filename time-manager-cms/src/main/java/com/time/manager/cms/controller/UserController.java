package com.time.manager.cms.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wlj
 **/
@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {


    @GetMapping("/info")
    public String getUserInfo() {
        return "左丽牛逼！！";
    }

}
