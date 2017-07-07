package com.dlfc.services.feedback.repository;

import com.dlfc.zfw.wechat.entities.entity.CmsGuestbook;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by walden on 17-7-6.
 */
@FeignClient("dlfc-datacenter-user")
public interface CmsGuestbookRService {

    @RequestMapping(value = "/wc/datas/cmsGuestbook/save", method = RequestMethod.POST)
    String save(@RequestBody CmsGuestbook entity);
}
