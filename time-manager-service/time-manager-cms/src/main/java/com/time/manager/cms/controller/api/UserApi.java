package com.time.manager.cms.controller.api;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.api.dto.UserInfoDTO;
import com.time.manager.cms.entity.MessageInfo;
import com.time.manager.cms.entity.UserInfo;
import com.time.manager.cms.service.MessageInfoService;
import com.time.manager.cms.service.UserInfoService;
import com.time.manager.security.annotation.Ignore;
import com.time.manager.wallet.api.feign.WalletFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wlj
 **/
@RestController
@RequestMapping("/api/user")
@Api(tags = "api用户接口")
@RequiredArgsConstructor
public class UserApi {
    private final UserInfoService userInfoService;

    @Ignore
    @GetMapping("/find/username")
    @ApiOperation("查询用户名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "userName", required = true, dataType = "Long", paramType = "query")
    })
    public R<UserInfoDTO> findByName(
            @RequestParam("userName") String userName
    ) {
        List<UserInfo> list = userInfoService.list(Wrappers.<UserInfo>query()
                .lambda().eq(UserInfo::getUserName, userName));
        if (list.size() == 1) {
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            BeanUtils.copyProperties(list.get(0), userInfoDTO);
            return R.ok(userInfoDTO);
        }
        return R.failed();
    }


    @Ignore
    @GetMapping("/test")
    @ApiOperation("查询用户名")
    public R<UserInfoDTO> testSeata() {
        userInfoService.testSeata();
        return R.ok();
    }

}
