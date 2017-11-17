package com.linjun.pojo;

public class OrderDetailList {
    private  String imageAddress;
    private  long id;
    private  long orderCode;
    private  String goodsName;
    private  float Price;
    private  byte isstate;
    private  float meneySum;
    private  int count;
    private String receiver;
    private  String tel;
    private  String address;
    private  String message;

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    public long getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(long logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    private String logistics;
    private  long logisticsCode;

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    private String sendTime;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(long orderCode) {
        this.orderCode = orderCode;
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

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public byte getIsstate() {
        return isstate;
    }

    public void setIsstate(byte isstate) {
        this.isstate = isstate;
    }

    public float getMeneySum() {
        return meneySum;
    }

    public void setMeneySum(float meneySum) {
        this.meneySum = meneySum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
