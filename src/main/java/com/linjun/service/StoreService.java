package com.linjun.service;

import com.linjun.model.Store;

import java.util.List;

public interface StoreService {
    public  boolean add(Store store);
    public  int deletebyid(long id);
    public  int updatebyid(long id,Store store);
    public List<Store> findAll();
    public  Store findByid(long id);
    int deleteByuserid(long userid);
    Store findBystoreid(long storeuserid);
    Store createStore(Store store);
    Store loginByName(Store store);
    Store loginByid(Store store);
    Store updateStore(Store store);

}
