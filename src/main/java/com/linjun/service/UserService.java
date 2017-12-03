package com.linjun.service;

import com.linjun.common.domain.PageList;
import com.linjun.entity.PageBean;
import com.linjun.model.User;


import java.util.List;

public interface UserService {
    public User add(User user);
    public List<User> findAll();
    public  User findByID(long id);
    public  User findByusername(String username);
    public  boolean isExits(String username,String password);
    public  int updateByName(String name,User user);
    public  int deleteBykey(long id);
    public  int deleteByName(String username);
        long countUser();
        long countUserNew();
        List<Integer> nowWeekuser();
        List<Integer>  nowMonthUser();
    PageList<User> search(String username,Integer page);
    PageList<User> searchSize(String username, Integer page);
    User loginByPhone(User user);
    User loginByUsername(User user);
    User registerByPhone(User user);
    User getUserByUserid(long userid);
    List<User> userlist ();
    User updateUser(User user);
   PageBean<User> findUserList(int cuurrentPage, int pageSize);
      Integer monthDay();
      Long countMenber();
   List<Integer> lookuser();
      User findByOpenid(User user);
   PageBean<User> search(Object condition,int currentpage,int pagesize);
   PageBean<User> searchByStatus(Object condition,byte status,int currentpage,int pagesize);
  User findByopenid(String openid);
   boolean isExitByopenid(String openid);
}
