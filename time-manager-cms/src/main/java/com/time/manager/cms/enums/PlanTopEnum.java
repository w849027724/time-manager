package com.time.manager.cms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wlj
 **/
@Getter
@AllArgsConstructor
public enum PlanTopEnum {

    /**
     * 置顶计划  0：不是  1：是
     */
    NO(0, "不是"),
    YES(1, "是"),
    ;

    private final Integer type;
    private final String describe;

}
