package com.linjun.model;

import java.util.Date;

public class Store {
    private Long id;

    private Date createtime;

    private String storename;

    private String storeaddress;

    private String storetype;

    private String storer;

    private String stroelogo;

    private String scope;

    private String tel;

    private Byte isauth;

    private Long storeuserid;

    private String passworld;

    private String introduce;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename == null ? null : storename.trim();
    }

    public String getStoreaddress() {
        return storeaddress;
    }

    public void setStoreaddress(String storeaddress) {
        this.storeaddress = storeaddress == null ? null : storeaddress.trim();
    }

    public String getStoretype() {
        return storetype;
    }

    public void setStoretype(String storetype) {
        this.storetype = storetype == null ? null : storetype.trim();
    }

    public String getStorer() {
        return storer;
    }

    public void setStorer(String storer) {
        this.storer = storer == null ? null : storer.trim();
    }

    public String getStroelogo() {
        return stroelogo;
    }

    public void setStroelogo(String stroelogo) {
        this.stroelogo = stroelogo == null ? null : stroelogo.trim();
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Byte getIsauth() {
        return isauth;
    }

    public void setIsauth(Byte isauth) {
        this.isauth = isauth;
    }

    public Long getStoreuserid() {
        return storeuserid;
    }

    public void setStoreuserid(Long storeuserid) {
        this.storeuserid = storeuserid;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld == null ? null : passworld.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}