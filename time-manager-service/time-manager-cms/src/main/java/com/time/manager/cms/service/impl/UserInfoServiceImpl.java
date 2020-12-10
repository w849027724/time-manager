package com.time.manager.cms.service.impl;

import com.time.manager.cms.entity.UserInfo;
import com.time.manager.cms.mapper.UserInfoMapper;
import com.time.manager.cms.service.UserInfoService;
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
 * @Title: UserInfoService
 * @date 2020-09-09
 */
@Slf4j
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
