package com.dlfc.services.commons.controller;

import com.dlfc.services.commons.convertor.SysCodeConvertor;
import com.dlfc.services.commons.convertor.SysHouEquipmentsConvertor;
import com.dlfc.services.commons.dto.CodeNameDTO;
import com.dlfc.services.commons.entity.SysCode;
import com.dlfc.services.commons.entity.SysHouEquipmentsContrast;
import com.dlfc.services.commons.service.DataService;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by K on 2017/6/2.
 */

@RestController
@RequestMapping("/wc/sysHouInfo")
public class SysHouInfoController {

    @Autowired
    private DataService<SysCode> sysCodeService;
    @Autowired
    private DataService<SysHouEquipmentsContrast> sysHouEquipmentsService;
    @Autowired
    private SysCodeConvertor sysCodeConvertor;
    @Autowired
    private SysHouEquipmentsConvertor sysHouEquipmentsConvertor;

    /**
     * 房屋朝向
     *
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/orientation", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> orientation() throws CustomRuntimeException {
        List<SysCode> sysCodeList = sysCodeService.findBy("hou_orientation");
        return sysCodeConvertor.toResultDTO(sysCodeList);
    }

    /**
     * 周边设施
     *
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/surroundingFacilities", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> surroundingFacilities() throws CustomRuntimeException {
        List<SysHouEquipmentsContrast> sysHouEquipmentsContrastList = sysHouEquipmentsService.findAll();
        return sysHouEquipmentsConvertor.toResultDTO(sysHouEquipmentsContrastList);
    }
}
