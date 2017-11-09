package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.GoodsMapper;
import com.linjun.model.Goods;
import com.linjun.model.GoodsCriteria;
import com.linjun.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    public boolean add(Goods goods) {
        return goodsMapper.insertSelective(goods)>0;
    }

    public int delete(long id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }

    public List<Goods> findAll() {
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        GoodsCriteria.Criteria criteria=goodsCriteria.createCriteria();
        return goodsMapper.selectByExample(goodsCriteria);
    }

    public List<Goods> findByStore(long storeid) {
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        GoodsCriteria.Criteria criteria=goodsCriteria.createCriteria();
        criteria.andStoreidEqualTo(storeid);
        return goodsMapper.selectByExample(goodsCriteria);
    }

    public Goods findByid(long ID) {

        return goodsMapper.selectByPrimaryKey(ID);
    }

    @Override
    public Goods addGoods(Goods goods) {
        int result=goodsMapper.insertSelective(goods);
        if (result>0){
            return  goods;
        }else {
            throw new PeopleException("添加商品失败");
        }
    }

    @Override
    public List<Goods> mainstore() {
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        goodsCriteria.createCriteria().andTypeidEqualTo((long) 1);

        List<Goods> mainstorelist=goodsMapper.selectByExample(goodsCriteria);
        return mainstorelist;
    }

    @Override
    public List<Goods> yiwu() {
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        goodsCriteria.createCriteria().andTypeidEqualTo((long) 2);

        List<Goods> yiwulist=goodsMapper.selectByExample(goodsCriteria);
        return yiwulist;
    }

    @Override
    public List<Goods> composite() {
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        goodsCriteria.createCriteria().andTypeidEqualTo((long) 1);

        List<Goods> compositelist=goodsMapper.selectByExample(goodsCriteria);
        return compositelist;
    }

    @Override
    public List<Goods> Villages() {
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        goodsCriteria.createCriteria().andTypeidEqualTo((long) 1);

        List<Goods> vilagelist=goodsMapper.selectByExample(goodsCriteria);
        return vilagelist;
    }

    @Override
    public List<Goods> findByStoreID(long storeID) {
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        goodsCriteria.createCriteria().andStoreidEqualTo(storeID);
        List<Goods> list=goodsMapper.selectByExample(goodsCriteria);
        if (list.size()!=0){
            return list;
        }else {
            throw new PeopleException("查询失败");
        }
    }

    @Override
    public List<Goods> findByID(long id) {
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        goodsCriteria.createCriteria().andTypeidEqualTo(id);
        return goodsMapper.selectByExample(goodsCriteria);
    }


}
