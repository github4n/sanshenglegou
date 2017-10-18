package com.linjun.service;

import com.linjun.model.AddressManger;

import java.util.List;

public interface AddressMongerService {
    public boolean add(AddressManger addressManger);
    public  int deleteByuserid(long userid);
    public List<AddressManger> findByuser(long userid);
    public AddressManger findByIsDeafult(long userid,int label);
    public  int deleteByuan(long userid,String name);
    AddressManger findbyid(long id);
    AddressManger findByUserid(long userid);
}
