package com.heidsoft.omscloud.dto;

import com.heidsoft.omscloud.dto.clientobject.PaperMetricCO;
import com.heidsoft.omscloud.dto.clientobject.PatentMetricCO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * PaperMetricAddCmd
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:38 AM
 */
@Data
public class PaperMetricAddCmd extends CommonCommand{
    @NotNull
    private PaperMetricCO paperMetricCO;
}