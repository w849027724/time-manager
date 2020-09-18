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
 * @date 2020-09-18
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

    @ApiModelProperty(value = "计划状态 1：未开始  2：进行中 3：未完成 4：已完成")
    private Integer planStatus;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "计划名字")
    private String planName;

    @ApiModelProperty(value = "计划类型 0：打卡  1：计时 2：限时")
    private Integer planType;

    @ApiModelProperty(value = "计划频次类型  0：一次  1.每日 2.工作日 3.非工作日 4.自定义")
    private Integer planFrequencyType;

    @ApiModelProperty(value = "计划频次日期 星期1-星期7")
    private String planFrequencyDays;

    @ApiModelProperty(value = "计划开始时间")
    private String planStartTime;

    @ApiModelProperty(value = "计划结束时间")
    private String planEndTime;

    @ApiModelProperty(value = "计划秒数")
    private Long planSecond;

    @ApiModelProperty(value = "计划完成次数")
    private Long planTimes;

    @ApiModelProperty(value = "备注")
    private String remarks;
}
