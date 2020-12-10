package com.time.manager.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.time.manage.common.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author wlj
 * @Title: SysParamsService
 * @date 2020-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysParams对象", description = "")
public class SysParams extends BaseEntity<SysParams> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "系统参数id")
    @TableId(value = "sys_params_id", type = IdType.AUTO)
    private Long sysParamsId;

    @ApiModelProperty(value = "系统参数key")
    private String sysParamsKey;

    @ApiModelProperty(value = "系统参数value")
    private String sysParamsValue;

    @ApiModelProperty(value = "系统参数 扩展字段( json格式)")
    private String sysParamsExtend;

}
