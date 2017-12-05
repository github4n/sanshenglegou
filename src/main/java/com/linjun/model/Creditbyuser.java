package com.linjun.model;

import java.util.Date;

public class Creditbyuser {
    private Long id;

    private Long creditgoodid;

    private Long userid;

    private Date createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreditgoodid() {
        return creditgoodid;
    }

    public void setCreditgoodid(Long creditgoodid) {
        this.creditgoodid = creditgoodid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}