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
 * @Title: LabelInfoService
 * @date 2020-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "LabelInfo对象", description = "")
public class LabelInfo extends BaseEntity<LabelInfo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "称号详情id")
    @TableId(value = "label_info_id", type = IdType.AUTO)
    private Long labelInfoId;

    @ApiModelProperty(value = "称号编码")
    private String labelCode;

    @ApiModelProperty(value = "称号名字")
    private String labelName;

    @ApiModelProperty(value = "称号开始所需经验")
    private Long labelStatExper;

    @ApiModelProperty(value = "称号结束所需经验")
    private Long labelEndExper;

}
