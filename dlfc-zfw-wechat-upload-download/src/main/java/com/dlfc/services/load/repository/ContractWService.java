package com.dlfc.services.load.repository;

import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by K on 6/26/17.
 */

@FeignClient("dlfc-zfw-contract-services")
public interface ContractWService {

    @RequestMapping(value = "/ww/contractSign/lessorSign", method = RequestMethod.GET)
    ResultDTO<Void> lessorSign(@RequestParam(name = "id") String id, @RequestParam(name = "path") String path);

    @RequestMapping(value = "/ww/contractSign/lesseeSign", method = RequestMethod.GET)
    ResultDTO<Void> lesseeSign(@RequestParam(name = "id") String id, @RequestParam(name = "path") String path);
}
