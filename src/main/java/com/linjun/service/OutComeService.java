package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.Outcome;

import java.util.List;

public interface OutComeService {
      PageBean<Outcome> findAll(int currentPage,int pagesize);
     List<Outcome> findToday();
     Long countOutCome();
    Float todayOutcome();
    Float sumOutcome();
    Float monthMoney();
     List<Float> weekMoney();
     List<Float> monthMoneys();
     Integer countDay();
     PageBean<Outcome> findBy(byte status,int currentPage,int paegsize);
     PageBean<Outcome> search(Object condition,int currentpage,int pagesize);
     PageBean<Outcome> searchByStatus(Object condition,byte status,int currentpage,int pagesize);

}
