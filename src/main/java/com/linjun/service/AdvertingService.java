package com.linjun.service;

import com.linjun.model.Advertsing;

public interface AdvertingService {
    public  int insert(Advertsing advertsing);
    public  int update(int id, Advertsing advertsing);
    public  int delete(int id);
}
