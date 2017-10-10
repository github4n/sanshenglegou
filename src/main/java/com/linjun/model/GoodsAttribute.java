package com.linjun.model;

public class GoodsAttribute {
    private Long id;

    private String attributename;

    private Long typeid;

    private Byte iskey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttributename() {
        return attributename;
    }

    public void setAttributename(String attributename) {
        this.attributename = attributename == null ? null : attributename.trim();
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public Byte getIskey() {
        return iskey;
    }

    public void setIskey(Byte iskey) {
        this.iskey = iskey;
    }
}