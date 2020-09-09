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
 * @Title: PlanStatService
 * @date 2020-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "PlanStat对象", description = "")
public class PlanStat extends BaseEntity<PlanStat> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "计划统计id")
    @TableId(value = "plan_stat_id", type = IdType.AUTO)
    private Long planStatId;

    @ApiModelProperty(value = "计划id")
    private Long planId;

    @ApiModelProperty(value = "计划点赞")
    private Integer planFabulous;

    @ApiModelProperty(value = "计划参与数")
    private Integer planJoins;

    @ApiModelProperty(value = "计划参与用户（json格式   user_id集合 英文逗号隔开）")
    private String planJoinUser;


}
