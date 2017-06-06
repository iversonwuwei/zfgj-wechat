package com.dlfc.services.feedback.controller;


import com.dlfc.services.feedback.convertor.FeedbackConvertor;
import com.dlfc.services.feedback.dto.FeedbackDTO;
import com.dlfc.services.feedback.entity.UsrFeedback;
import com.dlfc.services.feedback.service.FeedbackService;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ww/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackConvertor feedbackConvertor;
    @Autowired
    private FeedbackService<UsrFeedback> feedbackFeedbackService;

    @RequestMapping(method = RequestMethod.POST)
    public ResultDTO<Void> feedback(@RequestBody FeedbackDTO feedbackDTO){
        UsrFeedback usrFeedback = feedbackConvertor.toModel(feedbackDTO);
        String id = (String) feedbackFeedbackService.feedback(usrFeedback);
        if (id == null){
            return ResultDTO.failure();
        }
        return ResultDTO.success();
    }
}
