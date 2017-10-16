package com.linjun.model;

import java.util.Date;

public class OrderList {
  private   Long id;
  private  Long orderCode;
  private  String storename;
  private Date sendtime;
  private  String people;
  private String tel;
  private  Float price;
  private  Integer  amount;
  private Float pricesum;
  private Byte ispay;

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

  public String getStorename() {
    return storename;
  }

  public void setStorename(String storename) {
    this.storename = storename;
  }

  public Date getSendtime() {
    return sendtime;
  }

  public void setSendtime(Date sendtime) {
    this.sendtime = sendtime;
  }

  public String getPeople() {
    return people;
  }

  public void setPeople(String people) {
    this.people = people;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Float getPricesum() {
    return pricesum;
  }

  public void setPricesum(Float pricesum) {
    this.pricesum = pricesum;
  }

  public Byte getIspay() {
    return ispay;
  }

  public void setIspay(Byte ispay) {
    this.ispay = ispay;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }
}
