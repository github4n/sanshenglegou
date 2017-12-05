package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.CreditDetailMapper;
import com.linjun.model.CreditDetail;
import com.linjun.model.CreditDetailCriteria;
import com.linjun.service.CreditDetialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreditDetailServiceImpl implements CreditDetialService {
    @Autowired
    CreditDetailMapper creditDetailMapper;
    public boolean add(CreditDetail creditDetial) {
        return creditDetailMapper.insertSelective(creditDetial)>0;
    }
    public CreditDetail update( CreditDetail creditDetial) {
        int result=creditDetailMapper.updateByPrimaryKeySelective(creditDetial);
        if (result>0){
            return creditDetailMapper.selectByPrimaryKey(creditDetial.getId());
        }else {
            throw new PeopleException("更新失败");
        }
    }

    public int deletebyid(long creditid) {

        CreditDetailCriteria creditDetailCriteria=new CreditDetailCriteria();
        CreditDetailCriteria.Criteria criteria=creditDetailCriteria.createCriteria();
        criteria.andUseridEqualTo(creditid);
        return creditDetailMapper.deleteByExample(creditDetailCriteria);
    }

    public List<CreditDetail> findbyuserid(long userid) {

        CreditDetailCriteria creditDetailCriteria=new CreditDetailCriteria();
        CreditDetailCriteria.Criteria criteria=creditDetailCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<CreditDetail>list= creditDetailMapper.selectByExample(creditDetailCriteria);
        if (list!=null&&list.size()>0){
            return list;
        }else {
            throw new PeopleException("获取积分失败");
        }
    }
}
