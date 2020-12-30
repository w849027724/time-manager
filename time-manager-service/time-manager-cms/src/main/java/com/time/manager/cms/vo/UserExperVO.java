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
@ApiModel(value = "用户经验vo", description = "")
public class UserExperVO implements Serializable {

    @ApiModelProperty(value = "用户经验表id")
    private Long userExperId;

    @ApiModelProperty(value = "用户称号")
    private String labelCode;

    @ApiModelProperty(value = "用户经验")
    private Long userExper;

    @ApiModelProperty(value = "称号名字")
    private String labelName;

    @ApiModelProperty(value = "称号开始所需经验")
    private Long labelStatExper;

    @ApiModelProperty(value = "称号结束所需经验")
    private Long labelEndExper;

}
