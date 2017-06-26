package com.dlfc.services.contract.service;

import com.dlfc.zfw.wechat.entities.entity.ConOtherCosts;
import com.dlfc.zfw.wechat.entities.entity.UsrUser;

import java.util.List;

/**
 * Created by K on 6/26/17.
 */
public interface OtherCostService {
    String save(ConOtherCosts conOtherCosts, UsrUser user);

    List<ConOtherCosts> findByLid(String lid);
}
