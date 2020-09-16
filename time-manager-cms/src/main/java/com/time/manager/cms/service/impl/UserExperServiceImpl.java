package com.time.manager.cms.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.mybatis.service.BaseServiceImpl;
import com.time.manager.cms.entity.LabelInfo;
import com.time.manager.cms.entity.UserExper;
import com.time.manager.cms.mapper.UserExperMapper;
import com.time.manager.cms.service.LabelInfoService;
import com.time.manager.cms.service.UserExperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 经验和计划的秒数挂钩服务实现类
 * </p>
 *
 * @author wlj
 * @Title: UserExperService
 * @date 2020-09-09
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserExperServiceImpl extends BaseServiceImpl<UserExperMapper, UserExper> implements UserExperService {
    private final LabelInfoService labelInfoService;

    @Override
    public void addExper(Long userId, Long planSecond) {
        UserExper userExper = this.getOne(Wrappers.<UserExper>query().lambda().eq(UserExper::getUserId, userId));
        userExper.setUserExper(userExper.getUserExper() + planSecond);
        this.updateById(userExper);

        LabelInfo labelInfo = labelInfoService.getOne(Wrappers.<LabelInfo>query().lambda().eq(LabelInfo::getLabelCode, userExper.getLabelCode()));
        if (labelInfo.getLabelEndExper() <= userExper.getUserExper()) {
            // 更新标签
            LabelInfo one = labelInfoService.getOne(Wrappers.<LabelInfo>query()
                    .lambda()
                    .gt(LabelInfo::getLabelStatExper, userExper.getUserExper())
                    .lt(LabelInfo::getLabelStatExper, userExper.getUserExper()));
            userExper.setLabelCode(one.getLabelCode());
        }
    }
}
