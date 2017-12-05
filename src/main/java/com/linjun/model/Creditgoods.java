package com.linjun.model;

import java.util.Date;

public class Creditgoods {
    private Long id;

    private String creditgood;

    private String imageurl;

    private Long cregoodssum;

    private Long soldamount;

    private Long price;

    private Byte isstart;

    private Date createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditgood() {
        return creditgood;
    }

    public void setCreditgood(String creditgood) {
        this.creditgood = creditgood == null ? null : creditgood.trim();
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public Long getCregoodssum() {
        return cregoodssum;
    }

    public void setCregoodssum(Long cregoodssum) {
        this.cregoodssum = cregoodssum;
    }

    public Long getSoldamount() {
        return soldamount;
    }

    public void setSoldamount(Long soldamount) {
        this.soldamount = soldamount;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
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
}