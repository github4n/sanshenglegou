package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.CreditMangerMapper;
import com.linjun.model.CreditManger;
import com.linjun.model.CreditMangerCriteria;
import com.linjun.service.CreditMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditMangerServiceImpl implements CreditMangerService {
    @Autowired
    CreditMangerMapper creditMangerMapper;

    public boolean add(CreditManger creditManger) {
        return creditMangerMapper.insertSelective(creditManger)>0;
    }

    public CreditManger updateByuserid(CreditManger creditManger) {
       int result=creditMangerMapper.updateByPrimaryKeySelective(creditManger);
        if (result>0){
            return creditMangerMapper.selectByPrimaryKey(creditManger.getId());
        }else {
            throw  new PeopleException("失败");
        }
    }

    public int deleteByuserid(long userid) {

        CreditMangerCriteria creditMangerCriteria=new CreditMangerCriteria();
        CreditMangerCriteria.Criteria criteria=creditMangerCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        return creditMangerMapper.deleteByExample(creditMangerCriteria);
    }

    public CreditManger findByuserid(long userid) {
        CreditMangerCriteria creditMangerCriteria=new CreditMangerCriteria();
        CreditMangerCriteria.Criteria criteria=creditMangerCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<CreditManger> list=creditMangerMapper.selectByExample(creditMangerCriteria);
        if (list!=null&&list.size()>0){
            return  list.get(0);
        }else {
            throw new PeopleException("查询失败");
        }
    }

    @Override
    public boolean isexit(long id) {

        CreditManger list=creditMangerMapper.selectByPrimaryKey(id);
        if (list!=null){
            return true;
        }else {
            return false;
        }


    }
}
