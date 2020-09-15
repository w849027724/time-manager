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

    @ApiModelProperty(value = "计划状态 1：未开始  2：进行中 3：未完成 4：已完成")
    private Integer planStatus;

    @ApiModelProperty(value = "用户id")
    private Long userId;

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

    @ApiModelProperty(value = "计划统计id")
    private Long planStatId;

    @ApiModelProperty(value = "计划点赞")
    private Integer planFabulous;

    @ApiModelProperty(value = "计划参与数")
    private Integer planJoins;

    @ApiModelProperty(value = "计划参与用户（json格式   user_id集合 英文逗号隔开）")
    private String planJoinUser;

    @ApiModelProperty(value = "用户头像")
    private String userAvatar;

    @ApiModelProperty(value = "用户昵称")
    private String userNickname;

}
