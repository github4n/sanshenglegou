package com.linjun.service;

import com.linjun.model.Order;

import java.util.List;

public interface OrderService {
    public boolean add(Order order);
    public  int deletebyuserid(long id,long goodsID);
    public List<Order> findByuserid(long id);
    public List<Order>  findAll();
    int update(long userid,long orderId,Order order);
}
