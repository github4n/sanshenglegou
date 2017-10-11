package com.linjun.service.impl;

import com.linjun.dao.SignMapper;
import com.linjun.model.Sign;
import com.linjun.model.SignCriteria;
import com.linjun.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SignServiceImpl implements SignService {
    @Autowired
    SignMapper signMapper;
    public boolean add(Sign sign) {
        return signMapper.insertSelective(sign)>0;
    }

    public int deleteByuserid(long userid) {
        SignCriteria signCriteria=new SignCriteria();
        SignCriteria.Criteria criteria=signCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        return signMapper.deleteByExample(signCriteria);
    }

    public List<Sign> findByuserid(long userid) {

        SignCriteria signCriteria=new SignCriteria();
        SignCriteria.Criteria criteria=signCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        return signMapper.selectByExample(signCriteria);
    }
}
