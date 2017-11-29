package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.GoodsDetailMapper;
import com.linjun.model.GoodsDetail;
import com.linjun.model.GoodsDetailCriteria;
import com.linjun.service.GoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public GoodsDetail findByGoodsid(long goodid) {
        GoodsDetailCriteria goodsDetailCriteria=new GoodsDetailCriteria();
        GoodsDetailCriteria.Criteria criteria=goodsDetailCriteria.createCriteria();
        criteria.andGoodsidEqualTo(goodid);
        List<GoodsDetail> list=goodsDetailMapper.selectByExample(goodsDetailCriteria);
        if (list!=null&&list.size()>0){
            return list.get(0);
        }else {
         throw new PeopleException("获取详情失败");
        }
    }
}
