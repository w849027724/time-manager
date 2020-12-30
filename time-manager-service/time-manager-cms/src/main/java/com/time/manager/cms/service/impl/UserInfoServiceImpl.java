package com.time.manager.cms.service.impl;

import com.time.manage.common.mybatis.service.BaseServiceImpl;
import com.time.manager.cms.entity.MessageInfo;
import com.time.manager.cms.entity.UserInfo;
import com.time.manager.cms.mapper.UserInfoMapper;
import com.time.manager.cms.service.MessageInfoService;
import com.time.manager.cms.service.UserInfoService;
import com.time.manager.wallet.api.feign.WalletFeignClient;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
@RequiredArgsConstructor
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    private final MessageInfoService messageInfoService;
    private final WalletFeignClient walletFeignClient;

    @Override
    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public void testSeata() {
        List<MessageInfo> list = messageInfoService.list();
        MessageInfo messageInfo = list.get(0).setMessageValue("222");
        messageInfoService.updateById(messageInfo);
        walletFeignClient.decWallet();
    }
}
