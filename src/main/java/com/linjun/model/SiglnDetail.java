package com.linjun.model;

import java.util.Date;

public class SiglnDetail {
    private Integer id;

    private Integer userid;

    private Integer expencepiont;

    private Integer tradepoint;

    private Date datacreate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
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