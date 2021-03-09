package com.damai.core.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName Config
 * @Description TODO
 * @Author Jade
 * @Date 2021/03/09 10:00:15
 * @Version 1.0
 **/
@Component
public class BaseUrlConfig {

    @Value("${host.decision-center}")
    private String decisionCenter;

    private static BaseUrlConfig baseUrlConfig;

    public String getDecisionCenter(){
        System.out.println(decisionCenter);
        return decisionCenter;
    }




}
