package com.linjun.service;

import com.linjun.model.SiglnDetail;

import java.util.List;

public interface SiglnDetailService {
    public  boolean add(SiglnDetail siglnDetail);
    public  int deleteByuserid(long userid);
    public List<SiglnDetail> findByuserid(long userid);
    public  int updateByuserid(long userid,SiglnDetail siglnDetail);
}
