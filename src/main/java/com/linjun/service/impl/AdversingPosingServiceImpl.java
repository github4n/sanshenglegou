package com.linjun.service.impl;

import com.linjun.dao.AdvertsingPosingMapper;
import com.linjun.model.AdvertsingPosing;
import com.linjun.model.AdvertsingPosingCriteria;
import com.linjun.service.AdversingPosingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdversingPosingServiceImpl implements AdversingPosingService {
    @Autowired
    AdvertsingPosingMapper advertsingPosingMapper;

    public int insert(AdvertsingPosing advertsingPosing) {
        return advertsingPosingMapper.insert(advertsingPosing);
    }

    public int update(int id, AdvertsingPosing advertsingPosing) {
        AdvertsingPosingCriteria advertsingPosingCriteria=new AdvertsingPosingCriteria();
        AdvertsingPosingCriteria.Criteria criteria=advertsingPosingCriteria.createCriteria();
        criteria.andIdEqualTo((long) id);
        return  advertsingPosingMapper.updateByExample(advertsingPosing,advertsingPosingCriteria);
    }
    public int delete(int id) {
        return advertsingPosingMapper.deleteByPrimaryKey((long) id);
    }
}
