package com.dlfc.services.date.controller;

import com.dlfc.services.date.dto.ContractEndDateDTO;
import com.dlfc.services.date.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by K on 6/20/17.
 */

@RestController
@RequestMapping("/ww/contractDate")
public class ContractDateController {

    @Autowired
    private DateService dateService;

    @RequestMapping(value = "/endDate", method = RequestMethod.POST)
    public Date getEndDate(@RequestBody ContractEndDateDTO dto) {
        return dateService.getEndDate(dto.getStartDate(), dto.getYears(), dto.getMonths());
    }
}
