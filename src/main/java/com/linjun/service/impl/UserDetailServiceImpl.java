package com.linjun.service.impl;

import com.linjun.dao.UserDetailMapper;
import com.linjun.model.UserDetail;
import com.linjun.model.UserDetailCriteria;
import com.linjun.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService{
    @Autowired
    UserDetailMapper userDetailMapper;

    public boolean add(UserDetail userDetail) {

        return userDetailMapper.insertSelective(userDetail)>0;
    }

    public int updateByUserID(long userid, UserDetail userDetail) {
        UserDetailCriteria userDetailCriteria=new UserDetailCriteria();
        UserDetailCriteria.Criteria criteria=userDetailCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        return userDetailMapper.updateByExampleSelective(userDetail,userDetailCriteria);
    }

    public int deleteByuserID(long userid) {
        UserDetailCriteria userDetailCriteria=new UserDetailCriteria();
        UserDetailCriteria.Criteria criteria=userDetailCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        return userDetailMapper.deleteByExample(userDetailCriteria);
    }
}
