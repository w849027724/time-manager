package com.time.manager.system.service.impl;

import com.time.manager.system.entity.SysUser;
import com.time.manager.system.mapper.SysUserMapper;
import com.time.manager.system.service.SysUserService;
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
 * @Title: SysUserService
 * @date 2020-12-23
 */
@Slf4j
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
