package com.linjun.pojo;

public class GoodsListAdmin {
    private Long id;
    private  String goodsimage;
    private  String goodsname;
    private  String storename;
    private  long storeid;
    private   String typeName;
    private  float marketPrice;
    private  float memberPrice;
    private  long soldamount;
    private  byte isstart;
    private  long goodsSum;
    private String storer;
    private  String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsimage() {
        return goodsimage;
    }

    public void setGoodsimage(String goodsimage) {
        this.goodsimage = goodsimage;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public long getStoreid() {
        return storeid;
    }

    public void setStoreid(long storeid) {
        this.storeid = storeid;
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

    public long getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(long goodsSum) {
        this.goodsSum = goodsSum;
    }

    public String getStorer() {
        return storer;
    }

    public void setStorer(String storer) {
        this.storer = storer;
    }
}
