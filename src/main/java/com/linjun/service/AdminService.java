package com.linjun.service;

import com.linjun.model.Admin;

import java.util.List;

public interface AdminService {
    public int updateAdmin(long id, Admin admin);
    public  boolean IsExits(String username,String passworld);

}
