package com.linjun.model;

public class Admin {
    private Long id;

    private String account;

    private String passworld;

    private Byte grade;

    private Byte jurisdiction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld == null ? null : passworld.trim();
    }

    public Byte getGrade() {
        return grade;
    }

    public void setGrade(Byte grade) {
        this.grade = grade;
    }

    public Byte getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(Byte jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
}