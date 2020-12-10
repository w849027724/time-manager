package com.time.manager.cms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wlj
 **/
@Getter
@AllArgsConstructor
public enum PlanStatusEnum {

    /**
     * 计划状态
     */
    NOT_START(0, "未开始"),
    FINISH(1, "已结束"),
    ;

    private final Integer type;
    private final String describe;
}
