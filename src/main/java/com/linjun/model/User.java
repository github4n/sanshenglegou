package com.linjun.model;

public class User {
    private Integer id;

    private String username;

    private String usrtel;

    private String usermail;

    private String userpassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsrtel() {
        return usrtel;
    }

    public void setUsrtel(String usrtel) {
        this.usrtel = usrtel == null ? null : usrtel.trim();
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail == null ? null : usermail.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }
}