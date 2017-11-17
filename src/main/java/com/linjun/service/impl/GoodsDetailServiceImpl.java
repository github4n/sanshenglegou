package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.GoodsDetailMapper;
import com.linjun.model.GoodsDetail;
import com.linjun.service.GoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsDetailServiceImpl implements GoodsDetailService {
    @Autowired
    GoodsDetailMapper goodsDetailMapper;


    @Override
    public GoodsDetail add(GoodsDetail goodsDetail) {
        int result=goodsDetailMapper.insertSelective(goodsDetail);
        if (result>0){
            return findByID(result);
        }else {
            throw new PeopleException("添加失败");
        }
    }

    @Override
    public boolean delete(long id) {
        int result=goodsDetailMapper.deleteByPrimaryKey(id);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public GoodsDetail findByID(long id) {
        return goodsDetailMapper.selectByPrimaryKey(id);
    }
}
