package com.dlfc.services.feedback.controller;


import com.dlfc.services.feedback.convertor.FeedbackConvertor;
import com.dlfc.services.feedback.dto.FeedbackDTO;
import com.dlfc.services.feedback.entity.CmsGuestbook;
import com.dlfc.services.feedback.entity.UsrFeedback;
import com.dlfc.services.feedback.repository.UserInfoRService;
import com.dlfc.services.feedback.service.FeedbackService;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ww/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackConvertor feedbackConvertor;
    @Autowired
    private FeedbackService<UsrFeedback> feedbackFeedbackService;
    @Autowired
    private PrincipalService principalService;
    @Autowired
    private UserInfoRService userInfoRService;

    @RequestMapping(method = RequestMethod.POST)
    public ResultDTO<Void> feedback(@RequestBody FeedbackDTO feedbackDTO, @RequestHeader String token){
        AjaxResult user = principalService.principal(token);
        String uid = userInfoRService.findUserByUser(user.getData().toString());
        feedbackDTO.setUid(uid);
        UsrFeedback usrFeedback = feedbackConvertor.toModel(feedbackDTO);
        String id = (String) feedbackFeedbackService.feedback(usrFeedback);
        if (id == null){
            return ResultDTO.failure();
        }
        return ResultDTO.success();
    }
}
