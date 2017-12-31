package com.linjun.model;

import java.util.Date;

public class Goods {
    private Long id;

    private String goodsname;

    private Long typeid;

    private Long goodssum;

    private Float marketprive;

    private Float memberprice;

    private Integer sendcredit;

    private Long storeid;

    private String shop;

    private Long soldamount;

    private Byte iscredits;

    private Long credit;

    private Byte isstart;

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

    public Float getMarketprive() {
        return marketprive;
    }

    public void setMarketprive(Float marketprive) {
        this.marketprive = marketprive;
    }

    public Float getMemberprice() {
        return memberprice;
    }

    public void setMemberprice(Float memberprice) {
        this.memberprice = memberprice;
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

    public Byte getIscredits() {
        return iscredits;
    }

    public void setIscredits(Byte iscredits) {
        this.iscredits = iscredits;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public Byte getIsstart() {
        return isstart;
    }

    public void setIsstart(Byte isstart) {
        this.isstart = isstart;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsname='" + goodsname + '\'' +
                ", typeid=" + typeid +
                ", goodssum=" + goodssum +
                ", marketprive=" + marketprive +
                ", memberprice=" + memberprice +
                ", sendcredit=" + sendcredit +
                ", storeid=" + storeid +
                ", shop='" + shop + '\'' +
                ", soldamount=" + soldamount +
                ", iscredits=" + iscredits +
                ", credit=" + credit +
                ", isstart=" + isstart +
                ", createtime=" + createtime +
                '}';
    }
}