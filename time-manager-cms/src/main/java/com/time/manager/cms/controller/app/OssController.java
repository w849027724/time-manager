package com.time.manager.cms.controller.app;

import cn.hutool.json.JSONUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.entity.UserInfo;
import com.time.manager.cms.security.IgnoreToken;
import com.time.manager.cms.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author wlj
 **/
@RestController
@RequestMapping("/app/file")
@Api(tags = "app文件上传下载")
@RequiredArgsConstructor
public class OssController {

    private final UserInfoService userInfoService;

    private final String accessKey = "EatQqOzHO1lF8VM4zrSWslJbVP2cNoXQZc5gmx0B";
    private final String secretKey = "HUbRuu9psx5HvThVDxW6XC-302NlgS8LmCC1o6-4";
    private final String bucket = "modengpig";

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
    public R findFabulous(@RequestParam("file") MultipartFile file, @RequestParam("userId") String userId) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huanan());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = UUID.randomUUID().toString();
        String path = "";
        try {
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(file.getInputStream(), key, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = JSONUtil.toBean(response.bodyString(), DefaultPutRet.class);
                path = putRet.key;

                UserInfo byId = userInfoService.getById(userId);
                byId.setUserAvatar(path);
                userInfoService.updateById(byId);

            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            //ignore
        }
        return R.ok(path);
    }


}
