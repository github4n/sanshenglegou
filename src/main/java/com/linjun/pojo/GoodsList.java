package com.linjun.pojo;

import java.util.Date;

public class GoodsList {
    private  String imageAddress;
    private  long id;
    private  String goodsName;
    private   String typeName;
    private  float marketPrice;
    private  float memberPrice;
    private  long soldamount;
    private  byte isstart;
    private  long goodsSum;
    private  String createTime;

    public long getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(long goodsSum) {
        this.goodsSum = goodsSum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public float getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(float marketPrice) {
        this.marketPrice = marketPrice;
    }

    public float getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(float memberPrice) {
        this.memberPrice = memberPrice;
    }

    public long getSoldamount() {
        return soldamount;
    }

    public void setSoldamount(long soldamount) {
        this.soldamount = soldamount;
    }

    public byte getIsstart() {
        return isstart;
    }

    public void setIsstart(byte isstart) {
        this.isstart = isstart;
    }
}
