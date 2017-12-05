package com.linjun.pojo;

import java.util.List;

public class UserData {
    private Long id;
    private Long newuser;
    private  Long alluser;
    private List<Integer> weekUser;
    private  List<Integer> monthUser;
     private   List<Integer> monthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNewuser() {
        return newuser;
    }

    public void setNewuser(Long newuser) {
        this.newuser = newuser;
    }

    public Long getAlluser() {
        return alluser;
    }

    public void setAlluser(Long alluser) {
        this.alluser = alluser;
    }

    public List<Integer> getWeekUser() {
        return weekUser;
    }

    public void setWeekUser(List<Integer> weekUser) {
        this.weekUser = weekUser;
    }

    public List<Integer> getMonthUser() {
        return monthUser;
    }

    public void setMonthUser(List<Integer> monthUser) {
        this.monthUser = monthUser;
    }

    public List<Integer> getMonthday() {
        return monthday;
    }

    public void setMonthday(List<Integer> monthday) {
        this.monthday = monthday;
    }
}
