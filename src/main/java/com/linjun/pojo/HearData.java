package com.linjun.pojo;

import java.util.List;

public class HearData {
    private Long sumOrder;
    private Long sumStore;
    private  Long sumUser;
    private  Long sumMember;
    private List<Float> monthMoney;
    private  List<Integer> monthOrder;
    private List<Integer> monthvistor;
    private  List<Integer> monthpay;
  private  List<Integer> month;

    public List<Integer> getMonth() {
        return month;
    }

    public void setMonth(List<Integer> month) {
        this.month = month;
    }

    public Long getSumOrder() {
        return sumOrder;
    }

    public void setSumOrder(Long sumOrder) {
        this.sumOrder = sumOrder;
    }

    public Long getSumStore() {
        return sumStore;
    }

    public void setSumStore(Long sumStore) {
        this.sumStore = sumStore;
    }

    public Long getSumUser() {
        return sumUser;
    }

    public void setSumUser(Long sumUser) {
        this.sumUser = sumUser;
    }

    public Long getSumMember() {
        return sumMember;
    }

    public void setSumMember(Long sumMember) {
        this.sumMember = sumMember;
    }

    public List<Float> getMonthMoney() {
        return monthMoney;
    }

    public void setMonthMoney(List<Float> monthMoney) {
        this.monthMoney = monthMoney;
    }

    public List<Integer> getMonthOrder() {
        return monthOrder;
    }

    public void setMonthOrder(List<Integer> monthOrder) {
        this.monthOrder = monthOrder;
    }

    public List<Integer> getMonthvistor() {
        return monthvistor;
    }

    public void setMonthvistor(List<Integer> monthvistor) {
        this.monthvistor = monthvistor;
    }

    public List<Integer> getMonthpay() {
        return monthpay;
    }

    public void setMonthpay(List<Integer> monthpay) {
        this.monthpay = monthpay;
    }
}
