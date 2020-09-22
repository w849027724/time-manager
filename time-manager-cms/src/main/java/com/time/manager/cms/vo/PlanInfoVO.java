package com.time.manager.cms.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wlj
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "计划信息vo", description = "")
public class PlanInfoVO implements Serializable {

    @ApiModelProperty(value = "计划id")
    private Long planId;

    @ApiModelProperty(value = "计划状态 0：未开始  1：已完成")
    private Integer planStatus;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "计划名字")
    private String planName;

    @ApiModelProperty(value = "计划类型 0：打卡  2：计时 3：限时")
    private Integer planType;

    @ApiModelProperty(value = "计划频次类型  0：一次  1.每日  2.自定义")
    private Integer planFrequencyType;

    @ApiModelProperty(value = "计划频次日期 星期1-星期7")
    private String planFrequencyDays;

    @ApiModelProperty(value = "计划时间")
    private String planTime;

    @ApiModelProperty(value = "计划开始时间")
    private LocalDateTime planStartTime;

    @ApiModelProperty(value = "计划结束时间")
    private LocalDateTime planEndTime;

    @ApiModelProperty(value = "计划秒数")
    private Long planSecond;

    @ApiModelProperty(value = "计划完成次数")
    private Long planTimes;

    @ApiModelProperty(value = "置顶计划  0：不是  1：是")
    private Integer planTop;

    @ApiModelProperty(value = "备注")
    private String remarks;

    // ==================================================

    @ApiModelProperty(value = "用户头像")
    private String userAvatar;

    @ApiModelProperty(value = "用户昵称")
    private String userNickname;

    // ==================================================

    @ApiModelProperty(value = "用户每日计划")
    private Long planUserDayId;

    @ApiModelProperty(value = "计划状态 1：未开始  2：进行中 3：未完成 4：已完成")
    private Integer planDayStatus;

    @ApiModelProperty(value = "日期  yyyy-MM-dd")
    private String planDay;

    @ApiModelProperty(value = "开始时间  hh:mm:ss")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "结束时间 hh:mm:ss")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "完成时间")
    private Integer finishDay;

    @ApiModelProperty(value = "剩余时间")
    private Integer lastDay;
    // ==================================================

    @ApiModelProperty(value = "计划点赞")
    private Integer planFabulous;

    @ApiModelProperty(value = "计划参与数")
    private Integer planJoins;

    @ApiModelProperty(value = "计划参与用户（json格式   user_id集合 英文逗号隔开）")
    private String planJoinUser;


}
