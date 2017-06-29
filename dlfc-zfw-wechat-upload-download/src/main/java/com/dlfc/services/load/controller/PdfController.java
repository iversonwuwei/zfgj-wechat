package com.dlfc.services.load.controller;

import com.dlfc.admin.common.exception.ApplicationException;
import com.dlfc.admin.common.utils.FileDownload;
import com.dlfc.services.load.dto.ContractDTO;
import com.dlfc.services.load.repository.ContractWService;
import com.dlfc.services.load.service.PdfService;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by K on 6/28/17.
 */

@RestController
@RequestMapping("/ww/pdf")
@Slf4j
public class PdfController {

    @Autowired
    private ContractWService contractWService;
    @Autowired
    private PdfService pdfService;

    @RequestMapping(value = "/contract", method = RequestMethod.GET)
    ResultDTO<Void> contract(@RequestParam String id,
                             HttpServletResponse response) {
//        try {
//            ResultDTO<ContractDTO> resultDTO = contractWService.detail(id);
//            if (null != resultDTO) {
//            String path = pdfService.generate(resultDTO.getData());
            String path = pdfService.generate(new ContractDTO());
//                FileDownload.download(path, response);
//            } else {
//                log.error("合同信息获取失败");
//                return ResultDTO.failure();
//            }
//        } catch (ApplicationException e) {
//            log.error(e.getCodeAndExplanation());
//            return ResultDTO.failure();
//        }
        return ResultDTO.success();
    }
}
