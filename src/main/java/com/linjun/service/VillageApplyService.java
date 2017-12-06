package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.Banner;
import com.linjun.model.VillageApply;

public interface VillageApplyService {
    PageBean<VillageApply> findAll(int currentpage,int pagesize);
    Long countVillage();
    VillageApply update(VillageApply villageApply);
     int delete(long id);
     PageBean<VillageApply> findByStatus(byte status,int currentpage,int pagesize);
     Long acountBystatus(byte status);
     PageBean<VillageApply> search(String condition,int currentpage,int pagesize);
     PageBean<VillageApply> searchByStatus(String condition,byte status,int currentpage,int pagesize);
     VillageApply add(VillageApply villageApply);
    VillageApply isexit(VillageApply villageApply);
    VillageApply isStatus(VillageApply villageApply);
    VillageApply findbyid(long id);
}
