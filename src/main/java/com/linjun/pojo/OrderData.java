package com.linjun.pojo;

import java.util.List;

public class OrderData {
    private  Long id;
    private  Long  noworder;
    private  Long nowOrderPay;
    private  Float todayMoney;
    private  Long orderSum;
    private  Float moneySum;
    private List<Float> weekMoney;
    private  List<Integer> monthMoney;
    private  List<Long> weekPlan;
    private  Integer monthDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNoworder() {
        return noworder;
    }

    public void setNoworder(Long noworder) {
        this.noworder = noworder;
    }

    public Long getNowOrderPay() {
        return nowOrderPay;
    }

    public void setNowOrderPay(Long nowOrderPay) {
        this.nowOrderPay = nowOrderPay;
    }

    public Float getTodayMoney() {
        return todayMoney;
    }

    public void setTodayMoney(Float todayMoney) {
        this.todayMoney = todayMoney;
    }

    public Long getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(Long orderSum) {
        this.orderSum = orderSum;
    }

    public Float getMoneySum() {
        return moneySum;
    }

    public void setMoneySum(Float moneySum) {
        this.moneySum = moneySum;
    }

    public List<Float> getWeekMoney() {
        return weekMoney;
    }

    public void setWeekMoney(List<Float> weekMoney) {
        this.weekMoney = weekMoney;
    }

    public List<Integer> getMonthMoney() {
        return monthMoney;
    }

    public void setMonthMoney(List<Integer> monthMoney) {
        this.monthMoney = monthMoney;
    }

    public List<Long> getWeekPlan() {
        return weekPlan;
    }

    public void setWeekPlan(List<Long> weekPlan) {
        this.weekPlan = weekPlan;
    }

    public Integer getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(Integer monthDay) {
        this.monthDay = monthDay;
    }
}
