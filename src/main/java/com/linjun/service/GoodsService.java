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
    Goods updateGoods(Goods goods);
    PageBean<Goods> findBy(byte status,int currentpage,int paegsize);
    PageBean<Goods> search(Object condition,int currentpage,int paegsize);
    PageBean<Goods> searchByStatus(Object condition,byte status,int currentpage,int pagesize);
    List<Goods> searchgoods(Object condition);
    List<Goods> findBystoreid(Long storeid);
}
