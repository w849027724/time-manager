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
 * @Title: PlanInfoService
 * @date 2020-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "PlanInfo对象", description = "")
public class PlanInfo extends BaseEntity<PlanInfo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "计划id")
    @TableId(value = "plan_id", type = IdType.AUTO)
    private Long planId;

    @ApiModelProperty(value = "计划名字")
    private String planName;

    @ApiModelProperty(value = "计划类型 1：一次  2.每日 3.工作日 4.非工作日")
    private Integer planType;

    @ApiModelProperty(value = "计划开始时间")
    private LocalDateTime planStartTime;

    @ApiModelProperty(value = "计划结束时间")
    private LocalDateTime planEndTime;

    @ApiModelProperty(value = "计划秒数")
    private Long planSecond;

}
