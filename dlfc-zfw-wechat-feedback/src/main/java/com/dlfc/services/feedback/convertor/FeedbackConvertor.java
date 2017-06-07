package com.dlfc.services.feedback.convertor;

import com.dlfc.services.feedback.dto.FeedbackDTO;
import com.dlfc.services.feedback.dto.UserDTO;
import com.dlfc.services.feedback.entity.CmsGuestbook;
import com.dlfc.services.feedback.entity.UsrFeedback;
import com.dlfc.services.feedback.repository.UserInfoRService;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FeedbackConvertor extends AbstractConvertor<UsrFeedback, FeedbackDTO> {

    @Override
    public UsrFeedback toModel(FeedbackDTO feedbackDTO) {
        UsrFeedback usrFeedback = new UsrFeedback();
        usrFeedback.setContent(feedbackDTO.getFeedback());
        usrFeedback.setId(feedbackDTO.getUid());
        return usrFeedback;
    }

    @Override
    public FeedbackDTO toDTO(UsrFeedback usrFeedback, Object... objects) {
        return null;
    }
}
