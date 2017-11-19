package com.linjun.pojo;

import java.util.List;

public class UserData {
    private Long id;
    private Long newuser;
    private  Long alluser;
    private List<Integer> weekUser;
    private  List<Integer> monthUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNewuser() {
        return newuser;
    }

    public void setNewuser(long newuser) {
        this.newuser = newuser;
    }

    public long getAlluser() {
        return alluser;
    }

    public void setAlluser(long alluser) {
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
}
