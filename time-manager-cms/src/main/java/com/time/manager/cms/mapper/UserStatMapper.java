package com.time.manager.cms.mapper;

import com.time.manager.cms.entity.UserStat;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.time.manager.cms.vo.UserStatVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wlj
 * @Title: UserStatService
 * @date 2020-09-09
 */
@Mapper
public interface UserStatMapper extends BaseMapper<UserStat> {

    List<UserStatVO> fabList();

    List<UserStatVO> finishList();

    List<UserStatVO> totalList();
}
