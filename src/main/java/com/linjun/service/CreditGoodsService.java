package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.Creditgoods;

import java.util.List;

public interface CreditGoodsService {
    Creditgoods add(Creditgoods creditgoods);
    int delete(Creditgoods creditgoods);
    Creditgoods update(Creditgoods creditgoods);
    List<Creditgoods> findall();
    PageBean<Creditgoods> findBypage(int currentpage,int pagesize);
    long countcreditgoods();
    Creditgoods finbyid(long id);
}
