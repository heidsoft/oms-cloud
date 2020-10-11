package com.heidsoft.omscloud.domain.metrics.appquality;

import com.heidsoft.omscloud.domain.metrics.MainMetric;
import com.heidsoft.omscloud.domain.metrics.MainMetricType;
import com.heidsoft.omscloud.domain.metrics.devquality.BugMetric;
import com.heidsoft.omscloud.domain.user.UserProfile;

public class AppQualityMetric extends MainMetric {

    private AppMetric appMetric;

    public AppQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setAppQualityMetric(this);
        this.metricMainType = MainMetricType.APP_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getAppQualityWeight();
    }
}
