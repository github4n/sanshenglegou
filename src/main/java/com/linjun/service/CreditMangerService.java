package com.linjun.service;

import com.linjun.model.CreditManger;

public interface CreditMangerService {
    public boolean add(CreditManger creditManger);
    public  CreditManger updateByuserid(CreditManger creditManger);
    public  int deleteByuserid(long userid);
    public  CreditManger findByuserid(long userid);
    boolean isexit(long id);
}
