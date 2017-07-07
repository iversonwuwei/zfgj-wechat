package com.dlfc.services.feedback.service.impl;

import com.dlfc.services.feedback.repository.CmsGuestbookRService;
import com.dlfc.services.feedback.service.CmsGuestbookService;
import com.dlfc.zfw.wechat.entities.entity.CmsGuestbook;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;
import com.housecenter.dlfc.framework.boot.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by walden on 17-7-6.
 */
@Service
public class CmsGuestbookServiceImpl implements CmsGuestbookService {
    @Autowired
    private CmsGuestbookRService cmsGuestbookRService;

    @Override
    public String save(CmsGuestbook cmsGuestbook, UsrUser usrUser) {
        cmsGuestbook.preInsert(usrUser);
        return cmsGuestbookRService.save(cmsGuestbook);
    }
}
