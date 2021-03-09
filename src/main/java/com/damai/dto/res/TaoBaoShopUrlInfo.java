package com.damai.dto.res;

public class TaoBaoShopUrlInfo {
    private String shopUrl;
    private String shopName;
    private String shopId;
    private String taoBaoNick;

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getTaoBaoNick() {
        return taoBaoNick;
    }

    public void setTaoBaoNick(String taoBaoNick) {
        this.taoBaoNick = taoBaoNick;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TaoBaoShopUrlInfo{");
        sb.append("shopUrl='").append(shopUrl).append('\'');
        sb.append(", shopName='").append(shopName).append('\'');
        sb.append(", shopId='").append(shopId).append('\'');
        sb.append(", taoBaoNick='").append(taoBaoNick).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
