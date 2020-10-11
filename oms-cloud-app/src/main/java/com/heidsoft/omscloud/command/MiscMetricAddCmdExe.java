package com.heidsoft.omscloud.command;

import com.alibaba.cola.dto.Response;
import com.heidsoft.omscloud.domain.metrics.techcontribution.ContributionMetric;
import com.heidsoft.omscloud.domain.metrics.techcontribution.MiscMetric;
import com.heidsoft.omscloud.domain.metrics.techcontribution.MiscMetricItem;
import com.heidsoft.omscloud.domain.user.UserProfile;
import com.heidsoft.omscloud.dto.MiscMetricAddCmd;
import com.heidsoft.omscloud.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * MiscMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:15 AM
 */
@Component
public class MiscMetricAddCmdExe{

    @Resource
    private MetricGateway metricGateway;

    public Response execute(MiscMetricAddCmd cmd) {
        MiscMetricItem miscMetricItem = new MiscMetricItem();
        BeanUtils.copyProperties(cmd.getMiscMetricCO(), miscMetricItem);
        miscMetricItem.setSubMetric(new MiscMetric(new ContributionMetric(new UserProfile(cmd.getMiscMetricCO().getOwnerId()))));
        metricGateway.save(miscMetricItem);
        return Response.buildSuccess();
    }
}