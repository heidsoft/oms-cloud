package com.heidsoft.omscloud.gatewayimpl;

import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.heidsoft.omscloud.convertor.UserProfileConvertor;
import com.heidsoft.omscloud.domain.DomainFactory;
import com.heidsoft.omscloud.domain.gateway.UserProfileGateway;
import com.heidsoft.omscloud.domain.metrics.techcontribution.ContributionMetric;
import com.heidsoft.omscloud.domain.metrics.weight.WeightFactory;
import com.heidsoft.omscloud.domain.user.Role;
import com.heidsoft.omscloud.domain.user.UserProfile;
import com.heidsoft.omscloud.gatewayimpl.database.UserProfileMapper;
import com.heidsoft.omscloud.gatewayimpl.database.dataobject.UserProfileDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * UserProfileGatewayImpl
 *
 * @author Frank Zhang
 * @date 2020-07-02 12:32 PM
 */
@Component
public class UserProfileGatewayImpl implements UserProfileGateway {
    private static Logger logger = LoggerFactory.getLogger(ContributionMetric.class);

    @Resource
    private UserProfileMapper userProfileMapper;


    public void create(UserProfile userProfile){
        userProfileMapper.create(UserProfileConvertor.toDataObjectForCreate(userProfile));
    }

    public void update(UserProfile userProfile){
        userProfileMapper.update(UserProfileConvertor.toDataObjectForUpdate(userProfile));
    }

    public UserProfile getByUserId(String userId){
        UserProfileDO userProfileDO = userProfileMapper.getByUserId(userId);
        if(userProfileDO == null){
            logger.warn("There is no UserProfile for : "+userId);
            return null;
        }
        UserProfile userProfile = DomainFactory.getUserProfile();
        BeanUtils.copyProperties(userProfileDO, userProfile);
        Role role = Role.valueOf(userProfileDO.getRole());
        userProfile.setRole(role);
        userProfile.setWeight(WeightFactory.get(role));
        return userProfile;
    }

}
