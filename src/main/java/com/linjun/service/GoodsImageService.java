package com.linjun.service;

import com.linjun.model.GoodsImage;

import java.util.List;

public interface GoodsImageService {
    public  boolean add(GoodsImage goodsImage);
    public  int deletebygoodsid(long goodsid);
    public  int update(long goodsid,GoodsImage goodsImage);
    public List<GoodsImage> find(long goodsid);
    GoodsImage findMainImage(long goodsid);
}
