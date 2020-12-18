package com.time.manager.wallet.service.impl;

import com.time.manager.wallet.entity.Wallet;
import com.time.manager.wallet.mapper.WalletMapper;
import com.time.manager.wallet.service.WalletService;
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
 * @Title: WalletService
 * @date 2020-12-18
 */
@Slf4j
@Service
public class WalletServiceImpl extends BaseServiceImpl<WalletMapper, Wallet> implements WalletService {

}
