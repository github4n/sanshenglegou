package com.linjun.service;

import com.linjun.model.Sign;

import java.util.List;

public interface SignService {
    public boolean add(Sign sign);
    public  int deleteByuserid(long userid);
    public List<Sign> findByuserid(long userid);

}
