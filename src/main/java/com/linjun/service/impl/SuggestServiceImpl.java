package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.SuggestMapper;
import com.linjun.model.Suggest;
import com.linjun.service.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuggestServiceImpl implements SuggestService {
    @Autowired
    SuggestMapper suggestMapper;
    @Override
    public Suggest add(Suggest suggest) {
        long result=suggestMapper.insertSelective(suggest);
        if (result>0){
            return  suggestMapper.selectByPrimaryKey(result);
        }else {
            throw  new PeopleException("添加失败");
        }
    }
}
