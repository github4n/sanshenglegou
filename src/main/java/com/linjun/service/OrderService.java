package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.Order;

import java.util.List;

public interface OrderService {
    public Order add(Order order);
    public  int deletebyuserid(long id,long goodsID);
    public List<Order> findByuserid(long id);
    public List<Order>  findAll();
    Order update(Order order);
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
      Long todayOrderstoreid(Long storeid);
      Long toadayOrderPay();
      Long todayOrderPaystoreid(long storeid);
      Float todayMoney();
      Long sumOrder();
      Long sumOrderstoreid(long storeid);
      Float sumMoney();
      Float sumMoneystoreid(long storeid);
      List<Float> weekMoney();
      List<Float> weekMoneystoreid(long storeid);
      List<Long> weekorderPlan();
      List<Long> weekorderPlanstoreid(long storeid);
      List<Integer> monthorderPlan();
      List<Float> monthMoney();
        PageBean<Order> findBy(byte status,int currentpage,int pagesize);
       List<Integer> monthOrder();
       List<Integer> monthOrderstoreid(long storeid);
       Integer  monthday();
    PageBean<Order> findAllOStore(long storid,int cuurrentPage,int pagesize);
    PageBean<Order> search(Long condition,int currentpage,int pagesize);
    PageBean<Order> searchByStatus(Long condition,byte status,int currentpage,int pagesize);
    List<Order> getOrderStatus(Long userid,byte status);
}
