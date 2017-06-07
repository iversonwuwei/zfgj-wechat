package com.dlfc.services.collect.controller;

import com.dlfc.services.collect.convertor.HouInfoColletedConvertor;
import com.dlfc.services.collect.dto.HouInfoCollectedDTO;
import com.dlfc.services.collect.dto.UserDTO;
import com.dlfc.services.collect.entity.UsrHouCollection;
import com.dlfc.services.collect.repository.HouseRService;
import com.dlfc.services.collect.repository.UserInfoRService;
import com.dlfc.services.collect.repository.ValidateRepository;
import com.dlfc.services.collect.service.HouCollectionService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ws/houses/collection")
public class HouInfoCollectedController {

    @Autowired
    private HouCollectionService houCollectionService;

    @Autowired
    private HouInfoColletedConvertor houInfoColletedConvertor;

    @Autowired
    private ValidateRepository validateRepository;

    @Autowired
    private UserInfoRService userInfoRService;
    @Autowired
    private PrincipalService principalService;
    @Autowired
    private IConvertor<UserDTO> convertor;

    @RequestMapping(value = "/collected", method = RequestMethod.GET)
    public ListResultDTO<HouInfoCollectedDTO> HouseCollectionList(@RequestHeader String token) throws CustomRuntimeException {
        UserDTO userDTO = null;
        try {
            AjaxResult user = principalService.principal(token);
            if (user != null){
                userDTO = convertor.convert2Object(userInfoRService.findUserByUser(user.getData().toString()), UserDTO.class);
            }
            List<UsrHouCollection> houCollections = houCollectionService.findCollectedHouses(userDTO.getId());
            if (houCollections != null) {
                return houInfoColletedConvertor.toResultDTO(houCollections);
            }
        }catch(Exception e){
            return null;
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
