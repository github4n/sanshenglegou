package com.linjun.service;

import com.linjun.model.GoodsBand;

import java.util.List;

public interface GoodBandService {
    public  boolean add(GoodsBand goodsBand);
    public int deleteByid(long id);
    public  int update(long id, GoodsBand goodsBand);
    public List<GoodsBand> findAll();

}
