package com.dlfc.services.house.repository;

import com.dlfc.services.house.dto.HouLeaseInfoDTO;
import com.dlfc.zfw.wechat.entities.entity.HouLeaseInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dlfc-datacenter-lessee")
public interface LesseeRService {

    @RequestMapping(value = "/wc/datas/houLeaseInfo/findById", method = RequestMethod.GET)
    HouLeaseInfo getLesseeById(@RequestParam(name = "id") String id);

    @RequestMapping(value = "/wc/datas/houLeaseInfo/findByUid", method = RequestMethod.GET)
    String findByUid(@RequestParam(name = "uid") String uid, @RequestParam(name = "orderBy") String orderBy);

    @RequestMapping(value = "/wc/datas/houLeaseInfo/findByParams", method = RequestMethod.POST)
    String findByParams(@RequestBody HouLeaseInfoDTO dto);

    @RequestMapping(value = "/wc/datas/houLeaseInfo/save", method = RequestMethod.POST)
    String save(@RequestBody HouLeaseInfo houLeaseInfo);

    @RequestMapping(value = "/wc/datas/houLeaseInfo/updateById", method = RequestMethod.POST)
    String update(@RequestBody HouLeaseInfo houLeaseInfo);

    @RequestMapping(value = "/wc/datas/houLeaseInfo/findAll", method = RequestMethod.GET)
    String findAll(@RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize,
                   @RequestParam(defaultValue = "1", name = "pageNo") Integer pageNo,
                   @RequestParam(defaultValue = "1", name = "releaseStatus") Integer releaseStatus,
                   @RequestParam(name = "orderBy") String orderBy);

    @RequestMapping(value = "/wc/datas/houLeaseInfo/removeById", method = RequestMethod.DELETE)
    String removeById(@RequestParam(name = "id") String id);
}
