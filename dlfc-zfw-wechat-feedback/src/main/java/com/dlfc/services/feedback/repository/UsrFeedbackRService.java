package com.dlfc.services.feedback.repository;

import com.dlfc.services.feedback.entity.CmsGuestbook;
import com.dlfc.services.feedback.entity.UsrFeedback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "dlfc-datacenter-user")
public interface UsrFeedbackRService {

    @RequestMapping(value = "/wc/datas/cmsGuestbook/save", method = RequestMethod.POST)
    String feedback(@RequestBody CmsGuestbook cmsGuestbook);
}
