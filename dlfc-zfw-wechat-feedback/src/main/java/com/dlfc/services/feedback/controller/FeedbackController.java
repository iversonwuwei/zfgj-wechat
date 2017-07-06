package com.dlfc.services.feedback.controller;


import com.dlfc.admin.common.utils.StringUtils;
import com.dlfc.services.feedback.convertor.CmsGuestBookConvertor;
import com.dlfc.services.feedback.dto.FeedbackDTO;
import com.dlfc.services.feedback.repository.UserInfoRService;
import com.dlfc.services.feedback.service.CmsGuestbookService;
import com.dlfc.services.feedback.service.UsrPersonService;
import com.dlfc.zfw.wechat.entities.entity.CmsGuestbook;
import com.dlfc.zfw.wechat.entities.entity.SysPerson;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
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

    @RequestMapping(method = RequestMethod.POST)
    public ResultDTO feedback(@RequestBody FeedbackDTO feedbackDTO, @RequestHeader String token, HttpServletRequest httpRequest) {
        AjaxResult user;
        UsrUser usrUser;
        SysPerson sysPerson;
        try {
            user = principalService.principal(token);
            usrUser = userInfoRService.findUserByUser(user.getData().toString().substring(0, 11));
            if (usrUser != null) {
                //sysPerson = usrPersonService.findById(usrUser.getPerId());
                feedbackDTO.setUid(usrUser.getId());
                feedbackDTO.setName(usrUser.getUsername());
                /*if (sysPerson != null) {
                    feedbackDTO.setName(sysPerson.getName());
                }*/
                feedbackDTO.setIp(StringUtils.getRemoteAddr(httpRequest));
                feedbackDTO.setPhoneNumber(usrUser.getMobile());
            }
        }catch (Exception e){
            if (e.getMessage().contains("认证失效")){
                ResultError resultError = new ResultError();
                resultError.setErrmsg("认证失效");
                resultError.setErrcode("250");
                return ResultDTO.failure(resultError);
            }else {
                ResultError resultError = new ResultError();
                resultError.setErrmsg("请重新登录！");
                resultError.setErrcode("280");
                return ResultDTO.failure(resultError);
            }
        }
        CmsGuestbook usrFeedback = cmsGuestBookConvertor.toModel(feedbackDTO);
        String id = cmsGuestbookService.save(usrFeedback, usrUser);
        if (id == null) {
            return ResultDTO.failure();
        }
        return ResultDTO.success(id);
    }
}
