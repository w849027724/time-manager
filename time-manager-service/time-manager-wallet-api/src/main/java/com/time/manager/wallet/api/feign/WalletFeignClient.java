package com.time.manager.wallet.api.feign;

import com.time.manage.common.core.utils.R;
import com.time.manager.wallet.api.fallback.WalletFeignClientImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wlj
 **/
@FeignClient(contextId = "WalletFeignClient", value = "time-manager-wallet", fallbackFactory = WalletFeignClientImpl.class)
public interface WalletFeignClient {

    @GetMapping("/wallet/dec")
    @ApiOperation("递减")
    R decWallet();

}
