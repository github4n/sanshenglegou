package com.linjun.model;

public class GoodsType {
    private Long id;

    private String typename;

    private Long fathertypeid;

    private Byte isfather;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Long getFathertypeid() {
        return fathertypeid;
    }

    public void setFathertypeid(Long fathertypeid) {
        this.fathertypeid = fathertypeid;
    }

    public Byte getIsfather() {
        return isfather;
    }

    public void setIsfather(Byte isfather) {
        this.isfather = isfather;
    }
}