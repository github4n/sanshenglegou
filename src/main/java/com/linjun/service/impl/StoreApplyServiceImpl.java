package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.domain.PeopleException;
import com.linjun.dao.StoreApplyMapper;
import com.linjun.entity.PageBean;
import com.linjun.model.StoreApply;
import com.linjun.model.StoreApplyCriteria;
import com.linjun.service.StoreApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreApplyServiceImpl implements StoreApplyService {
    @Autowired
    StoreApplyMapper storeApplyMapper;
    @Override
    public PageBean<StoreApply> findAll(int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        StoreApplyCriteria villageApplyCriteria=new StoreApplyCriteria();
        List<StoreApply> list=storeApplyMapper.selectByExample(villageApplyCriteria);
        long total=countStoreApply();
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
        PageBean<StoreApply> lists=new PageBean<StoreApply>(total,currentpage,pagesize,pages,sise,list);
        return lists;
    }

    @Override
    public Long countStoreApply() {
        StoreApplyCriteria storeApplyCriteria=new StoreApplyCriteria();


        return storeApplyMapper.countByExample(storeApplyCriteria);
    }

    @Override
    public StoreApply update(StoreApply storeApply) {
        int result=storeApplyMapper.updateByPrimaryKeySelective(storeApply);
        if (result>0){
            StoreApply storeApply1=storeApplyMapper.selectByPrimaryKey(storeApply.getId());
            return  storeApply1;
        }else {
            throw  new PeopleException("更新失败");
        }
    }
}
