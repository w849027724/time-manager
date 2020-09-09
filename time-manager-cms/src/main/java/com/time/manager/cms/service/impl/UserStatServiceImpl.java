package com.time.manager.cms.service.impl;

import com.time.manager.cms.entity.UserStat;
import com.time.manager.cms.mapper.UserStatMapper;
import com.time.manager.cms.service.UserStatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.time.manage.common.mybatis.service.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;

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

}
