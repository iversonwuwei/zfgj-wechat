package com.dlfc.services.contract.repository;

import com.dlfc.zfw.wechat.entities.entity.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    String saveConHouseUserChildren(@RequestBody ConHouseUserChildren conHouseUserChildren);

    @RequestMapping(value = "/wc/datas/conContract/findById", method = RequestMethod.GET)
    ConContract findConContractById(@RequestParam(name = "id") String id);

    @RequestMapping(value = "/wc/datas/conHouseUser/findByLid", method = RequestMethod.GET)
    List<ConHouseUser> findConHouseUserByLid(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/conHouseUserChildren/findByLid", method = RequestMethod.GET)
    List<ConHouseUserChildren> findConHouseUserChildrenByLid(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/conHouseItems/save", method = RequestMethod.POST)
    String saveConHouseItems(@RequestBody ConHouseItems conHouseItems);

    @RequestMapping(value = "/wc/datas/conOtherCosts/save", method = RequestMethod.POST)
    String saveConOtherCosts(@RequestBody ConOtherCosts conOtherCosts);

    @RequestMapping(value = "/wc/datas/conHouseItems/findByLid", method = RequestMethod.GET)
    List<ConHouseItems> findConHouseItemsByLid(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/conOtherCosts/findByLid", method = RequestMethod.GET)
    List<ConOtherCosts> findConOtherCostsByLid(@RequestParam(name = "lid") String lid);

    @RequestMapping(value = "/wc/datas/conContract/findByPidAndStatuses", method = RequestMethod.GET)
    List<ConContract> findByPidAndStatuses(@RequestParam(name = "pid") String pid,
                                           @RequestParam(name = "statuses")  Short[] statuses);

    @RequestMapping(value = "/wc/datas/conContract/updateById", method = RequestMethod.POST)
    String updateConContractById(@RequestBody ConContract conContract);
}
