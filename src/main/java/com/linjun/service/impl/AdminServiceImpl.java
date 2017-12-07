package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.AdminMapper;
import com.linjun.model.Admin;
import com.linjun.model.AdminCriteria;
import com.linjun.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    public int updateAdmin(long id, Admin admin) {
        AdminCriteria adminCriteria=new AdminCriteria();
        AdminCriteria.Criteria criteria=adminCriteria.createCriteria();
        criteria.andIdEqualTo(id);
        return adminMapper.updateByExample(admin,adminCriteria);
    }

    public boolean IsExits(String username,String passworld) {
        AdminCriteria adminCriteria =new AdminCriteria();
        AdminCriteria.Criteria criteria=adminCriteria.createCriteria();
        criteria.andAccountEqualTo(username);
        criteria.andPassworldEqualTo(passworld);
        if (adminMapper.selectByExample(adminCriteria)!=null){
            return true;
        }else {
            return  false;
        }
    }

    @Override
    public Admin login(Admin admin) {
       AdminCriteria adminCriteria=new AdminCriteria();
        AdminCriteria.Criteria criteria=adminCriteria.createCriteria();
        criteria.andAccountEqualTo(admin.getAccount());
        criteria.andPassworldEqualTo(admin.getPassworld());
        List<Admin> result=adminMapper.selectByExample(adminCriteria);
        if (result!=null&&result.size()>0){
            return result.get(0);
        }else {
         throw new PeopleException("密码错误");
        }

    }

    @Override
    public List<Admin> findid(long id) {
        AdminCriteria adminCriteria=new AdminCriteria();
        AdminCriteria.Criteria criteria=adminCriteria.createCriteria();
        criteria.andAccountEqualTo("admin");
        criteria.andPassworldEqualTo("admin");
        return adminMapper.selectByExample(adminCriteria);
    }
}
