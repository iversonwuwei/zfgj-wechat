package com.dlfc.services.message.service.impl;

import com.dlfc.services.message.entity.SysMessage;
import com.dlfc.services.message.repository.MessageRService;
import com.dlfc.services.message.service.MessageService;
import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRService messageRService;

    @Autowired
    private IConvertor<SysMessage> convertor;

    @Override
    public List<SysMessage> findMessages(String uid) {
        String messages = messageRService.findMessages(uid);
        return convertor.convert2Objects(messages, SysMessage.class);
    }
}
