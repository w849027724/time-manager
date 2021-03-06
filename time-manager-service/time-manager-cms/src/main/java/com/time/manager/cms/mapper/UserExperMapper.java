package com.time.manager.cms.mapper;

import com.time.manager.cms.entity.UserExper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 经验和计划的秒数挂钩Mapper 接口
 * </p>
 *
 * @author wlj
 * @Title: UserExperService
 * @date 2020-09-09
 */
@Mapper
public interface UserExperMapper extends BaseMapper<UserExper> {

}
