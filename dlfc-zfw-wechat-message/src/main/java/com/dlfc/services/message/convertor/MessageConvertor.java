package com.dlfc.services.message.convertor;

import com.dlfc.services.message.dto.MessageDTO;
import com.dlfc.services.message.entity.SysMessage;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;


@Component
public class MessageConvertor extends AbstractConvertor<SysMessage, MessageDTO> {

    @Override
    public SysMessage toModel(MessageDTO messageDTO) {
        return null;
    }

    @Override
    public MessageDTO toDTO(SysMessage sysMessage, Object... objects) {

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setContent(sysMessage.getContent());
        messageDTO.setTitle(sysMessage.getTitle());
        messageDTO.setType(sysMessage.getType());
        messageDTO.setId(sysMessage.getId());
        messageDTO.setDate(sysMessage.getSendTime());
        return messageDTO;
    }
}
