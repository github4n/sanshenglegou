package com.linjun.service.impl;

import com.linjun.dao.AdminMapper;
import com.linjun.model.Admin;
import com.linjun.model.AdminCriteria;
import com.linjun.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public int updateAdmin(long id, Admin admin) {
        AdminCriteria adminCriteria=new AdminCriteria();
        AdminCriteria.Criteria criteria=adminCriteria.createCriteria();
        criteria.andIdEqualTo(id);
        return adminMapper.updateByExample(admin,adminCriteria);
    }

    public boolean IsExits(String username) {
        AdminCriteria adminCriteria =new AdminCriteria();
        AdminCriteria.Criteria criteria=adminCriteria.createCriteria();
        criteria.andAccountEqualTo(username);
        if (adminMapper.selectByExample(adminCriteria)!=null){
            return true;
        }else {
            return  false;
        }
    }
}
