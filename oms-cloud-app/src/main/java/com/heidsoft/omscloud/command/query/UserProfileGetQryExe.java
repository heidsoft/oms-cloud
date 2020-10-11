package com.heidsoft.omscloud.command.query;

import com.alibaba.cola.dto.SingleResponse;
import com.heidsoft.omscloud.dto.UserProfileGetQry;
import com.heidsoft.omscloud.dto.clientobject.UserProfileCO;
import com.heidsoft.omscloud.gatewayimpl.database.UserProfileMapper;
import com.heidsoft.omscloud.gatewayimpl.database.dataobject.UserProfileDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileGetQryExe {

    @Resource
    private UserProfileMapper userProfileMapper;

    public SingleResponse<UserProfileCO> execute(UserProfileGetQry qry) {
        UserProfileDO userProfileDO = userProfileMapper.getByUserId(qry.getUserId());
        UserProfileCO userProfileCO = new UserProfileCO();
        BeanUtils.copyProperties(userProfileDO, userProfileCO);
        return SingleResponse.of(userProfileCO);
    }

}
