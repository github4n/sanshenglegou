package com.linjun.service;

import com.linjun.model.AddressManger;

import java.util.List;

public interface AddressMongerService {
    public AddressManger add(AddressManger addressManger);
    public  int deleteByuserid(long userid);
    public List<AddressManger> findByuser(long userid);
    public AddressManger findByIsDeafult(long userid);
    public  int deleteByuan(long userid,String name);
    AddressManger findbyid(long id);
    AddressManger findByUseridDefault(long userid);
    int delelet(long id);
}
