package com.heidsoft.omscloud.command;

import com.alibaba.cola.dto.Response;
import com.heidsoft.omscloud.convertor.UserProfileConvertor;
import com.heidsoft.omscloud.domain.user.UserProfile;
import com.heidsoft.omscloud.dto.UserProfileUpdateCmd;
import com.heidsoft.omscloud.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileUpdateCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileUpdateCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.update(userProfile);
        return Response.buildSuccess();
    }
}