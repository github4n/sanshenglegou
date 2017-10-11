package com.linjun.service;

import com.linjun.model.AdvertsingPosing;

public interface AdversingPosingService {
    public  int insert(AdvertsingPosing advertsingPosing);
    public  int update(int id, AdvertsingPosing advertsingPosing);
    public  int  delete(int id);


}
