package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.StoreApply;

public interface StoreApplyService {
    PageBean<StoreApply> findAll(int currentpage,int pagesize);
    Long countStoreApply();
     StoreApply update(StoreApply storeApply);
     int delete(long id);
     PageBean<StoreApply> findByStatus(byte status,int currentpage,int pagesize);
     Long count(byte status);
     PageBean<StoreApply> search(String condition,int currentpage,int pagesize);
     PageBean<StoreApply> searchByStatus(String condition,byte status,int currentpage,int pagesize);
     StoreApply add(StoreApply storeApply);
     StoreApply isexit(StoreApply storeApply);
     StoreApply isStutsa(StoreApply storeApply);
}
