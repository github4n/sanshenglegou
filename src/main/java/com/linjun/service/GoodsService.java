package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.Goods;

import java.util.List;

public interface GoodsService {

     boolean delete(long id);
      Goods findByid(long ID);
    Goods addGoods(Goods goods);
    PageBean<Goods> findByID(long id,int cuurrentPage,int pagesize);
    long countGoods();
    long countInStore(long storeId);
    long countInType(long typeID);
    PageBean<Goods> findBySID(long storeId,int cuurrentPage,int pagesize);
//    所有的商品
    PageBean<Goods>  goodsAll(int cuurrentPage,int pagessize);
}
