package com.dlfc.services.feedback.controller;


import com.dlfc.admin.common.utils.StringUtils;
import com.dlfc.services.feedback.convertor.CmsGuestBookConvertor;
import com.dlfc.services.feedback.dto.FeedbackDTO;
import com.dlfc.services.feedback.repository.UserInfoRService;
import com.dlfc.services.feedback.repository.ValidateRService;
import com.dlfc.services.feedback.service.CmsGuestbookService;
import com.dlfc.services.feedback.service.UsrPersonService;
import com.dlfc.zfw.wechat.entities.dto.UserDTO;
import com.dlfc.zfw.wechat.entities.entity.CmsGuestbook;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/ww/feedbacks")
public class FeedbackController {
    @Autowired
    private PrincipalService principalService;
    @Autowired
    private UserInfoRService userInfoRService;
    @Autowired
    private CmsGuestBookConvertor cmsGuestBookConvertor;
    @Autowired
    private UsrPersonService usrPersonService;
    @Autowired
    private CmsGuestbookService cmsGuestbookService;
    @Autowired
    private ValidateRService validateRService;

    @RequestMapping(method = RequestMethod.POST)
    public ResultDTO feedback(@RequestBody FeedbackDTO feedbackDTO, @RequestHeader String token, HttpServletRequest httpRequest) {
        UsrUser usrUser;
        ResultDTO<UserDTO> result = validateRService.validateUserBy(token);
        usrUser = userInfoRService.findUserById(result.getData().getId());
        if (usrUser != null) {
            feedbackDTO.setUid(usrUser.getId());
            feedbackDTO.setName(usrUser.getUsername());
            feedbackDTO.setIp(StringUtils.getRemoteAddr(httpRequest));
            feedbackDTO.setPhoneNumber(usrUser.getMobile());
        }
        CmsGuestbook usrFeedback = cmsGuestBookConvertor.toModel(feedbackDTO);
        String id = cmsGuestbookService.save(usrFeedback, usrUser);
        if (id == null) {
            return ResultDTO.failure();
        }
        return ResultDTO.success(id);
    }

    private String getMobile(String user) {
        if (user != null && user.length() >= 12) {
            user = user.substring(0, 11);
            return user;
        } else {
            return user;
        }
    }
}
