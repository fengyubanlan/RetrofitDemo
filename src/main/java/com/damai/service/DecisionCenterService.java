package com.damai.service;

import com.damai.dto.res.CenterResultDto;
import com.damai.dto.req.GoodsUrlGetShopInfoDto;
import com.damai.dto.res.TaoBaoShopUrlInfo;
import retrofit2.Call;
import retrofit2.http.*;

public interface DecisionCenterService {

    /**
     * 获取店铺信息
     */
    @POST("decision-center/tools/getTaoBaoShopInfoByGoodsUrl")
    Call<CenterResultDto<TaoBaoShopUrlInfo>> getTaoBaoShopInfoByGoodsUrl(@Body GoodsUrlGetShopInfoDto data);

}
