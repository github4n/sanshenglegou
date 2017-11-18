package com.linjun.model;

import java.util.Date;

public class VillageApply {
    private Long id;

    private Long userid;

    private String username;

    private String identityimage;

    private String identityimages;

    private String bankacount;

    private Date appletime;

    private Byte stutas;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getIdentityimage() {
        return identityimage;
    }

    public void setIdentityimage(String identityimage) {
        this.identityimage = identityimage == null ? null : identityimage.trim();
    }

    public String getIdentityimages() {
        return identityimages;
    }

    public void setIdentityimages(String identityimages) {
        this.identityimages = identityimages == null ? null : identityimages.trim();
    }

    public String getBankacount() {
        return bankacount;
    }

    public void setBankacount(String bankacount) {
        this.bankacount = bankacount == null ? null : bankacount.trim();
    }

    public Date getAppletime() {
        return appletime;
    }

    public void setAppletime(Date appletime) {
        this.appletime = appletime;
    }

    public Byte getStutas() {
        return stutas;
    }

    public void setStutas(Byte stutas) {
        this.stutas = stutas;
    }
}