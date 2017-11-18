package com.linjun.model;

import java.util.Date;

public class Outcome {
    private Long id;

    private Long ordercode;

    private String payname;

    private Long payacount;

    private Float price;

    private String dopayname;

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

    public String getPayname() {
        return payname;
    }

    public void setPayname(String payname) {
        this.payname = payname == null ? null : payname.trim();
    }

    public Long getPayacount() {
        return payacount;
    }

    public void setPayacount(Long payacount) {
        this.payacount = payacount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDopayname() {
        return dopayname;
    }

    public void setDopayname(String dopayname) {
        this.dopayname = dopayname == null ? null : dopayname.trim();
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