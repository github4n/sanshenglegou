package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.Creditorder;

public interface CreditOrderService {
    Creditorder add(Creditorder creditorder);
    Creditorder update(Creditorder creditorder);
    PageBean<Creditorder> findall(int currentpage,int pagesize);
    long count();
}
