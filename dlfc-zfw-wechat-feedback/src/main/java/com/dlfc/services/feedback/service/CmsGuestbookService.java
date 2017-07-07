package com.dlfc.services.feedback.service;

import com.dlfc.zfw.wechat.entities.entity.CmsGuestbook;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;

/**
 * Created by walden on 17-7-6.
 */
public interface CmsGuestbookService {

    String save(CmsGuestbook cmsGuestbook, UsrUser usrUser);
}
