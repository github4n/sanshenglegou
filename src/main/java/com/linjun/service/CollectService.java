package com.linjun.service;

import com.linjun.model.Collect;

import java.util.List;

public interface CollectService {
    public boolean add(Collect collect);
    public  int deleteByUserid(long userid);
    public List<Collect> findByuserid(long userid);

}
