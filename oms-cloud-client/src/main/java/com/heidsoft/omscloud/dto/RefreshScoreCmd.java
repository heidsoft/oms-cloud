package com.heidsoft.omscloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RefreshScoreCmd extends CommonCommand{
    private String userId;
}
