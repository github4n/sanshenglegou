package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.StoreApply;

public interface StoreApplyService {
    PageBean<StoreApply> findAll(int currentpage,int pagesize);
    Long countStoreApply();
     StoreApply update(StoreApply storeApply);
}
