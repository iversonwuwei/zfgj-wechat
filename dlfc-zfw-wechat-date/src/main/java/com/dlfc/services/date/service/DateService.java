package com.dlfc.services.date.service;

import java.util.Date;

/**
 * Created by K on 6/20/17.
 */
public interface DateService {
    Date getEndDate(Date startDate, Integer years, Integer months);
}
