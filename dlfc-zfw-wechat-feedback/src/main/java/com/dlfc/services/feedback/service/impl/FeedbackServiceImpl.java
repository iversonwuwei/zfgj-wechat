package com.dlfc.services.feedback.service.impl;

import com.dlfc.services.feedback.entity.UsrFeedback;
import com.dlfc.services.feedback.repository.UsrFeedbackRService;
import com.dlfc.services.feedback.service.FeedbackService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FeedbackServiceImpl implements FeedbackService<UsrFeedback> {

    @Autowired
    private UsrFeedbackRService usrFeedbackRService;

    @Override
    public String feedback(UsrFeedback usrFeedback) {
        String id = usrFeedbackRService.feedback(usrFeedback);

        return id;
    }
}
