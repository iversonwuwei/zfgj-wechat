package com.dlfc.services.message.repository;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dlfc-datacenter-system")
public interface MessageRService {

    @RequestMapping(value = "/wc/datas/sysMessage/findByReceiverUid", method = RequestMethod.GET)
    String findMessages(@RequestParam(name = "receiverUid") String receiverUid);
}
