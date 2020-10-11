package com.heidsoft.omscloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.heidsoft.omscloud", "com.alibaba.cola" })
@MapperScan("com.heidsoft.omscloud.gatewayimpl.database")
public class OmsCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(OmsCloudApplication.class, args);
    }

}
