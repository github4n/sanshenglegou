package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.Income;
import io.swagger.models.auth.In;

import java.util.List;

public interface InComeService {
    PageBean<Income> findall(int currentpage,int pagesize);
    Long countIncome();
    Float todayincome();
    Float sumincome();
    Float monthcome();
    List<Float> weekincome();
    List<Float> monthincome();
      Integer monthday();
      PageBean<Income> findBy(byte status,int currentpage,int pagesize);
      PageBean<Income> search(Object condition,int currentpage,int pagesize);
      PageBean<Income> searchByStatus(Object condition,byte status,int currentpage,int pagesize);

}
