package com.dlfc.services.house.service;

import com.dlfc.zfw.wechat.entities.entity.SysSurFacis;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;

import java.util.List;

/**
 * Created by K on 2017/6/3.
 */
public interface SysSurFaciService {

    String save(SysSurFacis sysSurFacis, UsrUser user);

    List<SysSurFacis> findByLid(String lid);

    void remove(String lid);
}
