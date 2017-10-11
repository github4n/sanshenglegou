package com.linjun.service.impl;

import com.linjun.dao.LogisticsMapper;
import com.linjun.model.Logistics;
import com.linjun.model.LogisticsCriteria;
import com.linjun.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogisticsServiceImpl implements LogisticsService {
    @Autowired
    LogisticsMapper logisticsMapper;
    public boolean add(Logistics logistics) {
        return logisticsMapper.insertSelective(logistics)>0;
    }

    public List<Logistics> findBy(long userid, long goods) {
        LogisticsCriteria logisticsCriteria=new LogisticsCriteria();
        LogisticsCriteria.Criteria criteria=logisticsCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andOrderidEqualTo(goods);
        return logisticsMapper.selectByExample(logisticsCriteria);
    }

    public int delete(long userid, long goods) {
        LogisticsCriteria logisticsCriteria=new LogisticsCriteria();
        LogisticsCriteria.Criteria criteria=logisticsCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andOrderidEqualTo(goods);
        return logisticsMapper.deleteByExample(logisticsCriteria);
    }
}
