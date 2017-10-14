package com.linjun.service;

import com.linjun.model.Recommend;

import java.util.List;

public interface RecommendService {
    public  boolean add(Recommend recommend);
    public  int  deleteByuserid(long userid);
    public List<Recommend> findByuserid(long userid);
    Recommend createRecommend(Recommend recommend);
}
