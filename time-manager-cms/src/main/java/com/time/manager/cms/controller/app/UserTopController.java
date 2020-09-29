package com.time.manager.cms.controller.app;

import com.time.manage.common.core.utils.R;
import com.time.manager.cms.security.IgnoreToken;
import com.time.manager.cms.security.SecurityUtils;
import com.time.manager.cms.service.UserStatService;
import com.time.manager.cms.vo.PlanTopListVO;
import com.time.manager.cms.vo.UserStatVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wlj
 **/
@RestController
@RequestMapping("/app/user/top")
@Api(tags = "app用户排行榜管理")
@RequiredArgsConstructor
public class UserTopController {
    private final UserStatService userStatService;

    @IgnoreToken
    @GetMapping("/list")
    @ApiOperation("用户排行榜")
    public R<PlanTopListVO> list() {
        PlanTopListVO result = new PlanTopListVO();
        List<UserStatVO> finishList = userStatService.getFinishList();
        List<UserStatVO> fabList = userStatService.getFabList();
        List<UserStatVO> totalList = userStatService.getTotalList();
        result
                .setFabList(fabList)
                .setFinishList(finishList)
                .setTotalList(totalList);
        return R.ok(result);
    }

}
