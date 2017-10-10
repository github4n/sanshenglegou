package com.linjun.model;

import java.util.Date;

public class GoodsImage {
    private Long id;

    private Long goodsid;

    private String iamgeaddress;

    private Byte iskeyiamge;

    private Date createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public String getIamgeaddress() {
        return iamgeaddress;
    }

    public void setIamgeaddress(String iamgeaddress) {
        this.iamgeaddress = iamgeaddress == null ? null : iamgeaddress.trim();
    }

    public Byte getIskeyiamge() {
        return iskeyiamge;
    }

    public void setIskeyiamge(Byte iskeyiamge) {
        this.iskeyiamge = iskeyiamge;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}