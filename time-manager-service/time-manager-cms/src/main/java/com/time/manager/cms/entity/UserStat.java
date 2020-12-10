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
 * @Title: UserStatService
 * @date 2020-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserStat对象", description = "")
public class UserStat extends BaseEntity<UserStat> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户统计id")
    @TableId(value = "user_stat_id", type = IdType.AUTO)
    private Long userStatId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "发起计划总数")
    private Integer planTotal;

    @ApiModelProperty(value = "计划完成总数")
    private Integer planFinish;

    @ApiModelProperty(value = "计划点赞总数")
    private Integer planFabulous;

}
