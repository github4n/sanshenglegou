package com.linjun.service;

import com.linjun.model.Goods;

import java.util.List;

public interface GoodsService {
    public boolean add(Goods goods);
    public int delete(long id);
    public List<Goods> findAll();
    public  List<Goods> findByStore(long storeid);
    public  Goods findByid(long ID);
}
