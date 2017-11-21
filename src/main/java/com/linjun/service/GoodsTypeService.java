package com.linjun.service;

import com.linjun.model.GoodsType;

public interface GoodsTypeService {
    public  boolean add(GoodsType goodsType);
    public  int deleteByid(long id);
    public  int update(long id,GoodsType goodsType);
    public Long findByfather(long id);
    GoodsType findById(long id);
    GoodsType update(GoodsType goodsType);
}
