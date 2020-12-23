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
 * @Title: SysRoleResourceService
 * @date 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysRoleResource对象", description = "")
public class SysRoleResource extends BaseEntity<SysRoleResource> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sys_role_resource_id", type = IdType.AUTO)
    private Long sysRoleResourceId;

    private Long sysRoleId;

    private Long sysResourceId;


}
