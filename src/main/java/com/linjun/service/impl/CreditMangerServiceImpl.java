package com.linjun.service.impl;

import com.linjun.dao.CreditMangerMapper;
import com.linjun.model.CreditManger;
import com.linjun.model.CreditMangerCriteria;
import com.linjun.service.CreditMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditMangerServiceImpl implements CreditMangerService {
    @Autowired
    CreditMangerMapper creditMangerMapper;

    public boolean add(CreditManger creditManger) {
        return creditMangerMapper.insertSelective(creditManger)>0;
    }

    public int updateByuserid(long userid, CreditManger creditManger) {
        CreditMangerCriteria creditMangerCriteria=new CreditMangerCriteria();
        CreditMangerCriteria.Criteria criteria=creditMangerCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);

        return creditMangerMapper.updateByExampleSelective(creditManger,creditMangerCriteria);
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
        return (CreditManger) creditMangerMapper.selectByExample(creditMangerCriteria);
    }
}
