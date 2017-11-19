package com.linjun.pojo;

import com.sun.javafx.binding.StringFormatter;
import io.swagger.models.auth.In;

public class OrderListAdmin {
    private Long id;
    private  Long orderCode;
    private String goodsName;
    private  Long storeid;
    private  String storeName;
    private  String storer;
    private  String createTime;
    private  String revierPeople;
    private  String tel;
    private  Float price;
    private String address;
    private Integer acount;
    private Float allPrice;
    private  byte status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Long orderCode) {
        this.orderCode = orderCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getStoreid() {
        return storeid;
    }

    public void setStoreid(Long storeid) {
        this.storeid = storeid;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStorer() {
        return storer;
    }

    public void setStorer(String storer) {
        this.storer = storer;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRevierPeople() {
        return revierPeople;
    }

    public void setRevierPeople(String revierPeople) {
        this.revierPeople = revierPeople;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAcount() {
        return acount;
    }

    public void setAcount(Integer acount) {
        this.acount = acount;
    }

    public Float getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(Float allPrice) {
        this.allPrice = allPrice;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
