package com.dlfc.services.commons.controller;

import com.dlfc.services.commons.convertor.SysCodeConvertor;
import com.dlfc.services.commons.convertor.SysHouEquipmentsConvertor;
import com.dlfc.services.commons.convertor.SysSurFacisContrastConvertor;
import com.dlfc.services.commons.dto.CodeNameDTO;
import com.dlfc.services.commons.service.DataService;
import com.dlfc.zfw.wechat.entities.entity.SysCode;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("sysCodeServiceImpl")
    private DataService<SysCode> sysCodeService;
    @Autowired
    @Qualifier("sysHouEquipsContrastImpl")
    private DataService<SysCode> sysHouEquipmentsService;
    @Autowired
    @Qualifier("sysSurFacisContrastServiceImpl")
    private DataService<SysCode> sysSurFacisContrastService;
    @Autowired
    private SysCodeConvertor sysCodeConvertor;
    @Autowired
    private SysHouEquipmentsConvertor sysHouEquipmentsConvertor;
    @Autowired
    private SysSurFacisContrastConvertor sysSurFacisContrastConvertor;

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
     * 配套设施
     *
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/houEquipments", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> houEquipments() throws CustomRuntimeException {
        List<SysCode> sysHouEquipsContrastList = sysHouEquipmentsService.findAll();
        return sysHouEquipmentsConvertor.toResultDTO(sysHouEquipsContrastList);
    }

    /**
     * 周边
     *
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/surroundingFacilities", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> surroundingFacilities() throws CustomRuntimeException {
        List<SysCode> sysSurFacisContrastList = sysSurFacisContrastService.findAll();
        return sysSurFacisContrastConvertor.toResultDTO(sysSurFacisContrastList);
    }

    /**
     * 租住要求
     *
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/rentalRequire", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> rentalRequire() throws CustomRuntimeException {
        List<SysCode> sysCodeList = sysCodeService.findBy("rental_require");
        return sysCodeConvertor.toResultDTO(sysCodeList);
    }
}
