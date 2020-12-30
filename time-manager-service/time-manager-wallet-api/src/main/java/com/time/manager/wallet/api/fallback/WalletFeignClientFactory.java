package com.time.manager.wallet.api.fallback;


import com.time.manager.wallet.api.feign.WalletFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author wlj
 */
@Component
public class WalletFeignClientFactory implements FallbackFactory<WalletFeignClient> {

    @Override
    public WalletFeignClient create(Throwable throwable) {
        WalletFeignClientImpl remoteUserServiceFallback = new WalletFeignClientImpl();
        remoteUserServiceFallback.setCause(throwable);
        return remoteUserServiceFallback;
    }
}
