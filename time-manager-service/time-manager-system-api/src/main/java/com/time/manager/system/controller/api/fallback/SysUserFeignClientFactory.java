package com.time.manager.system.controller.api.fallback;


import com.time.manager.system.controller.api.feign.SysUserFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author wlj
 */
@Component
public class SysUserFeignClientFactory implements FallbackFactory<SysUserFeignClient> {

    @Override
    public SysUserFeignClient create(Throwable throwable) {
        SysUserFeignClientImpl remoteUserServiceFallback = new SysUserFeignClientImpl();
        remoteUserServiceFallback.setCause(throwable);
        return remoteUserServiceFallback;
    }
}
