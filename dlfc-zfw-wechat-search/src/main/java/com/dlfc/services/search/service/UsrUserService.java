package com.dlfc.services.search.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dlfc.services.search.entity.UserEntity;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public interface UsrUserService {
    UserEntity findUser(String userid);
}
