package com.linjun.pojo;

import java.util.List;

public class StoreHeaderData {
    private long todayorder;
    private  long  todaypay;
    private  long ordersum;
    private  Float summoney;
    private  List<Float> weekpay;
    private List<Long> weekplan;
    private List<Integer> monthorder;
    private List<Integer> month;
    private  Float balance;

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public long getTodayorder() {
        return todayorder;
    }

    public void setTodayorder(long todayorder) {
        this.todayorder = todayorder;
    }

    public long getTodaypay() {
        return todaypay;
    }

    public void setTodaypay(long todaypay) {
        this.todaypay = todaypay;
    }

    public long getOrdersum() {
        return ordersum;
    }

    public void setOrdersum(long ordersum) {
        this.ordersum = ordersum;
    }

    public Float getSummoney() {
        return summoney;
    }

    public void setSummoney(Float summoney) {
        this.summoney = summoney;
    }

    public List<Float> getWeekpay() {
        return weekpay;
    }

    public void setWeekpay(List<Float> weekpay) {
        this.weekpay = weekpay;
    }

    public List<Long> getWeekplan() {
        return weekplan;
    }

    public void setWeekplan(List<Long> weekplan) {
        this.weekplan = weekplan;
    }

    public List<Integer> getMonthorder() {
        return monthorder;
    }

    public void setMonthorder(List<Integer> monthorder) {
        this.monthorder = monthorder;
    }

    public List<Integer> getMonth() {
        return month;
    }

    public void setMonth(List<Integer> month) {
        this.month = month;
    }
}
