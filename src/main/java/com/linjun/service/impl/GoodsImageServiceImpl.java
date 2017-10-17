package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.GoodsImageMapper;
import com.linjun.model.GoodsImage;
import com.linjun.model.GoodsImageCriteria;
import com.linjun.service.GoodsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsImageServiceImpl implements GoodsImageService {
    @Autowired
    GoodsImageMapper goodsImageMapper;
    public boolean add(GoodsImage goodsImage) {
        return goodsImageMapper.insertSelective(goodsImage)>0;
    }

    public int deletebygoodsid(long goodsid) {
        GoodsImageCriteria goodsImageCriteria=new GoodsImageCriteria();
        GoodsImageCriteria.Criteria criteria=goodsImageCriteria.createCriteria();
        criteria.andGoodsidEqualTo(goodsid);

        return goodsImageMapper.deleteByExample(goodsImageCriteria);
    }

    public int update(long goodsid, GoodsImage goodsImage) {

        GoodsImageCriteria goodsImageCriteria=new GoodsImageCriteria();
        GoodsImageCriteria.Criteria criteria=goodsImageCriteria.createCriteria();
        criteria.andGoodsidEqualTo(goodsid);
        return goodsImageMapper.updateByExampleSelective(goodsImage,goodsImageCriteria);
    }

    public List<GoodsImage> find(long goodsid) {

        GoodsImageCriteria goodsImageCriteria=new GoodsImageCriteria();
        GoodsImageCriteria.Criteria criteria=goodsImageCriteria.createCriteria();
        criteria.andGoodsidEqualTo(goodsid);
        return goodsImageMapper.selectByExample(goodsImageCriteria);
    }

    @Override
    public GoodsImage findMainImage(long goodsid) {
        GoodsImageCriteria goodsImageCriteria=new GoodsImageCriteria();
        goodsImageCriteria.createCriteria().andGoodsidEqualTo(goodsid);
        goodsImageCriteria.createCriteria().andIskeyiamgeEqualTo((byte) 1);
        List<GoodsImage> list=goodsImageMapper.selectByExample(goodsImageCriteria);
        if (list!=null&&list.size()==1){
            GoodsImage goodsImage=list.get(0);
           return goodsImage ;
        }else {

            throw new PeopleException("主图查询失败");
        }

    }
}
