package com.linjun.model;

import java.util.Date;

public class Income {
    private Long id;

    private Long ordercode;

    private Long orderid;

    private String payname;

    private Long payid;

    private Float price;

    private Date paytime;

    private Byte stutas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(Long ordercode) {
        this.ordercode = ordercode;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public String getPayname() {
        return payname;
    }

    public void setPayname(String payname) {
        this.payname = payname == null ? null : payname.trim();
    }

    public Long getPayid() {
        return payid;
    }

    public void setPayid(Long payid) {
        this.payid = payid;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Byte getStutas() {
        return stutas;
    }

    public void setStutas(Byte stutas) {
        this.stutas = stutas;
    }
}