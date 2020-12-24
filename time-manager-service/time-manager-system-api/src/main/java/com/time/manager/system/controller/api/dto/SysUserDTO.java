package com.time.manager.system.controller.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wlj
 **/
@Data
@ApiModel(value = "SysUser对象", description = "")
public class SysUserDTO implements Serializable {

    @ApiModelProperty(value = "系统用户id")
    private Long sysUserId;

    @ApiModelProperty(value = "系统用户名字")
    private String sysUserName;

    @ApiModelProperty(value = "系统用户密码")
    private String sysUserPassword;

}
