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
 * 经验和计划的秒数挂钩
 * </p>
 *
 * @author wlj
 * @Title: UserExperService
 * @date 2020-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserExper对象", description = "经验和计划的秒数挂钩")
public class UserExper extends BaseEntity<UserExper> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户经验表id")
    @TableId(value = "user_exper_id", type = IdType.AUTO)
    private Long userExperId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户称号")
    private String labelCode;

    @ApiModelProperty(value = "用户经验")
    private Long userExper;


}
