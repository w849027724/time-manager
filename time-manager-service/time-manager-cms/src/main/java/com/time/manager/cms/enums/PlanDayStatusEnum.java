package com.time.manager.cms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wlj
 **/
@Getter
@AllArgsConstructor
public enum PlanDayStatusEnum {

    /**
     * 计划状态 1：未开始  2：进行中 3：未完成 4：已完成
     */
    UN_START(1, "未开始"),
    RUNNING(2, "进行中"),
    UN_FINISH(3, "未完成"),
    FINISH(4, "已完成"),
    ;

    private final Integer type;
    private final String describe;

}
