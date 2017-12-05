package com.linjun.service;

import com.linjun.model.CreditDetail;

import java.util.List;

public interface CreditDetialService {
    public  boolean add(CreditDetail creditDetial);
    public CreditDetail update(CreditDetail creditDetial);
    public  int deletebyid(long creditid);
    public List<CreditDetail> findbyuserid(long userid);
}
