package com.linjun.service.impl;

import com.linjun.dao.GoodsTypeMapper;
import com.linjun.model.GoodsType;
import com.linjun.model.GoodsTypeCriteria;
import com.linjun.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Autowired
    GoodsTypeMapper goodsTypeMapper;
    public boolean add(GoodsType goodsType) {
        return goodsTypeMapper.insertSelective(goodsType)>0;
    }

    public int deleteByid(long id) {
        return goodsTypeMapper.deleteByPrimaryKey(id);
    }

    public int update(long id, GoodsType goodsType) {
        GoodsTypeCriteria goodsTypeCriteria=new GoodsTypeCriteria();
        GoodsTypeCriteria.Criteria criteria=goodsTypeCriteria.createCriteria();
        criteria.andIdEqualTo(id);

        return goodsTypeMapper.updateByExampleSelective(goodsType,goodsTypeCriteria);
    }

    public Long findByfather(long id) {
        GoodsTypeCriteria goodsTypeCriteria=new GoodsTypeCriteria();
        GoodsTypeCriteria.Criteria criteria=goodsTypeCriteria.createCriteria();
        criteria.andIdEqualTo(id);
        GoodsType goodsType= (GoodsType) goodsTypeMapper.selectByExample(goodsTypeCriteria);
        return goodsType.getFathertypeid();
    }

    @Override
    public GoodsType findById(long id) {
        return goodsTypeMapper.selectByPrimaryKey(id);
    }
}
