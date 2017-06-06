package com.dlfc.services.feedback.convertor;

import com.dlfc.services.feedback.dto.FeedbackDTO;
import com.dlfc.services.feedback.entity.CmsGuestbook;
import com.dlfc.services.feedback.entity.UsrFeedback;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;


@Component
public class FeedbackConvertor extends AbstractConvertor<CmsGuestbook, FeedbackDTO> {


    @Override
    public CmsGuestbook toModel(FeedbackDTO feedbackDTO) {
        CmsGuestbook cmsGuestbook = new CmsGuestbook();
        cmsGuestbook.setContent(feedbackDTO.getFeedback());
        cmsGuestbook.setId("3c007a5512804d5183d737b4c9e5b26a");
        return cmsGuestbook;
    }

    @Override
    public FeedbackDTO toDTO(CmsGuestbook cmsGuestbook, Object... objects) {
        return null;
    }
}
