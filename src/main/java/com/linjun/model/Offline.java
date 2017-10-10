package com.linjun.model;

import java.util.Date;

public class Offline {
    private Long id;

    private Long userid;

    private Long offlinruserid;

    private Long fatheruserid;

    private Byte isfather;

    private Date createtime;

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

    public Long getOfflinruserid() {
        return offlinruserid;
    }

    public void setOfflinruserid(Long offlinruserid) {
        this.offlinruserid = offlinruserid;
    }

    public Long getFatheruserid() {
        return fatheruserid;
    }

    public void setFatheruserid(Long fatheruserid) {
        this.fatheruserid = fatheruserid;
    }

    public Byte getIsfather() {
        return isfather;
    }

    public void setIsfather(Byte isfather) {
        this.isfather = isfather;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}