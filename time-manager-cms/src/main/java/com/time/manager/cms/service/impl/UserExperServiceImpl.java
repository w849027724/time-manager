package com.time.manager.cms.service.impl;

import com.time.manager.cms.entity.UserExper;
import com.time.manager.cms.mapper.UserExperMapper;
import com.time.manager.cms.service.UserExperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.time.manage.common.mybatis.service.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;

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
public class UserExperServiceImpl extends BaseServiceImpl<UserExperMapper, UserExper> implements UserExperService {

}
