package com.time.manager.system.controller.api;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.utils.R;
import com.time.manager.security.annotation.Ignore;
import com.time.manager.system.controller.api.dto.SysUserDTO;
import com.time.manager.system.entity.SysUser;
import com.time.manager.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wlj
 **/
@RestController
@RequestMapping("/api/sys/user")
@Api(tags = "api系統用户接口")
@RequiredArgsConstructor
public class SysUserApi {
    private final SysUserService sysUserService;


    @Ignore
    @GetMapping("/find/username")
    @ApiOperation("查询用户名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "userName", required = true, dataType = "Long", paramType = "query")
    })
    public R<SysUserDTO> findByName(
            @RequestParam("userName") String userName
    ) {
        List<SysUser> list = sysUserService.list(Wrappers.<SysUser>query()
                .lambda().eq(SysUser::getSysUserName, userName));
        if (list.size() == 1) {
            SysUser sysUser = list.get(0);
            return R.ok(sysUser.toSysUserDTO());
        }
        return R.failed();
    }


}
