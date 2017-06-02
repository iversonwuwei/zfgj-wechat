package com.dlfc.services.auth.utils;

import com.dlfc.services.auth.entity.SysParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtils {

    public static Map<String, String> getAuthParam(List<SysParam> sysParamList){
        Map<String, String> paramMap = new HashMap<>();
        if (sysParamList != null){
            for (SysParam sysParam: sysParamList){
                paramMap.put(sysParam.getSkey(), sysParam.getSvalue());
            }
        }

        return paramMap;
    }
}
