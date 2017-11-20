package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.dao.VillageApplyMapper;
import com.linjun.entity.PageBean;
import com.linjun.model.VillageApply;
import com.linjun.model.VillageApplyCriteria;
import com.linjun.service.VillageApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillageApplyServiceImpl implements VillageApplyService {
    @Autowired
    VillageApplyMapper villageApplyMapper;
    @Override
    public PageBean<VillageApply> findAll(int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        VillageApplyCriteria villageApplyCriteria=new VillageApplyCriteria();
        List<VillageApply> list=villageApplyMapper.selectByExample(villageApplyCriteria);
        long total=countVillage();
        int pages,sise;
        if (total%currentpage==0){
           pages = (int) (total/currentpage);
        }else {
            pages= (int) (total/currentpage)+1;
        }
        if (pages*pagesize==total){
            sise=currentpage*pagesize;
        }else {
            if (currentpage<pages){
                sise=currentpage*pagesize;
            }else {
                sise= (int) total;
            }
        }
         PageBean<VillageApply> lists=new PageBean<VillageApply>(total,currentpage,pagesize,pages,sise,list);
        return lists;
    }

    @Override
    public Long countVillage() {
        VillageApplyCriteria villageApplyCriteria=new VillageApplyCriteria();

        return villageApplyMapper.countByExample(villageApplyCriteria);
    }
}
