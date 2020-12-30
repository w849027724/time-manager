
package com.time.manager.wallet.api.fallback;


import com.time.manage.common.core.utils.R;
import com.time.manager.wallet.api.feign.WalletFeignClient;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wlj
 */
@Slf4j
@Component
public class WalletFeignClientImpl implements WalletFeignClient {
    @Setter
    private Throwable cause;

    @Override
    public R decWallet() {
        return null;
    }
}
