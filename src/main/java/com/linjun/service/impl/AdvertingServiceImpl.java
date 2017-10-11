package com.linjun.service.impl;

import com.linjun.dao.AdvertsingMapper;
import com.linjun.model.Advertsing;
import com.linjun.model.AdvertsingCriteria;
import com.linjun.service.AdvertingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertingServiceImpl implements AdvertingService {
    @Autowired
    AdvertsingMapper advertsingMapper;
    public int insert(Advertsing advertsing) {
        return advertsingMapper.insert(advertsing);
    }

    public int update(int id, Advertsing advertsing) {
        AdvertsingCriteria advertsingCriteria=new AdvertsingCriteria();
        AdvertsingCriteria.Criteria criteria=advertsingCriteria.createCriteria();
        criteria.andIdEqualTo((long) id);


        return advertsingMapper.updateByExample(advertsing,advertsingCriteria);
    }

    public int delete(int id) {
        return advertsingMapper.deleteByPrimaryKey((long) id);
    }
}
