package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.Goods;

import java.util.List;

public interface GoodsService {
    public boolean add(Goods goods);
    public int delete(long id);
    public List<Goods> findAll();
    public  List<Goods> findByStore(long storeid);
    public  Goods findByid(long ID);
    Goods addGoods(Goods goods);
    List<Goods> mainstore();
    List<Goods> yiwu();
    List<Goods>  composite();
    List<Goods> Villages();
    List<Goods> findByStoreID(long storeID);
    List<Goods> findByID(long id);
    long countGoods();
    long countInStore(long storeId);
    PageBean<Goods> findBySID(long storeId,int cuurrentPage,int pagesize);
}
