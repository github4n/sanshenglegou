package com.linjun.service;

import com.linjun.model.Offline;

import java.util.List;

public interface OffLineService {
    public  boolean add(Offline offline);
    public  int deleteByuserid(long userid);
    public List<Offline> findByuserid(long userid);
}

