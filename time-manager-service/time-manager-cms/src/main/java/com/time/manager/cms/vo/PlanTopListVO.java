package com.time.manager.cms.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author wlj
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "排行榜信息vo", description = "")
public class PlanTopListVO implements Serializable {

    private List<UserStatVO> fabList;
    private List<UserStatVO> finishList;
    private List<UserStatVO> totalList;


}
