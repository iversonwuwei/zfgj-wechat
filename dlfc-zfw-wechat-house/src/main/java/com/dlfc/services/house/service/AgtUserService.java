package com.dlfc.services.house.service;

import com.dlfc.services.house.entity.AgtEmpInfo;

/**
 * Created by walden on 17-6-15.
 */
public interface AgtUserService {

    AgtEmpInfo findById(String eid);
}
