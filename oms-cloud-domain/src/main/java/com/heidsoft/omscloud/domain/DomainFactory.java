package com.heidsoft.omscloud.domain;

import com.heidsoft.omscloud.domain.user.UserProfile;

public class DomainFactory {

    public static UserProfile getUserProfile(){
        return new UserProfile();
    }

}
