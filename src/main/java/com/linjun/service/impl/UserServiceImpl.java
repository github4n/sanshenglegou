package com.linjun.service.impl;

import com.linjun.common.domain.PageBounds;
import com.linjun.common.domain.PageList;
import com.linjun.dao.UserMapper;
import com.linjun.model.User;
import com.linjun.model.UserCriteria;
import com.linjun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public int add(User user) {
        return userMapper.insertSelective(user);
    }

    public List<User> findAll() {
        UserCriteria userCriteria=new UserCriteria();
        return userMapper.selectByExample(userCriteria) ;
    }

    public User findByKey(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User findByusername(String username) {
        UserCriteria userCriteria=new UserCriteria();
        UserCriteria.Criteria criteria=userCriteria.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andIdIsNotNull();
        return (User) userMapper.selectByExample(userCriteria);
    }

    public boolean isExits(String username,String passworld) {
        UserCriteria userCriteria=new UserCriteria();
        UserCriteria.Criteria criteria=userCriteria.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPassworldEqualTo(passworld);
    if (userMapper.selectByExample(userCriteria)!=null){
        return  true;
    }else {
        return  false;
    }
    }

    public int updateByName(String name, User user) {
        UserCriteria userCriteria =new UserCriteria();
        UserCriteria.Criteria criteria=userCriteria.createCriteria();
        criteria.andUsernameEqualTo(name);
        return userMapper.updateByExampleSelective(user,userCriteria);
    }

    public int deleteBykey(long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public int deleteByName(String username) {
        UserCriteria userCriteria=new UserCriteria();
        UserCriteria.Criteria criteria=userCriteria.createCriteria();
        criteria.andUsernameEqualTo(username);

        return userMapper.deleteByExample(userCriteria);
    }

    public PageList<User> search(String username, Integer page) {
        Map<String,Object> params=new HashMap<String, Object>();
        Integer pageSize=10;
        if(username.equals("")) {
            UserCriteria userCriteria=new UserCriteria();
            UserCriteria.Criteria criteria=userCriteria.createCriteria();
             userMapper.selectByExample(userCriteria);
           // return userMapper.selectAll(params, new PageBounds(page, pageSize));
        }else {
            params.put("username","%"+username+"%");
          //  return userMapper.selectAllByName(params, new PageBounds(page, pageSize));
        }
        return null;
    }

    public PageList<User> searchSize(String username, Integer page) {
        return null;
    }
}
