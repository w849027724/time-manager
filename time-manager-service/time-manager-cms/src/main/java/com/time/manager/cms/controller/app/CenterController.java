package com.time.manager.cms.controller.app;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.entity.LabelInfo;
import com.time.manager.cms.entity.UserExper;
import com.time.manager.cms.entity.UserStat;
import com.time.manager.cms.service.LabelInfoService;
import com.time.manager.cms.service.UserExperService;
import com.time.manager.cms.service.UserStatService;
import com.time.manager.cms.vo.UserExperVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wlj
 **/
@RestController
@RequestMapping("/app/center")
@Api(tags = "app我的管理")
@RequiredArgsConstructor
public class CenterController {
    private final UserExperService userExperService;
    private final UserStatService userStatService;
    private final LabelInfoService labelInfoService;


    @GetMapping("/exper")
    @ApiOperation("获取用户经验")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "userId", required = true, dataType = "Long", paramType = "query")
    })
    public R<UserExperVO> getUserExper(
            @RequestParam("userId") Long userId
    ) {
        UserExperVO userExperVO = new UserExperVO();
        UserExper one = userExperService.getOne(Wrappers.<UserExper>query().lambda().eq(UserExper::getUserId, userId));
        BeanUtils.copyProperties(one, userExperVO);
        String labelCode = one.getLabelCode();
        LabelInfo labelInfo = labelInfoService.getOne(Wrappers.<LabelInfo>query().lambda().eq(LabelInfo::getLabelCode, labelCode));
        if (ObjectUtil.isNotEmpty(labelInfo)) {
            BeanUtils.copyProperties(labelInfo, userExperVO);
        }
        return R.ok(userExperVO);
    }


    @GetMapping("/stat")
    @ApiOperation("获取用户统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "userId", required = true, dataType = "Long", paramType = "query")
    })
    public R getUserStat(
            @RequestParam("userId") Long userId
    ) {
        UserStat one = userStatService.getOne(Wrappers.<UserStat>query().lambda().eq(UserStat::getUserId, userId));
        return R.ok(one);
    }

}
