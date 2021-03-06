package com.dlfc.services.feedback.repository;

import com.dlfc.zfw.wechat.entities.entity.UsrFeedback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "dlfc-datacenter-user")
public interface UsrFeedbackRService {

    @RequestMapping(value = "/wc/datas/usrFeedback/save", method = RequestMethod.POST)
    String feedback(@RequestBody UsrFeedback usrFeedback);
}
