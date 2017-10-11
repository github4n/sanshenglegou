package com.linjun.service.impl;

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
}
