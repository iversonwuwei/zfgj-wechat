package com.dlfc.services.contract.service.impl;

import com.dlfc.admin.common.utils.DateUtils;
import com.dlfc.admin.common.utils.StringUtils;
import com.dlfc.services.contract.service.DateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by K on 6/20/17.
 */

@Service
@Transactional
public class DateServiceImpl implements DateService {

    @Override
    public Date getEndDate(Date startDate,
                           Integer years,
                           Integer months) {
        if (null != startDate
                && null != years
                && null != months) {
            // 起始日期（号）
            String dayStart = DateUtils.formatDate(startDate).substring(8);
            Date endDate = DateUtils.addMonths(startDate, years * 12 + months);
            // 结束日期（号）
            String dayEnd = DateUtils.formatDate(endDate).substring(8);
            if (StringUtils.isNotEmpty(dayStart)
                    && StringUtils.isNotEmpty(dayEnd)
                    && dayStart.compareTo(dayEnd) > 0) {
                // 结束日期为小月月底的时候 取最后一天为结束日期
                return endDate;
            }
            return DateUtils.addDays(endDate, -1);
        }
        return null;
    }
}
