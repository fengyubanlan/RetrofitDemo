package com.damai.core.config;

import com.damai.core.converter.JacksonConverterFactory;
import com.damai.service.DecisionCenterService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RetrofitConfig
 * @Description TODO
 * @Author Jade
 * @Date 2021/03/09 10:11:10
 * @Version 1.0
 **/
@Component
public class RetrofitConfig {

    /**
     * 构造Jackson转换器
     */
    private static JacksonConverterFactory getJacksonConverterFactory() {
        ObjectMapper requestMapper = new ObjectMapper();
        requestMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);// 忽略实体没定义的字段
        //requestMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);//请求参数默认驼峰
        ObjectMapper responseMapper = new ObjectMapper();
        responseMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);// 忽略实体没定义的字段
        //responseMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);//返回参数默认驼峰
        return JacksonConverterFactory.create(requestMapper, responseMapper);
    }

    private static OkHttpClient getDefaultOkHttpClient(){
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.connectTimeout(90, TimeUnit.SECONDS);
        client.readTimeout(60, TimeUnit.SECONDS);
        return client.build();
    }

    public static DecisionCenterService getDecisionService() {
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://pd.da-mai.com/");
        //Retrofit.Builder builder = new Retrofit.Builder().baseUrl(new BaseUrlConfig().getDecisionCenter());
        builder.addConverterFactory(getJacksonConverterFactory());
        builder.client(getDefaultOkHttpClient());
        return builder.build().create(DecisionCenterService.class);
    }

}
