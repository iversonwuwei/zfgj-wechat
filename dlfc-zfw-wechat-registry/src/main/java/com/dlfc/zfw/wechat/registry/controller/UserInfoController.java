package com.dlfc.zfw.wechat.registry.controller;

import com.dlfc.admin.common.utils.StringUtils;
import com.dlfc.zfw.wechat.registry.entity.UserEntity;
import com.dlfc.zfw.wechat.registry.entity.UsrUser;
import com.dlfc.zfw.wechat.registry.service.SysInfoAttService;
import com.dlfc.zfw.wechat.registry.service.UsrUserService;
import com.housecenter.dlfc.commons.bases.dto.ResultDTO;
import com.housecenter.dlfc.commons.bases.error.ResultError;
import com.housecenter.dlfc.framework.ca.api.PrincipalService;
import com.housecenter.dlfc.framework.common.web.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by K on 6/19/17.
 */

@Slf4j
@RestController
@RequestMapping(value = "/wc/userInfo")
public class UserInfoController {

    @Autowired
    private PrincipalService principalService;
    @Autowired
    private SysInfoAttService sysInfoAttService;

    @RequestMapping(value = "/avatar", method = RequestMethod.GET)
    public ResultDTO<Void> avatar(@RequestParam String path,
                                  @RequestHeader String token) {
        if (StringUtils.isEmpty(path)) {
            log.error("参数path为空");
            return ResultDTO.failure(new ResultError("头像图片信息有误，请稍后重新上传", null));
        }
        AjaxResult result = principalService.principal(token);
        String id = sysInfoAttService.saveUserAvatar(path, result.getData().toString());
        if (StringUtils.isEmpty(id)) {
            log.error("保存失败");
            return ResultDTO.failure(new ResultError("头像图片信息有误，请稍后重新上传", null));
        }
        return ResultDTO.success();
    }
}
