package com.linjun.service;

import com.linjun.model.UserDetail;

public interface UserDetailService {
    public boolean add(UserDetail userDetail);
    public  int updateByUserID(long userid,UserDetail userDetail);
    public  int deleteByuserID(long userid);
}
