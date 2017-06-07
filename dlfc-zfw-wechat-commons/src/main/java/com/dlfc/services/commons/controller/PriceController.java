package com.dlfc.services.commons.controller;

import com.dlfc.services.commons.convertor.SysCodeConvertor;
import com.dlfc.services.commons.dto.CodeNameDTO;
import com.dlfc.services.commons.entity.SysCode;
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
@RequestMapping("/wc/price")
public class PriceController {

    private List<SysCode> sysCodeList;

    @Autowired
    private DataService<SysCode> sysCodeService;
    @Autowired
    private SysCodeConvertor sysCodeConvertor;

    /**
     * 价格区间
     *
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/priceRange", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> priceRange() throws CustomRuntimeException {
        sysCodeList = sysCodeService.findBy("lease_rent");
        return sysCodeConvertor.toResultDTO(sysCodeList);
    }

    /**
     * 支付方式（押）
     *
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> deposit() throws CustomRuntimeException {
        sysCodeList = sysCodeService.findBy("rent_deposit");
        return sysCodeConvertor.toResultDTO(sysCodeList);
    }

    /**
     * 支付方式（付）
     *
     * @return
     * @throws CustomRuntimeException
     */
    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> payment() throws CustomRuntimeException {
        sysCodeList = sysCodeService.findBy("rent_payment");
        return sysCodeConvertor.toResultDTO(sysCodeList);
    }
}
