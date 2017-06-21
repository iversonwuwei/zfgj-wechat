package com.dlfc.services.date.service.impl;

import com.dlfc.services.date.service.DateService;
import com.housecenter.dlfc.framework.common.util.DateUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by K on 6/20/17.
 */

@Service
public class DateServiceImpl implements DateService {

    @Override
    public Date getEndDate(Date startDate,
                           Integer years,
                           Integer months) {
        if (null != startDate
                && null != years
                && null != months) {
            return DateUtils.addMonths(startDate, years * 12 + months);
        }
        return null;
    }
}
