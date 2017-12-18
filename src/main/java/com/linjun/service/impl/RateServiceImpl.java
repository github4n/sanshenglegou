package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.RateMapper;
import com.linjun.model.Rate;
import com.linjun.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl  implements RateService {
    @Autowired
    RateMapper rateMapper;
    @Override
    public Float find(int id) {
        Rate rate=rateMapper.selectByPrimaryKey((long) id);
        return rate.getRate();
    }

    @Override
    public Float updata(Rate rate) {
        int result=rateMapper.updateByPrimaryKeySelective(rate);
        if (result>0){
            Rate rate1=rateMapper.selectByPrimaryKey(rate.getId());
            return rate1.getRate();
        }else {
            throw  new PeopleException("失败");
        }
    }
}
