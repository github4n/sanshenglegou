package com.linjun.pojo;

import java.io.Serializable;

public class GoodsModel {
    private long id;
    private  String imageaddress;
    private String goodsName;
    private float price;
    private float memberprice;
    private  long soldamount;
    private String storename;
    private long goodsSum;
    private  String content;
   private  long storeid;

    public long getStoreid() {
        return storeid;
    }

    public void setStoreid(long storeid) {
        this.storeid = storeid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageaddress() {
        return imageaddress;
    }

    public void setImageaddress(String imageaddress) {
        this.imageaddress = imageaddress;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getMemberprice() {
        return memberprice;
    }

    public void setMemberprice(float memberprice) {
        this.memberprice = memberprice;
    }

    public long getSoldamount() {
        return soldamount;
    }

    public void setSoldamount(long soldamount) {
        this.soldamount = soldamount;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public long getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(long goodsSum) {
        this.goodsSum = goodsSum;
    }
}
