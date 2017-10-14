package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.OrderMapper;
import com.linjun.model.Order;
import com.linjun.model.OrderCriteria;
import com.linjun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    public boolean add(Order order) {
        return orderMapper.insertSelective(order)>0;
    }

    public int deletebyuserid(long id, long goodsID) {
        OrderCriteria orderCriteria=new OrderCriteria();
        OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
        criteria.andGoodsidEqualTo(goodsID);
        criteria.andUseridEqualTo(id);

        return orderMapper.deleteByExample(orderCriteria);
    }

    public List<Order> findByuserid(long id) {
        OrderCriteria orderCriteria=new OrderCriteria();
        OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
        criteria.andUseridEqualTo(id);
        return orderMapper.selectByExample(orderCriteria);
    }

    public List<Order> findAll() {
        OrderCriteria orderCriteria=new OrderCriteria();
        OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
        return orderMapper.selectByExample(orderCriteria);
    }

    public int update(long userid, long orderId, Order order) {

        OrderCriteria orderCriteria=new OrderCriteria();
        OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andIdEqualTo(orderId);

        return orderMapper.updateByExample(order,orderCriteria);
    }

    @Override
    public Order createOrder(Order order) {
        int result=orderMapper.insertSelective(order);
        if (result>0){

            return order;
        }else {
            throw new PeopleException("创建订单失败");
        }
    }

    @Override
    public List<Order> queryOrder(long storid) {
        OrderCriteria orderCriteria=new OrderCriteria();
        orderCriteria.createCriteria().andStoreidEqualTo(storid);
        List<Order> orderList=orderMapper.selectByExample(orderCriteria);
        return orderList;
    }
}
