package com.time.manager.cms.service;

import com.time.manage.common.core.utils.R;
import com.time.manage.common.mybatis.service.BaseService;
import com.time.manager.cms.entity.PlanUserDay;

/**
 * <p>
 * 用户每日的计划列表服务类
 * </p>
 *
 * @author wlj
 * @Title: PlanUserDayService
 * @date 2020-09-18
 */
public interface PlanUserDayService extends BaseService<PlanUserDay> {


    /**
     * 初始化 每日计划
     *
     * @param userId
     * @return
     */
    R initDayPlanUserList(Long userId);
}
