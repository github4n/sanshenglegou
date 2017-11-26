package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.domain.PeopleException;
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
        if (list!=null&&list.size()>0){
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
        }else {
            throw new PeopleException("获取数据失败");
        }

    }

    @Override
    public Long countVillage() {
        VillageApplyCriteria villageApplyCriteria=new VillageApplyCriteria();

        return villageApplyMapper.countByExample(villageApplyCriteria);
    }

    @Override
    public VillageApply update(VillageApply villageApply) {
        int result=villageApplyMapper.updateByPrimaryKeySelective(villageApply);
        if (result>0){
            VillageApply villageApply1=villageApplyMapper.selectByPrimaryKey(villageApply.getId());
            return  villageApply1;
        }else {
            throw new PeopleException("更新失败");
        }

    }

    @Override
    public int delete(long id) {
        int result=villageApplyMapper.deleteByPrimaryKey(id);
        if (result>0){
            return  result;
        }else {
         throw new PeopleException("删除失败");
        }
    }

    @Override
    public PageBean<VillageApply> findByStatus(byte status, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        VillageApplyCriteria villageApplyCriteria=new VillageApplyCriteria();
        VillageApplyCriteria.Criteria criteria=villageApplyCriteria.createCriteria();
        criteria.andStutasEqualTo(status);
        List<VillageApply> list=villageApplyMapper.selectByExample(villageApplyCriteria);
        if (list!=null&& list.size()>0){
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
        }else {
            throw new PeopleException("获取数据失败");
        }

    }

    @Override
    public Long acountBystatus(byte status) {
         VillageApplyCriteria villageApplyCriteria=new VillageApplyCriteria();
        VillageApplyCriteria.Criteria criteria=villageApplyCriteria.createCriteria();
        criteria.andStutasEqualTo(status);
        return villageApplyMapper.countByExample(villageApplyCriteria);
    }

    @Override
    public PageBean<VillageApply> search(String condition, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);

        List<VillageApply> list=villageApplyMapper.dimfind("%"+condition+'%');
        if (list!=null&& list.size()>0){
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
        }else {
            throw new PeopleException("获取数据失败");
        }
    }

    @Override
    public PageBean<VillageApply> searchByStatus(String condition, byte status, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        List<VillageApply> list=villageApplyMapper.dimfindandstatus("%"+condition+'%',status);
        if (list!=null&& list.size()>0){
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
        }else {
            throw new PeopleException("获取数据失败");
        }
    }

    @Override
    public VillageApply add(VillageApply villageApply) {
        long result=villageApplyMapper.insertSelective(villageApply);
        if (result>0){
            return villageApplyMapper.selectByPrimaryKey(result);
        }else {
         throw  new PeopleException("添加失败");
        }
    }

    @Override
    public VillageApply isexit(VillageApply villageApply) {
        VillageApplyCriteria villageApplyCriteria=new VillageApplyCriteria();
        VillageApplyCriteria.Criteria criteria=villageApplyCriteria.createCriteria();
        criteria.andUseridEqualTo(villageApply.getUserid());
          List<VillageApply> list=villageApplyMapper.selectByExample(villageApplyCriteria);
          if (list!=null&&list.size()>0){
              return list.get(0);
          }else {
              throw new PeopleException("查询失败");
          }
    }

    @Override
    public VillageApply isStatus(VillageApply villageApply) {
        VillageApplyCriteria villageApplyCriteria=new VillageApplyCriteria();
        VillageApplyCriteria.Criteria criteria=villageApplyCriteria.createCriteria();
        criteria.andUseridEqualTo(villageApply.getUserid());
        criteria.andStutasEqualTo(villageApply.getStutas());
        List<VillageApply> list=villageApplyMapper.selectByExample(villageApplyCriteria);
        if (list!=null&&list.size()>0){
            return list.get(0);
        }else {
            throw new PeopleException("查询失败");
        }
    }
}
