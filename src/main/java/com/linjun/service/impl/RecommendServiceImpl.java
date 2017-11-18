package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.RecommendMapper;
import com.linjun.model.Recommend;
import com.linjun.model.RecommendCriteria;
import com.linjun.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    RecommendMapper recommendMapper;
    public boolean add(Recommend recommend) {
        return recommendMapper.insertSelective(recommend)>0;
    }

    public int deleteByuserid(long userid) {
        RecommendCriteria recommendCriteria=new RecommendCriteria();
        RecommendCriteria.Criteria criteria=recommendCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);

        return recommendMapper.deleteByExample(recommendCriteria);
    }

    public List<Recommend> findByuserid(long userid) {

        RecommendCriteria recommendCriteria=new RecommendCriteria();
        RecommendCriteria.Criteria criteria=recommendCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        return recommendMapper.selectByExample(recommendCriteria);
    }

    @Override
    public Recommend createRecommend(Recommend recommend) {
        int result=recommendMapper.insertSelective(recommend);
        if (result>0){
            return recommend;
        }else {
            throw  new PeopleException("推荐失败，请重试");
        }
    }
}
