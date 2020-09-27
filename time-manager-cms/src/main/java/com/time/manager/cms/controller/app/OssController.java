package com.time.manager.cms.controller.app;

import com.qiniu.util.Auth;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.security.IgnoreToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wlj
 **/
@RestController
@RequestMapping("/app/file")
@Api(tags = "app文件上传下载")
@RequiredArgsConstructor
public class OssController {

    private String accessKey = "EatQqOzHO1lF8VM4zrSWslJbVP2cNoXQZc5gmx0B";
    private String secretKey = "HUbRuu9psx5HvThVDxW6XC-302NlgS8LmCC1o6-4";
    private String bucket = "modengpig";

    @IgnoreToken
    @GetMapping("/upload/token")
    @ApiOperation("上传图片")
    public R<String> getQiNiuToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        return R.ok(upToken);
    }

    @IgnoreToken
    @PostMapping("/upload/image")
    @ApiOperation("上传图片")
    public R findFabulous(@RequestParam("file") MultipartFile file, String userId) {


        return R.ok();
    }


}
