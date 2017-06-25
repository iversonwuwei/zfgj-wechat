package com.dlfc.services.collect.controller;

import com.dlfc.services.collect.convertor.HouInfoColletedConvertor;
import com.dlfc.services.collect.dto.HouInfoCollectedDTO;
import com.dlfc.services.collect.dto.UserDTO;
import com.dlfc.services.collect.repository.ValidateRepository;
import com.dlfc.services.collect.service.HouCollectionService;
import com.dlfc.zfw.wechat.entities.entity.UsrHouCollection;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ws/houses/collection")
public class HouInfoCollectedController extends BaseController{

    @Autowired
    private HouCollectionService houCollectionService;
    @Autowired
    private HouInfoColletedConvertor houInfoColletedConvertor;
    @Autowired
    private ValidateRepository validateRepository;

    @RequestMapping(value = "/collected", method = RequestMethod.GET)
    public ListResultDTO<HouInfoCollectedDTO> HouseCollectionList(@RequestHeader String token)
            throws CustomRuntimeException {
        try {
            getUser(token);
            List<UsrHouCollection> houCollections = houCollectionService.findCollectedHouses(user.getId());
            if (houCollections != null) {
                return houInfoColletedConvertor.toResultDTO(houCollections);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.PUT)
    public ResultDTO<Void> cancel(@RequestParam String chid) {
        boolean cancel = houCollectionService.cancelCollect(chid);
        if (cancel) {
            return ResultDTO.success();
        }
        return ResultDTO.failure();
    }

    @RequestMapping(value = "/collect", method = RequestMethod.POST)
    public ResultDTO<Void> collect(@RequestParam String hid,
                                   @RequestHeader String token) {
        String test = validateRepository.validateHouseBy(hid);
        UserDTO userDTO = null;
        getUser(token);
        if (test.contains("success")) {
            UsrHouCollection usrHouCollection = new UsrHouCollection();
            usrHouCollection.setUid(userDTO.getId());
            usrHouCollection.setHid(hid);
            if (houCollectionService.collect(usrHouCollection, user)) {
                return ResultDTO.success();
            }
        }
        return ResultDTO.failure();
    }
}
