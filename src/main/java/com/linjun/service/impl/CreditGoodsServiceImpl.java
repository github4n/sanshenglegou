package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.domain.PeopleException;
import com.linjun.dao.CreditgoodsMapper;
import com.linjun.entity.PageBean;
import com.linjun.model.Creditgoods;
import com.linjun.model.CreditgoodsCriteria;
import com.linjun.service.CreditGoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreditGoodsServiceImpl implements CreditGoodsService {
    @Autowired
    CreditgoodsMapper creditgoodsMapper;
    @Override
    public Creditgoods add(Creditgoods creditgoods) {
        long result=creditgoodsMapper.insertSelective(creditgoods);
        if (result>0){
            return creditgoodsMapper.selectByPrimaryKey(result);
        }else {
        throw  new PeopleException("Tina机失败");
        }

    }

    @Override
    public int delete(Creditgoods creditgoods) {
        int result=creditgoodsMapper.deleteByPrimaryKey(creditgoods.getId());
        if (result>0){
            return result;
        }else {
            throw new PeopleException("删除失败");
        }
    }

    @Override
    public Creditgoods update(Creditgoods creditgoods) {
        int result=creditgoodsMapper.updateByPrimaryKeySelective(creditgoods);
        if (result>0){
            return creditgoodsMapper.selectByPrimaryKey(creditgoods.getId());
        }else {
        throw new PeopleException("更新失败");
        }

    }

    @Override
    public List<Creditgoods> findall() {
        CreditgoodsCriteria creditgoodsCriteria=new CreditgoodsCriteria();


        List<Creditgoods> list=creditgoodsMapper.selectByExample(creditgoodsCriteria);
        if (list!=null&&list.size()>0){
            return list;
        }else {
            throw new PeopleException("获取失败");
        }
    }

    @Override
    public PageBean<Creditgoods> findBypage(int cuurrentPage, int pagesize) {
        PageHelper.startPage(cuurrentPage,pagesize);
        CreditgoodsCriteria creditgoodsCriteria=new CreditgoodsCriteria();
        CreditgoodsCriteria.Criteria criteria=creditgoodsCriteria.createCriteria();


        List<Creditgoods> list=creditgoodsMapper.selectByExample(creditgoodsCriteria);
        long total=countcreditgoods();
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
        PageBean<Creditgoods> goodslist=new PageBean<Creditgoods>(total,cuurrentPage,pagesize,pages,sise,list);

        return goodslist;
    }

    @Override
    public long countcreditgoods() {
        CreditgoodsCriteria creditgoodsCriteria=new CreditgoodsCriteria();
        CreditgoodsCriteria.Criteria criteria=creditgoodsCriteria.createCriteria();
        return creditgoodsMapper.countByExample(creditgoodsCriteria);
    }

    @Override
    public Creditgoods finbyid(long id) {
        return creditgoodsMapper.selectByPrimaryKey(id);
    }
}
