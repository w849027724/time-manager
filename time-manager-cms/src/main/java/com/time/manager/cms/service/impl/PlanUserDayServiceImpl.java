package com.time.manager.cms.service.impl;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.time.manage.common.core.utils.R;
import com.time.manage.common.mybatis.service.BaseServiceImpl;
import com.time.manager.cms.entity.PlanInfo;
import com.time.manager.cms.entity.PlanUserDay;
import com.time.manager.cms.enums.PlanFrequencyTypeEnum;
import com.time.manager.cms.mapper.PlanUserDayMapper;
import com.time.manager.cms.service.PlanInfoService;
import com.time.manager.cms.service.PlanUserDayService;
import com.time.manager.cms.service.UserExperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户每日的计划列表服务实现类
 * </p>
 *
 * @author wlj
 * @Title: PlanUserDayService
 * @date 2020-09-18
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PlanUserDayServiceImpl extends BaseServiceImpl<PlanUserDayMapper, PlanUserDay> implements PlanUserDayService {
    private final PlanInfoService planInfoService;
    private final UserExperService userExperService;

    @Override
    public R initDayPlanUserList(Long userId) {
        List<PlanInfo> list = planInfoService.list(Wrappers.<PlanInfo>query()
                .lambda().eq(PlanInfo::getUserId, userId).eq(PlanInfo::getPlanStatus, 0));
        if (list.size() > 0) {
            // 获取今天 yyyy-MM-dd
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String format = LocalDateTime.now().format(df);
            // 获取所有用户今日计划
            Map<Long, List<PlanUserDay>> collect = this.list(Wrappers.<PlanUserDay>query()
                    .lambda()
                    .eq(PlanUserDay::getUserId, userId)
                    .eq(PlanUserDay::getPlanDay, format)).stream()
                    .collect(Collectors.groupingBy(PlanUserDay::getPlanId));
            list.forEach(e -> {
                Long planId = e.getPlanId();
                if (!collect.containsKey(planId)) {

                    switch (Objects.requireNonNull(PlanFrequencyTypeEnum.getEnumByType(e.getPlanFrequencyType()))) {
                        case ONCE:
                            createPlayUserDay(userId, format, e);
                            break;
                        case DAILY:
                            createPlayUserDay(userId, format, e);
                            break;
                        case CUSTOMIZE:
                            // 获取当天星期
                            Date date = new Date();
                            SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
                            String weekDay = dateFm.format(date);
                            // 对比生成记录
                            String planFrequencyDays = e.getPlanFrequencyDays();
                            if (ObjectUtil.isNotEmpty(planFrequencyDays)) {
                                String[] split = planFrequencyDays.split(",");
                                for (String s : split) {
                                    if (ObjectUtil.isNotEmpty(s) && s.equalsIgnoreCase(weekDay)) {
                                        createPlayUserDay(userId, format, e);
                                    }
                                }
                            }
                        default:
                    }
                }
            });
        }
        return R.ok();
    }

    /**
     * 构建每日用户计划   计时打卡复制一条 限时计时时间
     *
     * @param userId
     * @param format
     * @param planInfo
     */
    private void createPlayUserDay(Long userId, String format, PlanInfo planInfo) {
        PlanUserDay planUserDay = new PlanUserDay();
        switch (planInfo.getPlanType()) {
            case 0:
                // 打卡
                planUserDay.setPlanId(planInfo.getPlanId())
                        .setUserId(userId)
                        .setPlanDay(format)
                        .setPlanDayStatus(0);
                this.save(planUserDay);
                break;
            case 1:
                // 倒计时
                planUserDay.setPlanId(planInfo.getPlanId())
                        .setUserId(userId)
                        .setPlanDay(format)
                        .setPlanDayStatus(0);
                this.save(planUserDay);
                break;
            case 2:
                // 长计划
                Long finishDays = LocalDateTimeUtil.between(planInfo.getPlanStartTime(), LocalDateTime.now()).toDays();
                if (finishDays < 0) {
                    finishDays = 0L;
                }
                Long lastDays = LocalDateTimeUtil.between(LocalDateTime.now(), planInfo.getPlanEndTime()).toDays();
                if (lastDays <= 0) {
                    planInfo.setPlanStatus(1);
                    planInfoService.updateById(planInfo);
                    Long totalDays = LocalDateTimeUtil.between(planInfo.getPlanStartTime(), planInfo.getPlanEndTime()).toDays();
                    userExperService.addExper(planInfo.getUserId(), totalDays.intValue() * 100L);
                }
                if (lastDays >= 0) {
                    planUserDay.setPlanId(planInfo.getPlanId())
                            .setUserId(userId)
                            .setPlanDay(format)
                            .setPlanDayStatus(0)
                            .setFinishDay(finishDays.intValue())
                            .setLastDay(lastDays.intValue());
                    if (finishDays > 0) {
                        planUserDay.setPlanDayStatus(1);
                    }
                    this.save(planUserDay);
                }
                break;
            default:
        }
    }
}
