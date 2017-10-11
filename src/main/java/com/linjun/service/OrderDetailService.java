package com.linjun.service;

import com.linjun.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    public boolean add(OrderDetail orderDetail);
    public  int deletebyid(long orderid);
    public  int updateByid(long orderid,OrderDetail orderDetail);
    public List<OrderDetail> findByid(long orderid);
}
