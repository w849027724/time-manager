package com.time.manager.cms.service.impl;

import com.time.manager.cms.entity.MessageInfo;
import com.time.manager.cms.mapper.MessageInfoMapper;
import com.time.manager.cms.service.MessageInfoService;
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
 * @Title: MessageInfoService
 * @date 2020-09-09
 */
@Slf4j
@Service
public class MessageInfoServiceImpl extends BaseServiceImpl<MessageInfoMapper, MessageInfo> implements MessageInfoService {

}
