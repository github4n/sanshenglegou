package com.linjun.service.impl;
import com.linjun.dao.GoodsAttributeMapper;
import com.linjun.model.GoodsAttribute;
import com.linjun.model.GoodsAttributeCriteria;
import com.linjun.service.GoodsAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsAttributeServiceImpl implements GoodsAttributeService {
    @Autowired
    GoodsAttributeMapper goodsAttributeMapper;
    public boolean add(GoodsAttribute goodsAttribute) {
        return goodsAttributeMapper.insertSelective(goodsAttribute)>0;
    }

    public int deleteBy(long id) {
        return goodsAttributeMapper.deleteByPrimaryKey(id);
    }

    public int update(long id, GoodsAttribute goodsAttribute) {
        GoodsAttributeCriteria goodsAttributeCriteria=new GoodsAttributeCriteria();
        GoodsAttributeCriteria.Criteria criteria=goodsAttributeCriteria.createCriteria();
        criteria.andIdEqualTo(id);
        return goodsAttributeMapper.deleteByExample(goodsAttributeCriteria);
    }
}
