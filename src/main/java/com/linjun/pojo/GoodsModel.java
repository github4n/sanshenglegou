package com.linjun.pojo;

import java.io.Serializable;

public class GoodsModel {
    private long id;
    private  String imageaddress;
    private String goodsName;
    private float price;
    private  long soldamount;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public long getSoldamount() {
        return soldamount;
    }

    public void setSoldamount(long soldamount) {
        this.soldamount = soldamount;
    }
}
