package com.linjun.service.impl;

import com.linjun.dao.GoodsBandMapper;
import com.linjun.model.GoodsBand;
import com.linjun.model.GoodsBandCriteria;
import com.linjun.service.GoodBandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsBandServiceImpl implements GoodBandService {
    @Autowired
    GoodsBandMapper goodsBandMapper;
    public boolean add(GoodsBand goodsBand) {
        return goodsBandMapper.insertSelective(goodsBand)>0;
    }

    public int deleteByid(long id) {
        return goodsBandMapper.deleteByPrimaryKey(id);
    }

    public int update(long id, GoodsBand goodsBand) {
        GoodsBandCriteria goodsBandCriteria=new GoodsBandCriteria();
        GoodsBandCriteria.Criteria criteria=goodsBandCriteria.createCriteria();
        criteria.andIdEqualTo(id);

        return goodsBandMapper.updateByExampleSelective(goodsBand,goodsBandCriteria);
    }

    public List<GoodsBand> findAll() {

        GoodsBandCriteria goodsBandCriteria=new GoodsBandCriteria();
        GoodsBandCriteria.Criteria criteria=goodsBandCriteria.createCriteria();
        return goodsBandMapper.selectByExample(goodsBandCriteria);
    }
}
