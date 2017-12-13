package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.Store;

import java.util.List;

public interface StoreService {
    public  Store add(Store store);
    public  int deletebyid(long id);
    public  int updatebyid(long id,Store store);
    public List<Store> findAll();
    public  Store findByid(long id);
    int deleteByuserid(long userid);
    Store findBystoreid(long storeuserid);
    Store createStore(Store store);
    Store loginByName(Store store);
    Store loginByid(Store store);
    Store loginByPhone(Store store);
    Store updateStore(Store store);
    PageBean<Store> findAllStore(int cuurrentPage, int pageSize);
    long countStore();
    PageBean<Store> findStart(int  currentpage,int pagesize);
    PageBean<Store> findShop(int currentpage,int pagesize);
    int changeList(List<Store> stores );
    int deleleList(List<Store> stores);
    List<Store> getaddstore();
}
