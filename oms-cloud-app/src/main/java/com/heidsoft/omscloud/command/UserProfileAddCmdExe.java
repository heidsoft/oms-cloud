package com.heidsoft.omscloud.command;

import com.alibaba.cola.dto.Response;
import com.heidsoft.omscloud.convertor.UserProfileConvertor;
import com.heidsoft.omscloud.domain.user.UserProfile;
import com.heidsoft.omscloud.dto.UserProfileAddCmd;
import com.heidsoft.omscloud.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * UserProfileAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-02-28 6:25 PM
 */
@Component
public class UserProfileAddCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileAddCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.create(userProfile);
        return Response.buildSuccess();
    }
}
