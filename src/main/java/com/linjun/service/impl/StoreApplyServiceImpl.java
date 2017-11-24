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
        if (list!=null&&list.size()>0){
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
        }else {
            throw new PeopleException("获取数据失败");
        }
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

    @Override
    public int delete(long id) {
         int result=storeApplyMapper.deleteByPrimaryKey(id);
         if (result>0){
             return result;
         }else {
             throw new PeopleException("删除失败");
         }
    }

    @Override
    public PageBean<StoreApply> findByStatus(byte status, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        StoreApplyCriteria storeApplyCriteria=new StoreApplyCriteria();
        StoreApplyCriteria.Criteria criteria=storeApplyCriteria.createCriteria();
        criteria.andStutasEqualTo(status);
        List<StoreApply> list=storeApplyMapper.selectByExample(storeApplyCriteria);
        if (list!=null&&list.size()>0){
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
        }else {
            throw new PeopleException("获取数据失败");
        }
    }

    @Override
    public Long count(byte status) {
        StoreApplyCriteria storeApplyCriteria=new StoreApplyCriteria();
        StoreApplyCriteria.Criteria criteria=storeApplyCriteria.createCriteria();
        criteria.andStutasEqualTo(status);
        return storeApplyMapper.countByExample(storeApplyCriteria);
    }

    @Override
    public PageBean<StoreApply> search(String condition, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);

        List<StoreApply> list=storeApplyMapper.dimfind('%'+condition+'%');
        if (list!=null&&list.size()>0){
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
        }else {
            throw new PeopleException("获取数据失败");
        }
    }

    @Override
    public PageBean<StoreApply> searchByStatus(String condition, byte status, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);

        List<StoreApply> list=storeApplyMapper.dimfindandstatus('%'+condition+'%',status);
        if (list!=null&&list.size()>0){
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
        }else {
            throw new PeopleException("获取数据失败");
        }
    }
}
