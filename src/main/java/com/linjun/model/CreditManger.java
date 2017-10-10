package com.linjun.model;

public class CreditManger {
    private Long id;

    private Long userid;

    private Long creditsum;

    private Long consumedcredit;

    private Long getcredit;

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

    public Long getCreditsum() {
        return creditsum;
    }

    public void setCreditsum(Long creditsum) {
        this.creditsum = creditsum;
    }

    public Long getConsumedcredit() {
        return consumedcredit;
    }

    public void setConsumedcredit(Long consumedcredit) {
        this.consumedcredit = consumedcredit;
    }

    public Long getGetcredit() {
        return getcredit;
    }

    public void setGetcredit(Long getcredit) {
        this.getcredit = getcredit;
    }
}