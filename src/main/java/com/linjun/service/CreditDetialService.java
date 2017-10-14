package com.linjun.service;

import com.linjun.model.CreditDetail;

import java.util.List;

public interface CreditDetialService {
    public  boolean add(CreditDetail creditDetial);
    public int update(long creditid,CreditDetail creditDetial);
    public  int deletebyid(long creditid);
    public List<CreditDetail> findbyuserid(long userid);
}
