package com.time.manager.cms.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.mybatis.service.BaseServiceImpl;
import com.time.manager.cms.entity.UserStat;
import com.time.manager.cms.mapper.UserStatMapper;
import com.time.manager.cms.service.UserStatService;
import com.time.manager.cms.vo.UserStatVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
@RequiredArgsConstructor
public class UserStatServiceImpl extends BaseServiceImpl<UserStatMapper, UserStat> implements UserStatService {
    private final UserStatMapper userStatMapper;


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

    @Override
    public List<UserStatVO> getFabList() {
        return userStatMapper.fabList();
    }

    @Override
    public List<UserStatVO> getFinishList() {
        return userStatMapper.finishList();
    }

    @Override
    public List<UserStatVO> getTotalList() {
        return userStatMapper.totalList();
    }
}
