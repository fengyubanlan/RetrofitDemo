package com.damai.controller;

import com.damai.core.config.RetrofitConfig;
import com.damai.dto.res.CenterResultDto;
import com.damai.dto.req.GoodsUrlGetShopInfoDto;
import com.damai.dto.res.TaoBaoShopUrlInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author Jade
 * @Date 2021/03/09 10:30:04
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/test")
    public String test() throws IOException {
        try{
            String goodsUrl = "https://item.taobao.com/item.htm?spm=a1z10.3-c-s.w4002-20181046141.29.625b4455XeTJzB&id=39392723012";
            GoodsUrlGetShopInfoDto dto = new GoodsUrlGetShopInfoDto(goodsUrl);
            log.info(dto.toString());
            CenterResultDto<TaoBaoShopUrlInfo> result = RetrofitConfig.getDecisionService().getTaoBaoShopInfoByGoodsUrl(dto).execute().body();
            log.info(result.toString());
        }catch (Exception e){
            log.error("error:"+e.getMessage(),e);
        }
        return "success";
    }
}
