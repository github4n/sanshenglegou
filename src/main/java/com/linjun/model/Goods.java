package com.linjun.model;

import java.util.Date;

public class Goods {
    private Long id;

    private String goodsname;

    private Long goodsbandid;

    private Long typeid;

    private Long goodssum;

    private Integer sendcredit;

    private Long storeid;

    private String shop;

    private Long soldamount;

    private Date createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public Long getGoodsbandid() {
        return goodsbandid;
    }

    public void setGoodsbandid(Long goodsbandid) {
        this.goodsbandid = goodsbandid;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public Long getGoodssum() {
        return goodssum;
    }

    public void setGoodssum(Long goodssum) {
        this.goodssum = goodssum;
    }

    public Integer getSendcredit() {
        return sendcredit;
    }

    public void setSendcredit(Integer sendcredit) {
        this.sendcredit = sendcredit;
    }

    public Long getStoreid() {
        return storeid;
    }

    public void setStoreid(Long storeid) {
        this.storeid = storeid;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop == null ? null : shop.trim();
    }

    public Long getSoldamount() {
        return soldamount;
    }

    public void setSoldamount(Long soldamount) {
        this.soldamount = soldamount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}