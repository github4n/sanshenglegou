package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.OrderDetailMapper;
import com.linjun.model.Order;
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
    public OrderDetail add(OrderDetail orderDetail) {
        int result=orderDetailMapper.insertSelective(orderDetail);
        if (result>0){
            return orderDetailMapper.selectByPrimaryKey((long) result);
        }else {
            throw new PeopleException("添加失败");
        }
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

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        int result=orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
        if (result>0){
            OrderDetail orderDetail1=orderDetailMapper.selectByPrimaryKey(orderDetail.getId());
            return orderDetail1;

        }else {
            throw new PeopleException("更新物流失败");
        }
    }
}
