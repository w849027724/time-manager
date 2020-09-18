package com.time.manage.common.core.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wlj
 **/
@Slf4j
public class HolidayUtil {

    /**
     * 正常工作日对应结果为 0
     */
    public static final String DAY_STATUS_0 = "0";
    /**
     * 法定节假日对应结果为 1
     */
    public static final String DAY_STATUS_1 = "1";
    /**
     * 节假日调休补班对应的结果为 2
     */
    public static final String DAY_STATUS_2 = "2";
    /**
     * 休息日对应结果为 3
     */
    public static final String DAY_STATUS_3 = "3";


    /**
     * @return 工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2
     */
    public static Boolean request() {
        return true;
    }


    public static void main(String[] args) {
        Boolean request = HolidayUtil.request();
    }


}
