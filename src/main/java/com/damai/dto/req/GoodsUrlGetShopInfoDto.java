package com.damai.dto.req;

/**
 * @author HitvzByHui
 * date 2019-12-09
 */
public class GoodsUrlGetShopInfoDto {

    private String goodsUrl;

    public GoodsUrlGetShopInfoDto() {
    }

    public GoodsUrlGetShopInfoDto(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    @Override
    public String toString() {
        return "GoodsUrlGetShopInfoDto{" +
                "goodsUrl='" + goodsUrl + '\'' +
                '}';
    }
}
