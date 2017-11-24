package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.domain.PeopleException;
import com.linjun.dao.MemberApplyMapper;
import com.linjun.entity.PageBean;
import com.linjun.model.MemberApply;
import com.linjun.model.MemberApplyCriteria;
import com.linjun.service.MemberApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberApplyServiceImpl implements MemberApplyService {
    @Autowired
    MemberApplyMapper memberApplyMapper;
    @Override
    public PageBean<MemberApply> findAll(int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        MemberApplyCriteria memberApplyCriteria=new MemberApplyCriteria();
        List<MemberApply> list=memberApplyMapper.selectByExample(memberApplyCriteria);
        if (list.size()>0&&list!=null){
            long total=countMapply();
            int pages,size;
            if (total%currentpage==0){
                pages= (int) (total/currentpage);
            }else {
                pages= (int) (total/currentpage)+1;
            }
            if (pages*pagesize==total){
                size=currentpage*pagesize;
            }else {
                if (currentpage<pages){
                    size=currentpage*pagesize;
                }else {
                    size= (int) total;
                }
            }
            PageBean<MemberApply> lists=new PageBean<MemberApply>(total,currentpage,pagesize,pages,size,list);
            return lists;
        }else {
            throw new PeopleException("查询失败");
        }

    }

    @Override
    public Long countMapply() {
        MemberApplyCriteria memberApplyCriteria=new MemberApplyCriteria();
        return memberApplyMapper.countByExample(memberApplyCriteria);
    }

    @Override
    public MemberApply update(MemberApply memberApply) {
          int reslut=memberApplyMapper.updateByPrimaryKeySelective(memberApply);
          if (reslut>0){
              return memberApplyMapper.selectByPrimaryKey(memberApply.getId());
          }else {
              throw  new PeopleException("更新失败");
          }
    }

    @Override
    public int delete(long id) {
        int result=memberApplyMapper.deleteByPrimaryKey(id);
        if (result>0){
   return result;
        }else {
            throw new PeopleException("删除失败");
        }
    }

    @Override
    public PageBean<MemberApply> findByStatus(byte status,int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        MemberApplyCriteria memberApplyCriteria=new MemberApplyCriteria();
        MemberApplyCriteria.Criteria criteria=memberApplyCriteria.createCriteria();
        criteria.andStutasEqualTo(status);

        List<MemberApply> list=memberApplyMapper.selectByExample(memberApplyCriteria);
        if (list!=null&&list.size()>0){
            long total=countMapply();
            int pages,size;
            if (total%currentpage==0){
                pages= (int) (total/currentpage);
            }else {
                pages= (int) (total/currentpage)+1;
            }
            if (pages*pagesize==total){
                size=currentpage*pagesize;
            }else {
                if (currentpage<pages){
                    size=currentpage*pagesize;
                }else {
                    size= (int) total;
                }
            }
            PageBean<MemberApply> lists=new PageBean<MemberApply>(total,currentpage,pagesize,pages,size,list);
            return lists;
        }else {
            throw  new PeopleException("查询失败");
        }



    }

    @Override
    public Long countByStatus(byte status) {
        MemberApplyCriteria memberApplyCriteria=new MemberApplyCriteria();
        MemberApplyCriteria.Criteria criteria=memberApplyCriteria.createCriteria();
        criteria.andStutasEqualTo(status);
        return memberApplyMapper.countByExample(memberApplyCriteria);
    }

    @Override
    public PageBean<MemberApply> findBy(String condition, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        MemberApplyCriteria memberApplyCriteria=new MemberApplyCriteria();
        MemberApplyCriteria.Criteria criteria=memberApplyCriteria.createCriteria();

           criteria.andUsernameLike('%'+condition+'%');
//        List<MemberApply> list=memberApplyMapper.selectByExample(memberApplyCriteria);
        List<MemberApply> list=memberApplyMapper.dimfind('%'+condition+'%');

        if (list!=null&&list.size()>0){
            long total=countMapply();
            int pages,size;
            if (total%currentpage==0){
                pages= (int) (total/currentpage);
            }else {
                pages= (int) (total/currentpage)+1;
            }
            if (pages*pagesize==total){
                size=currentpage*pagesize;
            }else {
                if (currentpage<pages){
                    size=currentpage*pagesize;
                }else {
                    size= (int) total;
                }
            }
            PageBean<MemberApply> lists=new PageBean<MemberApply>(total,currentpage,pagesize,pages,size,list);
            return lists;
        }else {
            throw new PeopleException("查询失败");

        }


    }

    @Override
    public PageBean<MemberApply> findByStatus(String condition, byte status, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);

        List<MemberApply> list=memberApplyMapper.dimfindandstatus('%'+condition+'%',status);

        if (list!=null&&list.size()>0){
            long total=countMapply();
            int pages,size;
            if (total%currentpage==0){
                pages= (int) (total/currentpage);
            }else {
                pages= (int) (total/currentpage)+1;
            }
            if (pages*pagesize==total){
                size=currentpage*pagesize;
            }else {
                if (currentpage<pages){
                    size=currentpage*pagesize;
                }else {
                    size= (int) total;
                }
            }
            PageBean<MemberApply> lists=new PageBean<MemberApply>(total,currentpage,pagesize,pages,size,list);
            return lists;
        }else {
            throw new PeopleException("查询失败");

        }

    }
}
