package com.linjun.service.impl;

import com.linjun.dao.OfflineMapper;
import com.linjun.model.Offline;
import com.linjun.model.OfflineCriteria;
import com.linjun.service.OffLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OffLineServiceImpl implements OffLineService {
    @Autowired
    OfflineMapper offlineMapper;
    public boolean add(Offline offline) {
        return offlineMapper.insertSelective(offline)>0;
    }

    public int deleteByuserid(long userid) {
        OfflineCriteria criteria=new OfflineCriteria();
        OfflineCriteria.Criteria criteria1=criteria.createCriteria();
        criteria1.andUseridEqualTo(userid);
        return offlineMapper.deleteByExample(criteria);
    }
    public List<Offline> findByuserid(long userid) {
        OfflineCriteria criteria=new OfflineCriteria();
        OfflineCriteria.Criteria criteria1=criteria.createCriteria();
        criteria1.andUseridEqualTo(userid);
        return offlineMapper.selectByExample(criteria);
    }
}
