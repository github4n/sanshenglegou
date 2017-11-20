package com.linjun.pojo;

import io.swagger.models.auth.In;

import java.util.List;

public class DealImsgeData {
    private Float todayoutcome;
    private Float todayincome;
    private Float income;
    private Float outcome;
    private List<Float> weekIncome;
    private List<Float> weekOutcome;
    private List<Float> monthcome;
    private List<Float> monthMeneyincome;
    private  List<Float> monthMeneyoutcome;
    private  Integer moneyDay;

    public Integer getMoneyDay() {
        return moneyDay;
    }

    public void setMoneyDay(Integer moneyDay) {
        this.moneyDay = moneyDay;
    }

    public Float getTodayoutcome() {
        return todayoutcome;
    }

    public void setTodayoutcome(Float todayoutcome) {
        this.todayoutcome = todayoutcome;
    }

    public Float getTodayincome() {
        return todayincome;
    }

    public void setTodayincome(Float todayincome) {
        this.todayincome = todayincome;
    }

    public Float getIncome() {
        return income;
    }

    public void setIncome(Float income) {
        this.income = income;
    }

    public Float getOutcome() {
        return outcome;
    }

    public void setOutcome(Float outcome) {
        this.outcome = outcome;
    }

    public List<Float> getWeekIncome() {
        return weekIncome;
    }

    public void setWeekIncome(List<Float> weekIncome) {
        this.weekIncome = weekIncome;
    }

    public List<Float> getWeekOutcome() {
        return weekOutcome;
    }

    public void setWeekOutcome(List<Float> weekOutcome) {
        this.weekOutcome = weekOutcome;
    }

    public List<Float> getMonthcome() {
        return monthcome;
    }

    public void setMonthcome(List<Float> monthcome) {
        this.monthcome = monthcome;
    }

    public List<Float> getMonthMeneyincome() {
        return monthMeneyincome;
    }

    public void setMonthMeneyincome(List<Float> monthMeneyincome) {
        this.monthMeneyincome = monthMeneyincome;
    }

    public List<Float> getMonthMeneyoutcome() {
        return monthMeneyoutcome;
    }

    public void setMonthMeneyoutcome(List<Float> monthMeneyoutcome) {
        this.monthMeneyoutcome = monthMeneyoutcome;
    }
}
