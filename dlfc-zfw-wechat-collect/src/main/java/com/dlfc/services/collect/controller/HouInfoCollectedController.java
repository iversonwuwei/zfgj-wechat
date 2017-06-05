package com.dlfc.services.collect.controller;

import com.dlfc.services.collect.convertor.HouInfoColletedConvertor;
import com.dlfc.services.collect.dto.HouInfoCollectedDTO;
import com.dlfc.services.collect.entity.UsrHouCollection;
import com.dlfc.services.collect.repository.SysInfoAttRService;
import com.dlfc.services.collect.repository.ValidateRepository;
import com.dlfc.services.collect.service.HouCollectionService;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ws/houses/collection")
public class HouInfoCollectedController {

    @Autowired
    private HouCollectionService houCollectionService;

    @Autowired
    private SysInfoAttRService sysInfoAttRService;

    @Autowired
    private HouInfoColletedConvertor houInfoColletedConvertor;

    @Autowired
    private ValidateRepository validateRepository;

    @RequestMapping(value = "/collected", method = RequestMethod.GET)
    public ListResultDTO<HouInfoCollectedDTO> HouseCollectionList() throws CustomRuntimeException {
        List<UsrHouCollection> houCollections = houCollectionService.findCollectedHouses("0bd68f142f324be59697e14f1e630205");
        if (houCollections != null) {
            return houInfoColletedConvertor.toResultDTO(houCollections);
        }
        return null;
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.PUT)
    public ResultDTO<Void> cancel(@RequestParam String chid){
        boolean cancel = houCollectionService.cancelCollect(chid);

        if (cancel){
            return ResultDTO.success();
        }
        return ResultDTO.failure();
    }

    @RequestMapping(value = "/collect", method = RequestMethod.POST)
    public ResultDTO<Void> collect(@RequestParam String hid){
        String test = validateRepository.validateHouseBy(hid);
        if (test.contains("success")){
            UsrHouCollection usrHouCollection = new UsrHouCollection();
            usrHouCollection.setUid("3c007a5512804d5183d737b4c9e5b26a");
            usrHouCollection.setHid(hid);
            if (houCollectionService.collect(usrHouCollection)){
                return ResultDTO.success();
            }
        }
        return ResultDTO.failure();
    }

}
