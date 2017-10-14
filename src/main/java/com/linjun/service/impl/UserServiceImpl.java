package com.linjun.service.impl;

import com.linjun.common.domain.PageBounds;
import com.linjun.common.domain.PageList;
import com.linjun.common.domain.PeopleException;
import com.linjun.dao.UserMapper;
import com.linjun.model.User;
import com.linjun.model.UserCriteria;
import com.linjun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public User add(User user) {
        user.setLogin(new Date());
        int result=userMapper.insertSelective(user);
        if (result>0){
            return updateUser(user);
        }else {
            throw new PeopleException("添加失败");
        }
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

    public User loginByPhone(User user) {
        UserCriteria userCriteria=new UserCriteria();
        userCriteria.createCriteria().andTelEqualTo(user.getTel());
        List<User> userList=userMapper.selectByExample(userCriteria);
        if (userlist()!=null&&userList.size()==1){
            user=userList.get(0);
            user.setLogin(new Date());
           return updateUser(user);
        }else {
         throw  new PeopleException("用户未注册");
        }
    }

    public User loginByUsername(User user) {
        UserCriteria userCriteria=new UserCriteria();
        userCriteria.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> userList=userMapper.selectByExample(userCriteria);
        if (userlist()!=null&&userList.size()==1){
            user=userList.get(0);
            user.setLogin(new Date());
            return updateUser(user);
        }else {
            throw  new PeopleException("用户未注册");
        }
    }

    public User registerByPhone(User user) {
        UserCriteria userCriteria=new UserCriteria();
        userCriteria.createCriteria().andTelEqualTo(user.getTel());
        if (userMapper.selectByExample(userCriteria).size()>0){
            throw  new PeopleException("用户已经注册");
        }

        return add(user);
    }

    public User getUserByUserid(long userid) {
        return null;
    }

    public List<User> userlist() {
        List<>
        return null;
    }

    public User updateUser(User user) {
      int result=userMapper.updateByPrimaryKeySelective(user);
      if (result>0){
    return userMapper.selectByPrimaryKey(user.getId());
      }else {
          throw new PeopleException("用户更新失败");
      }

    }
}
