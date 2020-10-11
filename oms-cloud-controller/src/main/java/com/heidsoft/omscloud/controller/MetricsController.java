package com.heidsoft.omscloud.controller;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.heidsoft.omscloud.api.MetricsServiceI;
import com.heidsoft.omscloud.dto.ATAMetricAddCmd;
import com.heidsoft.omscloud.dto.ATAMetricQry;
import com.heidsoft.omscloud.dto.clientobject.ATAMetricCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MetricsController {

    @Autowired
    private MetricsServiceI metricsService;

    @GetMapping(value = "/metrics/ata")
    public MultiResponse<ATAMetricCO> listATAMetrics(@RequestParam String ownerId){
        ATAMetricQry ataMetricQry = new ATAMetricQry();
        ataMetricQry.setOwnerId(ownerId);
        return metricsService.listATAMetrics(ataMetricQry);
    }

    @PostMapping(value = "/metrics/ata")
    public Response addATAMetric(@RequestBody ATAMetricAddCmd ataMetricAddCmd){
        return metricsService.addATAMetric(ataMetricAddCmd);
    }
}
