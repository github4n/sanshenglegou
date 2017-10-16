package com.linjun.model;

import java.util.Date;

public class Order {
    private Long id;

    private Long userid;

    private Long storeid;

    private Long ordercode;

    private String goodsname;

    private Long goodsid;

    private Long addressid;

    private Float marketpricce;

    private Float memberprice;

    private Integer goodsum;

    private Float pricesum;

    private Date sendtime;

    private String logistics;

    private Date paytime;

    private Byte isreceive;

    private Byte ispay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getStoreid() {
        return storeid;
    }

    public void setStoreid(Long storeid) {
        this.storeid = storeid;
    }

    public Long getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(Long ordercode) {
        this.ordercode = ordercode;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public Long getAddressid() {
        return addressid;
    }

    public void setAddressid(Long addressid) {
        this.addressid = addressid;
    }

    public Float getMarketpricce() {
        return marketpricce;
    }

    public void setMarketpricce(Float marketpricce) {
        this.marketpricce = marketpricce;
    }

    public Float getMemberprice() {
        return memberprice;
    }

    public void setMemberprice(Float memberprice) {
        this.memberprice = memberprice;
    }

    public Integer getGoodsum() {
        return goodsum;
    }

    public void setGoodsum(Integer goodsum) {
        this.goodsum = goodsum;
    }

    public Float getPricesum() {
        return pricesum;
    }

    public void setPricesum(Float pricesum) {
        this.pricesum = pricesum;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics == null ? null : logistics.trim();
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Byte getIsreceive() {
        return isreceive;
    }

    public void setIsreceive(Byte isreceive) {
        this.isreceive = isreceive;
    }

    public Byte getIspay() {
        return ispay;
    }

    public void setIspay(Byte ispay) {
        this.ispay = ispay;
    }
}