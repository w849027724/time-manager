package com.time.manager.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.time.manager.system.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wlj
 * @Title: SysUserService
 * @date 2020-12-23
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
