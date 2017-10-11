package com.linjun.service.impl;

import com.linjun.dao.CollectMapper;
import com.linjun.model.Collect;
import com.linjun.model.CollectCriteria;
import com.linjun.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;

    public boolean add(Collect collect) {
        return collectMapper.insertSelective(collect)>0;
    }

    public int deleteByUserid(long userid) {
        CollectCriteria collectCriteria=new CollectCriteria();
        CollectCriteria.Criteria criteria=collectCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);

        return collectMapper.deleteByExample(collectCriteria);
    }

    public List<Collect> findByuserid(long userid) {
        CollectCriteria collectCriteria=new CollectCriteria();
        CollectCriteria.Criteria criteria=collectCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        return collectMapper.selectByExample(collectCriteria);
    }
}
