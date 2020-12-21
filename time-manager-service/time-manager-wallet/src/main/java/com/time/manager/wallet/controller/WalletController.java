package com.time.manager.wallet.controller;

import com.time.manage.common.core.utils.R;
import com.time.manager.security.annotation.Ignore;
import com.time.manager.wallet.entity.Wallet;
import com.time.manager.wallet.service.WalletService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wlj
 **/
@RestController
@RequestMapping("/wallet")
@Api(tags = "api钱包")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @Ignore
    @GetMapping("/dec")
    @ApiOperation("递减")
    public R decWallet() {
        List<Wallet> list = walletService.list();
        Wallet wallet = list.get(0);
        wallet.setWalletNum(999);
        walletService.updateById(wallet);
        return R.ok();
    }


}
