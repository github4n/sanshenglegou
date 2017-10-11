package com.linjun.service;

import com.linjun.model.GoodsAttribute;

public interface GoodsAttributeService {
    public  boolean add(GoodsAttribute goodsAttribute);
    public  int deleteBy(long id);
    public  int update(long id,GoodsAttribute goodsAttribute);


}
