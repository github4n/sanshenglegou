package com.linjun.service.impl;

import com.linjun.dao.SiglnDetailMapper;
import com.linjun.model.SiglnDetail;
import com.linjun.model.SiglnDetailCriteria;
import com.linjun.service.SiglnDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiglnDetailServiceImpl implements SiglnDetailService {
    @Autowired
    SiglnDetailMapper siglnDetailMapper;

    public boolean add(SiglnDetail siglnDetail) {
        return siglnDetailMapper.insertSelective(siglnDetail)>0;
    }

    public int deleteByuserid(long userid) {
        SiglnDetailCriteria siglnDetailCriteria=new SiglnDetailCriteria();
        SiglnDetailCriteria.Criteria criteria=siglnDetailCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);

        return siglnDetailMapper.deleteByExample(siglnDetailCriteria);
    }

    public List<SiglnDetail> findByuserid(long userid) {
        SiglnDetailCriteria siglnDetailCriteria=new SiglnDetailCriteria();
        SiglnDetailCriteria.Criteria criteria=siglnDetailCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        return siglnDetailMapper.selectByExample(siglnDetailCriteria);
    }

    public int updateByuserid(long userid,SiglnDetail siglnDetail) {
        SiglnDetailCriteria siglnDetailCriteria=new SiglnDetailCriteria();
        SiglnDetailCriteria.Criteria criteria=siglnDetailCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        return siglnDetailMapper.updateByExampleSelective(siglnDetail,siglnDetailCriteria);
    }
}
