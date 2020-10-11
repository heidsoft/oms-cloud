package com.heidsoft.omscloud.dto;

import com.heidsoft.omscloud.dto.clientobject.UserProfileCO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserProfileUpdateCmd extends CommonCommand {

    @NotNull
    private UserProfileCO userProfileCO;
}
