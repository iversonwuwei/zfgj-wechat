package com.dlfc.services.feedback.convertor;

import com.dlfc.services.feedback.dto.FeedbackDTO;
import com.dlfc.services.feedback.entity.UsrFeedback;
import com.dlfc.services.feedback.enums.FeedBackEnum;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;


@Component
public class FeedbackConvertor extends AbstractConvertor<UsrFeedback, FeedbackDTO> {

    @Override
    public UsrFeedback toModel(FeedbackDTO feedbackDTO) {
        UsrFeedback usrFeedback = new UsrFeedback();
        usrFeedback.setContent(feedbackDTO.getFeedback());
        usrFeedback.setId(feedbackDTO.getUid());
        usrFeedback.setResource(FeedBackEnum.HOUSECENTER_WeChat.getValue());
        return usrFeedback;
    }

    @Override
    public FeedbackDTO toDTO(UsrFeedback usrFeedback, Object... objects) {
        return null;
    }
}
