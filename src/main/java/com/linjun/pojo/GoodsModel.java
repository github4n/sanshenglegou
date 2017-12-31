package com.linjun.pojo;

import java.io.Serializable;
import java.util.List;

public class GoodsModel {
    private long id;
    private List<String> imageaddress;
    private String goodsName;
    private float price;
    private float memberprice;
    private  long soldamount;
    private String storename;
    private long goodsSum;
    private  String content;
   private  long storeid;
    private byte  iscredits;
    private  long credit;

    public byte getIscredits() {
        return iscredits;
    }

    public void setIscredits(byte iscredits) {
        this.iscredits = iscredits;
    }

    public long getCredit() {
        return credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

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


    public List<String> getImageaddress() {
        return imageaddress;
    }

    public void setImageaddress(List<String> imageaddress) {
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

    @Override
    public String toString() {
        return "GoodsModel{" +
                "id=" + id +
                ", imageaddress=" + imageaddress +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", memberprice=" + memberprice +
                ", soldamount=" + soldamount +
                ", storename='" + storename + '\'' +
                ", goodsSum=" + goodsSum +
                ", content='" + content + '\'' +
                ", storeid=" + storeid +
                ", iscredits=" + iscredits +
                ", credit=" + credit +
                '}';
    }
}
