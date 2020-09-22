package com.time.manager.cms.vo;

import com.time.manager.cms.entity.PlanInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author wlj
 **/
@Data
@Accessors(chain = true)
@ApiModel(value = "计划页面数据vo", description = "")
public class PlanViewVO implements Serializable {

    @ApiModelProperty(value = "长计划")
    private PlanInfoVO longPlanInfo;

    @ApiModelProperty(value = "打卡列表")
    private List<PlanInfoVO> checkInList;

    @ApiModelProperty(value = "计时列表")
    private List<PlanInfoVO> timingList;


}
