package com.dlfc.services.feedback.convertor;

import com.dlfc.services.feedback.dto.FeedbackDTO;
import com.dlfc.services.feedback.enums.FeedBackEnum;
import com.dlfc.zfw.wechat.entities.entity.CmsGuestbook;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by walden on 17-7-6.
 */
@Component
public class CmsGuestBookConvertor extends AbstractConvertor<CmsGuestbook, FeedbackDTO>{
    @Override
    public CmsGuestbook toModel(FeedbackDTO feedbackDTO) {
        CmsGuestbook cmsGuestbook = new CmsGuestbook();
        cmsGuestbook.setName(feedbackDTO.getName());
        cmsGuestbook.setIp(feedbackDTO.getIp());
        cmsGuestbook.setContent(feedbackDTO.getFeedback());
        cmsGuestbook.setPhone(feedbackDTO.getPhoneNumber());
        cmsGuestbook.setCreateDate(new Date().getTime());
        cmsGuestbook.setType(FeedBackEnum.HOUSECENTER_WeChat.getValue());
        return cmsGuestbook;
    }

    @Override
    public FeedbackDTO toDTO(CmsGuestbook cmsGuestbook, Object... objects) {
        return null;
    }
}
