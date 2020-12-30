/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.rule.nacos;

/**
 * @author Eric Zhao
 * @since 1.4.0
 */
public final class NacosConfigUtil {

    public static final String GROUP_ID = "SENTINEL_GROUP";

    /**
     * 流控
     */
    public static final String FLOW_DATA_ID_POSTFIX = "-flow-rules";

    /**
     * 降级
     */
    public static final String DEGRADE_DATA_ID_POSTFIX = "-degrade-rules";

    /**
     * 热点
     */

    public static final String PARAM_DATA_ID_POSTFIX = "-param-rules";

    /**
     * 系统
     */
    public static final String SYSTEM_DATA_ID_POSTFIX = "-system-rules";

    /**
     * 授权
     */
    public static final String AUTHORITY_DATA_ID_POSTFIX = "-authority-rules";


    private NacosConfigUtil() {
    }
}
