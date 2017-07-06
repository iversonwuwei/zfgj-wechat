package com.dlfc.services.feedback.service;

import com.dlfc.services.feedback.repository.UsrPersonRService;
import com.dlfc.zfw.wechat.entities.entity.SysPerson;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by walden on 17-7-6.
 */
public interface UsrPersonService {

    SysPerson findById(String id);
}
