package com.linjun.model;

public class Logistics {
    private Long id;

    private Long orderid;

    private String logisticsname;

    private String logisticsstate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public String getLogisticsname() {
        return logisticsname;
    }

    public void setLogisticsname(String logisticsname) {
        this.logisticsname = logisticsname == null ? null : logisticsname.trim();
    }

    public String getLogisticsstate() {
        return logisticsstate;
    }

    public void setLogisticsstate(String logisticsstate) {
        this.logisticsstate = logisticsstate == null ? null : logisticsstate.trim();
    }
}