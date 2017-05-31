package com.dlfc.services.commons.controller;


import com.dlfc.services.commons.repository.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/wc/areas")
public class AreaController {

    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping(value = "/district", method = RequestMethod.GET)
    public String districts(@RequestParam(required = false) String dCode){
        String tyest = repositoryService.getDistricts(10, 1);
        return tyest;
    }
}
