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
 * @Title: UserPlanTimesService
 * @date 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserPlanTimes对象", description = "")
public class UserPlanTimes extends BaseEntity<UserPlanTimes> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户计划次数id")
    @TableId(value = "user_plan_times_id", type = IdType.AUTO)
    private Long userPlanTimesId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户打卡次数")
    private Long clockInPlanNum;

    @ApiModelProperty(value = "用户长计划次数")
    private Long longPlanNum;

    @ApiModelProperty(value = "用户计时次数")
    private Long timingPlanNum;

}
