package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.VillageApply;

public interface VillageApplyService {
    PageBean<VillageApply> findAll(int currentpage,int pagesize);
    Long countVillage();

}
