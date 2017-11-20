package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.Income;

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
}
