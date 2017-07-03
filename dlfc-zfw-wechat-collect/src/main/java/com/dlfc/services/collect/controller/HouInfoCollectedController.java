package com.dlfc.services.collect.controller;

import com.dlfc.services.collect.controller.base.BaseController;
import com.dlfc.services.collect.convertor.CollectConvertor;
import com.dlfc.services.collect.convertor.HouInfoColletedConvertor;
import com.dlfc.services.collect.dto.HouInfoCollectedDTO;
import com.dlfc.services.collect.repository.ValidateRepository;
import com.dlfc.services.collect.service.HouCollectionService;
import com.dlfc.zfw.wechat.entities.entity.UsrHouCollection;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/ws/houses/collection")
public class HouInfoCollectedController extends BaseController {

    @Autowired
    private HouCollectionService houCollectionService;
    @Autowired
    private HouInfoColletedConvertor houInfoColletedConvertor;
    @Autowired
    private ValidateRepository validateRepository;
    @Autowired
    private CollectConvertor collectConvertor;

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
    public ResultDTO collect(@RequestParam String hid,
                             @RequestHeader(required = false) String token) {
        ResultError resultError;
        try {
            if (token == null) {
                resultError = new ResultError();
                resultError.setErrmsg("尚未登录，请先登陆！");
                resultError.setErrcode("150");
                return ResultDTO.failure(resultError);
            }
            String test = validateRepository.validateHouseBy(hid);
            getUser(token);
            if (test.contains("success")) {
                UsrHouCollection usrHouCollection = new UsrHouCollection();
                usrHouCollection.setUid(user.getId());
                usrHouCollection.setHid(hid);
                String chid = houCollectionService.collect(usrHouCollection, user);
                if (chid != null) {
                    return ResultDTO.success(collectConvertor.toDTO(usrHouCollection, chid));
                }
            }
        } catch (Exception e) {
            resultError = new ResultError();
            resultError.setErrcode("100");
            resultError.setErrmsg("收藏失败");
            HouInfoCollectedController.log.error(e.getLocalizedMessage());
            return ResultDTO.failure(resultError);
        }
        return ResultDTO.failure();
    }
}
