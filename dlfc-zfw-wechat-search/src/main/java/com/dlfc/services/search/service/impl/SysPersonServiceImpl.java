package com.dlfc.services.search.service.impl;

import com.dlfc.services.search.convertor.base.IConvertor;
import com.dlfc.services.search.entity.Person;
import com.dlfc.services.search.repository.PersonInfoRService;
import com.dlfc.services.search.service.SysPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysPersonServiceImpl implements SysPersonService {

    @Autowired
    private IConvertor convertor;
    @Autowired
    private PersonInfoRService personInfoRService;

    @Override
    public Person findById(String id) {
        String personInfo = personInfoRService.findPersonById(id);
        return (Person) convertor.convert2Object(personInfo, Person.class);
    }
}
