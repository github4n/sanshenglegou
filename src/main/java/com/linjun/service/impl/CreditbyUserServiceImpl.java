package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.CreditbyuserMapper;
import com.linjun.model.Creditbyuser;
import com.linjun.model.CreditbyuserCriteria;
import com.linjun.service.CreditByUserService;
import com.mysql.cj.jdbc.exceptions.PacketTooBigException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreditbyUserServiceImpl implements CreditByUserService{
    @Autowired
    CreditbyuserMapper creditbyuserMapper;
    @Override
    public Creditbyuser add(Creditbyuser creditbyuser) {
        long result=creditbyuserMapper.updateByPrimaryKeySelective(creditbyuser);
        if (result>0){
            return creditbyuserMapper.selectByPrimaryKey(result);
        }else {
           throw new PeopleException("添加失败");
        }
    }

    @Override
    public List<Creditbyuser> findbyuseri(long userid) {
        CreditbyuserCriteria creditbyuserCriteria=new CreditbyuserCriteria();
        CreditbyuserCriteria.Criteria criteria=creditbyuserCriteria.createCriteria();
        List<Creditbyuser> list=creditbyuserMapper.selectByExample(creditbyuserCriteria);
        if (list!=null&&list.size()>0){
            return list;
        }else {
            throw new PeopleException("数据为空");
        }

    }
}
