package com.heidsoft.omscloud.command;

import com.alibaba.cola.dto.Response;
import com.heidsoft.omscloud.domain.metrics.techinfluence.ATAMetric;
import com.heidsoft.omscloud.domain.metrics.techinfluence.ATAMetricItem;
import com.heidsoft.omscloud.domain.metrics.techinfluence.InfluenceMetric;
import com.heidsoft.omscloud.domain.user.UserProfile;
import com.heidsoft.omscloud.dto.ATAMetricAddCmd;
import com.heidsoft.omscloud.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ATAMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-01 11:42 AM
 */
@Component
public class ATAMetricAddCmdExe{

    @Autowired
    private MetricGateway metricGateway;

    public Response execute(ATAMetricAddCmd cmd) {
        ATAMetricItem ataMetricItem = new ATAMetricItem();
        BeanUtils.copyProperties(cmd.getAtaMetricCO(), ataMetricItem);
        ataMetricItem.setSubMetric(new ATAMetric(new InfluenceMetric(new UserProfile(cmd.getAtaMetricCO().getOwnerId()))));
        metricGateway.save(ataMetricItem);
        return Response.buildSuccess();
    }
}
