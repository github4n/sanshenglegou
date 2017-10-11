package com.linjun.service.impl;

import com.linjun.dao.StoreMapper;
import com.linjun.model.Store;
import com.linjun.model.StoreCriteria;
import com.linjun.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreMapper storeMapper;
    public boolean add(Store store) {
        return storeMapper.insertSelective(store)>0;
    }

    public int deletebyid(long id) {
        return storeMapper.deleteByPrimaryKey(id);
    }

    public int updatebyid(long id, Store store) {
        StoreCriteria storeCriteria=new StoreCriteria();
        StoreCriteria.Criteria criteria=storeCriteria.createCriteria();
        criteria.andIdEqualTo(id);
        return storeMapper.updateByExampleSelective(store,storeCriteria);
    }

    public List<Store> findAll() {

        StoreCriteria storeCriteria=new StoreCriteria();
        StoreCriteria.Criteria criteria=storeCriteria.createCriteria();
        return storeMapper.selectByExample(storeCriteria);
    }
    public Store findByid(long id) {
        return storeMapper.selectByPrimaryKey(id);
    }
}
