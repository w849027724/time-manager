package com.time.manager.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.time.manage.common.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author wlj
 * @Title: SysUserService
 * @date 2020-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysUser对象", description = "")
public class SysUser extends BaseEntity<SysUser> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "系统用户id")
    @TableId(value = "sys_user_id", type = IdType.AUTO)
    private Long sysUserId;

    @ApiModelProperty(value = "系统用户名字")
    private String sysUserName;

    @ApiModelProperty(value = "系统用户密码")
    private String sysUserPassword;

}
