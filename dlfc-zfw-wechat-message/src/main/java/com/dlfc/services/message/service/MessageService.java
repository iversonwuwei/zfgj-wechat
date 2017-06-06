package com.dlfc.services.message.service;


import com.dlfc.services.message.entity.SysMessage;

import java.util.List;

public interface MessageService {

    List<SysMessage> findMessages(String uid);
}
