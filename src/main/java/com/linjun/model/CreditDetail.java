package com.linjun.model;

import java.util.Date;

public class CreditDetail {
    private Long id;

    private Long creditid;

    private Long userid;

    private Long addcredit;

    private Long consumcredit;

    private Byte status;

    private Date changtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreditid() {
        return creditid;
    }

    public void setCreditid(Long creditid) {
        this.creditid = creditid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getAddcredit() {
        return addcredit;
    }

    public void setAddcredit(Long addcredit) {
        this.addcredit = addcredit;
    }

    public Long getConsumcredit() {
        return consumcredit;
    }

    public void setConsumcredit(Long consumcredit) {
        this.consumcredit = consumcredit;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getChangtime() {
        return changtime;
    }

    public void setChangtime(Date changtime) {
        this.changtime = changtime;
    }
}