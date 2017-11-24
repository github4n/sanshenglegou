package com.linjun.model;

public class Banner {
    private Long id;

    private String imageurl;

    private Byte isstart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public Byte getIsstart() {
        return isstart;
    }

    public void setIsstart(Byte isstart) {
        this.isstart = isstart;
    }
}