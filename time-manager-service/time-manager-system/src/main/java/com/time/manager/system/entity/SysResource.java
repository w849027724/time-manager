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
 * @Title: SysResourceService
 * @date 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysResource对象", description = "")
public class SysResource extends BaseEntity<SysResource> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sys_resource_id", type = IdType.AUTO)
    private Long sysResourceId;

    private String sysResourceName;

    private Long sysResourceOrder;

    private Long parentId;


}
