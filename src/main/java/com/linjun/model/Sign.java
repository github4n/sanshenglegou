package com.linjun.model;

import java.util.Date;

public class Sign {
    private Long id;

    private Long userid;

    private Long expersum;

    private Integer monthsigncount;

    private Date lastsiglns;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getExpersum() {
        return expersum;
    }

    public void setExpersum(Long expersum) {
        this.expersum = expersum;
    }

    public Integer getMonthsigncount() {
        return monthsigncount;
    }

    public void setMonthsigncount(Integer monthsigncount) {
        this.monthsigncount = monthsigncount;
    }

    public Date getLastsiglns() {
        return lastsiglns;
    }

    public void setLastsiglns(Date lastsiglns) {
        this.lastsiglns = lastsiglns;
    }
}