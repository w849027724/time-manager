package com.time.manager.cms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wlj
 **/
@Getter
@AllArgsConstructor
public enum PlanTypeEnum {

    /**
     * 计划类型 0：打卡  2：倒计时 3：长计划
     */
    CLOCK_IN(0, "打卡"),
    COUNT_DOWN(1, "倒计时"),
    LONG_PLAN(2, "长计划"),
    ;

    private final Integer type;
    private final String describe;

}
