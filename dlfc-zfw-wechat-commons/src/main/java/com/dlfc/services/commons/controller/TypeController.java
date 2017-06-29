package com.dlfc.services.commons.controller;

import com.dlfc.services.commons.convertor.SysCodeConvertor;
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
 * Created by K on 6/29/17.
 */

@RestController
@RequestMapping("/wc/type")
public class TypeController {

    @Autowired
    @Qualifier("SysCodeServiceImpl")
    private DataService<SysCode> sysCodeService;
    @Autowired
    private SysCodeConvertor sysCodeConvertor;

    @RequestMapping(value = "/idNo", method = RequestMethod.GET)
    public ListResultDTO<CodeNameDTO> idNo() throws CustomRuntimeException {
        List<SysCode> sysCodeList = sysCodeService.findBy("per_id_type");
        return sysCodeConvertor.toResultDTO(sysCodeList);
    }
}
