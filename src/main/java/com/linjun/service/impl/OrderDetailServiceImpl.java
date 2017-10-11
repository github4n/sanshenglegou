package com.linjun.service.impl;

import com.linjun.dao.OrderDetailMapper;
import com.linjun.model.OrderDetail;
import com.linjun.model.OrderDetailCriteria;
import com.linjun.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailMapper orderDetailMapper;
    public boolean add(OrderDetail orderDetail) {
        return orderDetailMapper.insertSelective(orderDetail)>0;
    }

    public int deletebyid(long orderid) {
        OrderDetailCriteria orderDetailCriteria=new OrderDetailCriteria();
        OrderDetailCriteria.Criteria criteria=orderDetailCriteria.createCriteria();
        criteria.andOrderidEqualTo(orderid);

        return orderDetailMapper.deleteByExample(orderDetailCriteria);
    }

    public int updateByid(long orderid, OrderDetail orderDetail) {
        OrderDetailCriteria orderDetailCriteria=new OrderDetailCriteria();
        OrderDetailCriteria.Criteria criteria=orderDetailCriteria.createCriteria();
        criteria.andOrderidEqualTo(orderid);
        return orderDetailMapper.updateByExampleSelective(orderDetail,orderDetailCriteria);
    }

    public List<OrderDetail> findByid(long orderid) {
        OrderDetailCriteria orderDetailCriteria=new OrderDetailCriteria();
        OrderDetailCriteria.Criteria criteria=orderDetailCriteria.createCriteria();
        criteria.andOrderidEqualTo(orderid);
        return orderDetailMapper.selectByExample(orderDetailCriteria);
    }
}
