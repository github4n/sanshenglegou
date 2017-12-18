package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.domain.PeopleException;
import com.linjun.dao.CreditgoodsMapper;
import com.linjun.dao.CreditorderMapper;
import com.linjun.entity.PageBean;
import com.linjun.model.CreditgoodsCriteria;
import com.linjun.model.Creditorder;
import com.linjun.model.CreditorderCriteria;
import com.linjun.service.CreditOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditOrderServiceImpl implements CreditOrderService {
    @Autowired
    CreditorderMapper creditorderMapper;
    @Override
    public Creditorder add(Creditorder creditorder) {
        long result=creditorderMapper.insertSelective(creditorder);
        if (result>0){
            return creditorderMapper.selectByPrimaryKey(result);
        }else {
            throw new PeopleException("失败");
        }



    }

    @Override
    public Creditorder update(Creditorder creditorder) {
        int result=creditorderMapper.updateByPrimaryKeySelective(creditorder);
        if (result>0){
            return creditorderMapper.selectByPrimaryKey(creditorder.getId());
        }else {
            throw new PeopleException("失败");
        }
    }

    @Override
    public PageBean<Creditorder> findall(int cuurrentPage, int pagesize) {

        PageHelper.startPage(cuurrentPage,pagesize);
        CreditorderCriteria creditgoodsCriteria=new CreditorderCriteria();
        CreditorderCriteria.Criteria criteria=creditgoodsCriteria.createCriteria();


        List<Creditorder> list=creditorderMapper.selectByExample(creditgoodsCriteria);
        long total=count();
        int pages,sise;
        if (total%cuurrentPage==0){
            pages= (int) (total/cuurrentPage);
        }else {
            pages= (int) (total/cuurrentPage)+1;
        }
        if (pages*pagesize==total){
            sise=cuurrentPage*pagesize;
        }else {
            if (cuurrentPage<pages){
                sise=cuurrentPage*pagesize;
            }else {
                sise= (int) total;
            }
        }
        PageBean<Creditorder> goodslist=new PageBean<Creditorder>(total,cuurrentPage,pagesize,pages,sise,list);

        return goodslist;


    }

    @Override
    public long count() {
        CreditorderCriteria creditorderCriteria=new CreditorderCriteria();
        CreditorderCriteria.Criteria criteria=creditorderCriteria.createCriteria();

        return creditorderMapper.countByExample(creditorderCriteria);
    }
}
