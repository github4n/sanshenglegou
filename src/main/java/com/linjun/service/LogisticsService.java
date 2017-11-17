package com.linjun.service;

import com.linjun.model.Logistics;

import java.util.List;

public interface LogisticsService {
    public  boolean add(Logistics logistics);
    public List<Logistics> findBy(long userid,long goods);
    public  int delete(long userid,long goodis);
    Logistics built(Logistics logistics);
}
