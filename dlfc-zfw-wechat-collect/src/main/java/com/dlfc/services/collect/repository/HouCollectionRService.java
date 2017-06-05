package com.dlfc.services.collect.repository;

import com.dlfc.services.collect.entity.UsrHouCollection;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Request;

@FeignClient("dlfc-datacenter-user")
public interface HouCollectionRService {

    @RequestMapping(value = "/wc/datas/usrHouCollection/findAllByUid", method = RequestMethod.GET)
    String findCollectedHouses(@RequestParam(name = "uid") String uid);

    @RequestMapping(value = "/wc/datas/usrHouCollection/removeById", method = RequestMethod.DELETE)
    String cancelCollect(@RequestParam(name = "id") String id);

    @RequestMapping(value = "/wc/datas/usrHouCollection/saveOrUpdate", method = RequestMethod.POST)
    String collect(@RequestBody UsrHouCollection usrHouCollection);
}
