package com.time.manager.cms.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wlj
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "用户统计信息vo", description = "")
public class UserStatVO implements Serializable {

    @ApiModelProperty(value = "用户统计id")
    private Long userStatId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "发起计划总数")
    private Integer planTotal;

    @ApiModelProperty(value = "计划完成总数")
    private Integer planFinish;

    @ApiModelProperty(value = "计划点赞总数")
    private Integer planFabulous;

    // ===============================

    @ApiModelProperty(value = "用户头像")
    private String userAvatar;

    @ApiModelProperty(value = "用户昵称")
    private String userNickname;

}
