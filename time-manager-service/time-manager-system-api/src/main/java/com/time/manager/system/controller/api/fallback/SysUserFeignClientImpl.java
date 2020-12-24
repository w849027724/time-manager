package com.time.manager.system.controller.api.fallback;

import com.time.manage.common.core.utils.R;
import com.time.manager.system.controller.api.dto.SysUserDTO;
import com.time.manager.system.controller.api.feign.SysUserFeignClient;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wlj
 **/
@Slf4j
@Component
public class SysUserFeignClientImpl implements SysUserFeignClient {
    @Setter
    private Throwable cause;

    @Override
    public R<SysUserDTO> findByName(String userName) {
        return null;
    }
}
