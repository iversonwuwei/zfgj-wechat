package com.dlfc.services.contract.repository;

import entity.ConContract;
import entity.ConHouseUser;
import entity.ConHouseUserChildren;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by K on 6/19/17.
 */

@FeignClient("dlfc-datacenter-contract")
public interface ContractRService {

    @RequestMapping(value = "/wc/datas/conContract/save", method = RequestMethod.POST)
    String saveContract(@RequestBody ConContract conContract);

    @RequestMapping(value = "/wc/datas/conHouseUser/save", method = RequestMethod.POST)
    String saveConHouseUser(@RequestBody ConHouseUser conHouseUser);

    @RequestMapping(value = "/wc/datas/conHouseUserChildren/save", method = RequestMethod.POST)
    String saveConHouseUserChildren(ConHouseUserChildren conHouseUserChildren);
}
