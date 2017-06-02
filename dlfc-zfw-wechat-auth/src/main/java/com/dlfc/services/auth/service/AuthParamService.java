package com.dlfc.services.auth.service;

import com.dlfc.services.auth.entity.SysParam;

import java.util.List;

public interface AuthParamService {

    List<SysParam> findSysParam(String scope);
}
