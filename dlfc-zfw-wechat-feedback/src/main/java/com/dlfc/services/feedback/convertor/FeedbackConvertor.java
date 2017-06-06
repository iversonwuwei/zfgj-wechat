package com.dlfc.services.feedback.convertor;

import com.dlfc.services.feedback.dto.FeedbackDTO;
import com.dlfc.services.feedback.entity.CmsGuestbook;
import com.dlfc.services.feedback.entity.UsrFeedback;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;


@Component
public class FeedbackConvertor extends AbstractConvertor<UsrFeedback, FeedbackDTO> {


    @Override
    public UsrFeedback toModel(FeedbackDTO feedbackDTO) {
        UsrFeedback usrFeedback = new UsrFeedback();
        usrFeedback.setContent(feedbackDTO.getFeedback());
        usrFeedback.setId("3c007a5512804d5183d737b4c9e5b26a");
        return usrFeedback;
    }

    @Override
    public FeedbackDTO toDTO(UsrFeedback usrFeedback, Object... objects) {
        return null;
    }
}
