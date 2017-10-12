package com.linjun.service;

import com.linjun.common.domain.PageList;
import com.linjun.model.User;
import com.sun.tools.corba.se.idl.StringGen;

import java.util.List;

public interface UserService {
    public int add(User user);
    public List<User> findAll();
    public  User findByKey(long id);
    public  User findByusername(String username);
    public  boolean isExits(String username,String password);
    public  int updateByName(String name,User user);
    public  int deleteBykey(long id);
    public  int deleteByName(String username);

    PageList<User> search(String username,Integer page);
    PageList<User> searchSize(String username,Integer page);
}
