package com.time.manager.system.controller.api.feign;

import com.time.manage.common.core.utils.R;
import com.time.manager.system.controller.api.dto.SysUserDTO;
import com.time.manager.system.controller.api.fallback.SysUserFeignClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wlj
 **/
@FeignClient(contextId = "SysUserFeignClient", value = "time-manager-system", fallbackFactory = SysUserFeignClientImpl.class)
public interface SysUserFeignClient {

    @GetMapping("/api/sys/user/find/username")
    R<SysUserDTO> findByName(@RequestParam("userName") String userName);

}
