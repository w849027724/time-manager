package com.time.manager.cms.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.mybatis.service.BaseServiceImpl;
import com.time.manager.cms.entity.UserStat;
import com.time.manager.cms.mapper.UserStatMapper;
import com.time.manager.cms.service.UserStatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wlj
 * @Title: UserStatService
 * @date 2020-09-09
 */
@Slf4j
@Service
public class UserStatServiceImpl extends BaseServiceImpl<UserStatMapper, UserStat> implements UserStatService {

    @Override
    public void addFabulous(Long userId) {
        UserStat one = this.getOne(Wrappers.<UserStat>query().lambda().eq(UserStat::getUserId, userId));
        if (ObjectUtil.isNotEmpty(one)) {
            one.setPlanFabulous(one.getPlanFabulous() + 1);
            this.updateById(one);
        }
    }

    @Override
    public void addJoins(Long userId) {
    }

    @Override
    public void addFinishs(Long userId) {
        UserStat one = this.getOne(Wrappers.<UserStat>query().lambda().eq(UserStat::getUserId, userId));
        if (ObjectUtil.isNotEmpty(one)) {
            one.setPlanFinish(one.getPlanFinish() + 1);
            this.updateById(one);
        }
    }

    @Override
    public void addPlans(Long userId) {
        UserStat one = this.getOne(Wrappers.<UserStat>query().lambda().eq(UserStat::getUserId, userId));
        if (ObjectUtil.isNotEmpty(one)) {
            one.setPlanTotal(one.getPlanTotal() + 1);
            this.updateById(one);
        }
    }
}
