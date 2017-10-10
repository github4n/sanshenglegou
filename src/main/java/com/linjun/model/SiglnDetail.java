package com.linjun.model;

import java.util.Date;

public class SiglnDetail {
    private Long id;

    private Long signid;

    private Long userid;

    private Integer expencepiont;

    private Integer tradepoint;

    private Date datacreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSignid() {
        return signid;
    }

    public void setSignid(Long signid) {
        this.signid = signid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getExpencepiont() {
        return expencepiont;
    }

    public void setExpencepiont(Integer expencepiont) {
        this.expencepiont = expencepiont;
    }

    public Integer getTradepoint() {
        return tradepoint;
    }

    public void setTradepoint(Integer tradepoint) {
        this.tradepoint = tradepoint;
    }

    public Date getDatacreate() {
        return datacreate;
    }

    public void setDatacreate(Date datacreate) {
        this.datacreate = datacreate;
    }
}