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
 * 用户每日的计划列表
 * </p>
 *
 * @author wlj
 * @Title: PlanUserDayService
 * @date 2020-09-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "PlanUserDay对象", description = "用户每日的计划列表")
public class PlanUserDay extends BaseEntity<PlanUserDay> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户每日计划")
    @TableId(value = "plan_user_day_id", type = IdType.AUTO)
    private Long planUserDayId;

    @ApiModelProperty(value = "计划id")
    private Long planId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "日期  yyyy-MM-dd")
    private String planDay;

    @ApiModelProperty(value = "计划状态 1：未开始  2：进行中 3：未完成 4：已完成")
    private Integer planDayStatus;

    @ApiModelProperty(value = "开始时间  hh:mm:ss")
    private String startTime;

    @ApiModelProperty(value = "结束时间 hh:mm:ss")
    private String endTime;


}
