package com.time.manager.cms.enums;

import cn.hutool.core.util.ObjectUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wlj
 **/
@Getter
@AllArgsConstructor
public enum PlanFrequencyTypeEnum {

    /**
     *
     */
    ONCE(0, "一次"),
    DAILY(1, "每日"),
    WORKING_DAY(2, "工作日"),
    NON_WORKING_DAY(3, "非工作日"),
    CUSTOMIZE(4, "自定义"),
    ;

    private final Integer type;
    private final String describe;

    public static PlanFrequencyTypeEnum getEnumByType(Integer type) {
        if (ObjectUtil.isNotEmpty(type)) {
            for (PlanFrequencyTypeEnum value : values()) {
                if (type.equals(value.getType())) {
                    return value;
                }
            }
        }
        return null;
    }


}
