package com.dlfc.services.message.controller;


import com.dlfc.services.message.convertor.MessageConvertor;
import com.dlfc.services.message.dto.MessageDTO;
import com.dlfc.services.message.entity.SysMessage;
import com.dlfc.services.message.service.MessageService;
import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ww/messages")
public class MessageController {

    @Autowired
    private MessageConvertor messageConvertor;

    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.GET)
    public ListResultDTO<MessageDTO> messages() throws CustomRuntimeException {
        List<SysMessage> messages = messageService.findMessages("72113e9245a44836944a6410168e6bb6");
        if (messages == null) {
            throw new CustomRuntimeException("", "");
        }
        return messageConvertor.toResultDTO(messages);
    }
}
