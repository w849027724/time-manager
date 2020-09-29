package com.time.manager.cms.service;

import com.time.manage.common.mybatis.service.BaseService;
import com.time.manager.cms.entity.UserStat;
import com.time.manager.cms.vo.UserStatVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wlj
 * @Title: UserStatService
 * @date 2020-09-09
 */
public interface UserStatService extends BaseService<UserStat> {

    void addFabulous(Long userId);

    void addJoins(Long userId);

    void addFinishs(Long userId);

    void addPlans(Long userId);

    List<UserStatVO> getFabList();

    List<UserStatVO> getFinishList();

    List<UserStatVO> getTotalList();
}
