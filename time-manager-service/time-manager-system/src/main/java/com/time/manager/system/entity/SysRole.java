package com.time.manager.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.time.manage.common.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author wlj
 * @Title: SysRoleService
 * @date 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysRole对象", description = "")
public class SysRole extends BaseEntity<SysRole> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sys_role_id", type = IdType.AUTO)
    private Long sysRoleId;

    private String sysRoleName;

    private String sysRoleCode;


}
