package com.linjun.service.impl;

import com.linjun.common.domain.PageList;
import com.linjun.dao.UserMapper;
import com.linjun.model.User;
import com.linjun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByKey(long id) {
        return null;
    }

    @Override
    public User findByusername(String username) {
        return null;
    }

    @Override
    public boolean isExits(String username, String password) {
        return false;
    }

    @Override
    public int updateByName(String name, User user) {
        return 0;
    }

    @Override
    public int deleteBykey(long id) {
        return 0;
    }

    @Override
    public int deleteByName(String username) {
        return 0;
    }

    @Override
    public PageList<User> search(String username, Integer page) {
        return null;
    }

    @Override
    public PageList<User> searchSize(String username, Integer page) {
        return null;
    }

    @Override
    public User loginByPhone(User user) {
        return null;
    }

    @Override
    public User loginByUsername(User user) {
        return null;
    }

    @Override
    public User registerByPhone(User user) {
        return null;
    }

    @Override
    public User getUserByUserid(long userid) {
        return null;
    }

    @Override
    public List<User> userlist() {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
