package com.time.manager.cms.api.feign;

import com.time.manage.common.core.utils.R;
import com.time.manager.cms.api.dto.UserInfoDTO;
import com.time.manager.cms.api.fallback.UserFeignClientImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wlj
 **/
@FeignClient(contextId = "UserFeignClient", value = "time-manager-cms", fallbackFactory = UserFeignClientImpl.class)
public interface UserFeignClient {


    @GetMapping("/api/user/find/username")
    @ApiOperation("查询用户名")
    R<UserInfoDTO> findByName(@RequestParam("userName") String userName);

}
