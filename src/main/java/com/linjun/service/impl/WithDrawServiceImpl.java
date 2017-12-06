package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.domain.PeopleException;
import com.linjun.dao.StoreMapper;
import com.linjun.dao.WithDrawApplyMapper;
import com.linjun.entity.PageBean;
import com.linjun.model.StoreCriteria;
import com.linjun.model.WithDrawApply;
import com.linjun.model.WithDrawApplyCriteria;
import com.linjun.service.WithDrawApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithDrawServiceImpl implements WithDrawApplyService {
    @Autowired
    WithDrawApplyMapper withDrawApplyMapper;
    @Autowired
    StoreMapper storeMapper;
    @Override
    public PageBean<WithDrawApply> findAll(int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        WithDrawApplyCriteria villageApplyCriteria=new WithDrawApplyCriteria();
        List<WithDrawApply> list=withDrawApplyMapper.selectByExample(villageApplyCriteria);
        if (list!=null&&list.size()>0){
            long total=countWithDraw();
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
            PageBean<WithDrawApply> lists=new PageBean<WithDrawApply>(total,currentpage,pagesize,pages,sise,list);
            return lists;
        }else {
            throw new PeopleException("获取数据失败");
        }
    }

    @Override
    public PageBean<WithDrawApply> findAllBystoreid(long storeid, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        WithDrawApplyCriteria villageApplyCriteria=new WithDrawApplyCriteria();
        WithDrawApplyCriteria.Criteria criteria=villageApplyCriteria.createCriteria();
        long userid=storeMapper.selectByPrimaryKey(storeid).getStoreuserid();
        criteria.andUseridEqualTo(userid);
        List<WithDrawApply> list=withDrawApplyMapper.selectByExample(villageApplyCriteria);
        if (list!=null&&list.size()>0){
            long total=countWithDraw();
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
            PageBean<WithDrawApply> lists=new PageBean<WithDrawApply>(total,currentpage,pagesize,pages,sise,list);
            return lists;
        }else {
            throw  new PeopleException("获取失败");
        }
    }

    @Override
    public Long countWithDraw() {
        WithDrawApplyCriteria withDrawApplyCriteria=new WithDrawApplyCriteria();
        return withDrawApplyMapper.countByExample(withDrawApplyCriteria);
    }

    @Override
    public WithDrawApply update(WithDrawApply withDrawApply) {
          int result=withDrawApplyMapper.updateByPrimaryKeySelective(withDrawApply);
          if (result>0){
              WithDrawApply withDrawApply1=withDrawApplyMapper.selectByPrimaryKey(withDrawApply.getId());
              return  withDrawApply1;
          }else {
              throw new PeopleException("更新失败");
          }
    }

    @Override
    public int delete(long id) {
        int result=withDrawApplyMapper.deleteByPrimaryKey(id);
        if (result>0){
            return  result;

        }else {
         throw  new PeopleException("删除失败");
        }
    }

    @Override
    public PageBean<WithDrawApply> findByStatus(byte status, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        WithDrawApplyCriteria withDrawApplyCriteria=new WithDrawApplyCriteria();
        WithDrawApplyCriteria.Criteria criteria=withDrawApplyCriteria.createCriteria();
        criteria.andStutasEqualTo(status);
        List<WithDrawApply> list=withDrawApplyMapper.selectByExample(withDrawApplyCriteria);
        if (list!=null&&list.size()>0){
            long total=countWithDraw();
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
            PageBean<WithDrawApply> lists=new PageBean<WithDrawApply>(total,currentpage,pagesize,pages,sise,list);
            return lists;
        }else {
            throw new PeopleException("获取数据失败");
        }


    }

    @Override
    public Long acountByStatus(byte status) {
        WithDrawApplyCriteria withDrawApplyCriteria=new WithDrawApplyCriteria();
        WithDrawApplyCriteria.Criteria criteria=withDrawApplyCriteria.createCriteria();
        criteria.andStutasEqualTo(status);
        return withDrawApplyMapper.countByExample(withDrawApplyCriteria);
    }

    @Override
    public PageBean<WithDrawApply> search(String condition, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);

        List<WithDrawApply> list=withDrawApplyMapper.dimfind('%'+condition+'%');
        if (list!=null&&list.size()>0){
            long total=countWithDraw();
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
            PageBean<WithDrawApply> lists=new PageBean<WithDrawApply>(total,currentpage,pagesize,pages,sise,list);
            return lists;
        }else {
            throw new PeopleException("获取数据失败");
        }

    }

    @Override
    public PageBean<WithDrawApply> searchByStatus(String condition, byte status, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);

        List<WithDrawApply> list=withDrawApplyMapper.dimfindandstatus('%'+condition+'%',status);
        if (list!=null&&list.size()>0){
            long total=countWithDraw();
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
            PageBean<WithDrawApply> lists=new PageBean<WithDrawApply>(total,currentpage,pagesize,pages,sise,list);
            return lists;
        }else {
            throw new PeopleException("获取数据失败");
        }
    }

    @Override
    public WithDrawApply add(WithDrawApply withDrawApply) {
        long result= withDrawApplyMapper.insertSelective(withDrawApply);
        if (result>0){
            return withDrawApplyMapper.selectByPrimaryKey(result);
        }else {
         throw new PeopleException("添加失败");
        }
    }

    @Override
    public WithDrawApply isexit(WithDrawApply withDrawApply) {
        WithDrawApplyCriteria withDrawApplyCriteria=new WithDrawApplyCriteria();
        WithDrawApplyCriteria.Criteria criteria=withDrawApplyCriteria.createCriteria();
        criteria.andUseridEqualTo(withDrawApply.getUserid());
        List<WithDrawApply> list=withDrawApplyMapper.selectByExample(withDrawApplyCriteria);
        if (list!=null&&list.size()>0){
            return list.get(0);
        }else {
        throw new PeopleException("获取数据失败");
        }

    }

    @Override
    public WithDrawApply isStatus(WithDrawApply withDrawApply) {
        WithDrawApplyCriteria withDrawApplyCriteria=new WithDrawApplyCriteria();
        WithDrawApplyCriteria.Criteria criteria=withDrawApplyCriteria.createCriteria();
        criteria.andUseridEqualTo(withDrawApply.getUserid());
        criteria.andStutasEqualTo(withDrawApply.getStutas());
        List<WithDrawApply> list=withDrawApplyMapper.selectByExample(withDrawApplyCriteria);
        if (list!=null&&list.size()>0){
            return list.get(0);
        }else {
            throw new PeopleException("获取数据失败");
        }
    }

    @Override
    public Float balance(long storeid) {
        long userid=storeMapper.selectByPrimaryKey(storeid).getStoreuserid();
          WithDrawApplyCriteria withDrawApplyCriteria =new WithDrawApplyCriteria();
        WithDrawApplyCriteria.Criteria criteria=withDrawApplyCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andStutasEqualTo((byte) 1);
        List<WithDrawApply> list=withDrawApplyMapper.selectByExample(withDrawApplyCriteria);
        Float balance = null;
        for (int i = 0; i <list.size() ; i++) {
            balance+=list.get(i).getPrice();

        }

        return balance;
    }
}
