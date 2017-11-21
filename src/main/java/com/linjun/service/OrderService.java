package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.Order;

import java.util.List;

public interface OrderService {
    public boolean add(Order order);
    public  int deletebyuserid(long id,long goodsID);
    public List<Order> findByuserid(long id);
    public List<Order>  findAll();
    int update(long userid,long orderId,Order order);
    Order createOrder(Order order);
    List<Order> queryOrder(long storid);
    Order findByOrder(long id,long goodsID);
    Order findByID(long id);
    List<Integer> getTodayOrder(long storeid);
    int[] getWeekDayOrder(long storeid);
    PageBean<Order> findAllOrder(int cuurrentPage,int pagesize);
    long countOrder();
      Order updateOrder(Order order);
      Long todayOrder();
      Long toadayOrderPay();
      Float todayMoney();
      Long sumOrder();
      Float sumMoney();
      List<Float> weekMoney();
      List<Long> weekorderPlan();
      List<Float> monthMoney();


       List<Integer> monthOrder();
       Integer  monthday();
    PageBean<Order> findAllOStore(long storid,int cuurrentPage,int pagesize);
}
