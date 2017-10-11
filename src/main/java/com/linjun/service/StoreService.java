package com.linjun.service;

import com.linjun.model.Store;

import java.util.List;

public interface StoreService {
    public  boolean add(Store store);
    public  int deletebyid(long id);
    public  int updatebyid(long id,Store store);
    public List<Store> findAll();
    public  Store findByid(long id);
}
