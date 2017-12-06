package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.WithDrawApply;

public interface WithDrawApplyService {
    PageBean<WithDrawApply> findAll(int currentpage,int pagesize);
    PageBean<WithDrawApply> findAllBystoreid(long storeid,int currentpage,int pagesize);
    Long countWithDraw();
    WithDrawApply update(WithDrawApply withDrawApply);
    int delete(long id);
    PageBean<WithDrawApply> findByStatus(byte status,int currentpage,int pagesize);
    Long acountByStatus(byte status);
    PageBean<WithDrawApply> search(String condition,int currentpage,int pagesize);
    PageBean<WithDrawApply> searchByStatus(String condition,byte status,int currentpage,int pagesize);
     WithDrawApply add(WithDrawApply withDrawApply);
     WithDrawApply isexit(WithDrawApply withDrawApply);
     WithDrawApply isStatus(WithDrawApply withDrawApply);
     Float balance (long storeid);
}
