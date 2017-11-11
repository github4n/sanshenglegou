package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.domain.PeopleException;
import com.linjun.dao.OrderMapper;
import com.linjun.entity.PageBean;
import com.linjun.model.Order;
import com.linjun.model.OrderCriteria;
import com.linjun.model.Store;
import com.linjun.model.StoreCriteria;
import com.linjun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    public boolean add(Order order) {
        return orderMapper.insertSelective(order) > 0;
    }

    public int deletebyuserid(long id, long goodsID) {
        OrderCriteria orderCriteria = new OrderCriteria();
        OrderCriteria.Criteria criteria = orderCriteria.createCriteria();
        criteria.andGoodsidEqualTo(goodsID);
        criteria.andUseridEqualTo(id);

        return orderMapper.deleteByExample(orderCriteria);
    }

    public List<Order> findByuserid(long id) {
        OrderCriteria orderCriteria = new OrderCriteria();
        OrderCriteria.Criteria criteria = orderCriteria.createCriteria();
        criteria.andUseridEqualTo(id);
        return orderMapper.selectByExample(orderCriteria);
    }

    public List<Order> findAll() {
        OrderCriteria orderCriteria = new OrderCriteria();
        OrderCriteria.Criteria criteria = orderCriteria.createCriteria();
        return orderMapper.selectByExample(orderCriteria);
    }

    public int update(long userid, long orderId, Order order) {

        OrderCriteria orderCriteria = new OrderCriteria();
        OrderCriteria.Criteria criteria = orderCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andIdEqualTo(orderId);

        return orderMapper.updateByExample(order, orderCriteria);
    }

    @Override
    public Order createOrder(Order order) {
        int result = orderMapper.insertSelective(order);
        if (result > 0) {
            return orderMapper.selectByPrimaryKey((long) result);
        } else {
            throw new PeopleException("创建订单失败");
        }
    }

    @Override
    public List<Order> queryOrder(long storid) {
        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.createCriteria().andStoreidEqualTo(storid);
        List<Order> orderList = orderMapper.selectByExample(orderCriteria);
        return orderList;
    }

    @Override
    public Order findByOrder(long id, long goodsID) {
        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.createCriteria().andUseridEqualTo(id);
        orderCriteria.createCriteria().andGoodsidEqualTo(goodsID);
        List<Order> list = orderMapper.selectByExample(orderCriteria);
        if (list != null && list.size() == 1) {
            Order order = list.get(0);
            return order;
        } else {
            throw new PeopleException("查询指定订单失败");
        }
    }

    @Override
    public List<Integer> getTodayOrder(long storeid) {
        OrderCriteria orderCriteria = new OrderCriteria();
        orderCriteria.createCriteria().andStoreidEqualTo(storeid);
        orderCriteria.createCriteria().andSendtimeEqualTo(new Date());
        long tadayOrder = orderMapper.countByExample(orderCriteria);
        List<Integer> list = new ArrayList<Integer>();
        list.add((int) tadayOrder);
        OrderCriteria orderCriteria1 = new OrderCriteria();
        orderCriteria1.createCriteria().andStoreidEqualTo(storeid);
        orderCriteria1.createCriteria().andSendtimeEqualTo(new Date());
        orderCriteria1.createCriteria().andIspayEqualTo((byte) 1);
        long tadayOrderPay = orderMapper.countByExample(orderCriteria1);
        list.add((int) tadayOrderPay);
        return list;
    }

    private Date getpaost(int post) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - post);
        Date today = calendar.getTime();
        return today;
    }


    @Override
    public int[] getWeekDayOrder(long storeid) {
        int[] list = new int[7];
        Calendar rightNow = Calendar.getInstance();
        int day = rightNow.get(rightNow.DAY_OF_WEEK);//获取时间
        OrderCriteria orderCriteria = new OrderCriteria();
        if (day == 1) {
            for (int i = 7; i > 0; i--) {
                orderCriteria.createCriteria().andSendtimeBetween(getpaost(i), new Date());
                long result1 = orderMapper.countByExample(orderCriteria);
                int a = 7 - i;
                list[a] = (int) result1;
            }
        } else {
            for (int i = day - 1; i < 0; i--) {
                orderCriteria.createCriteria().andSendtimeBetween(getpaost(i), new Date());
                long result2 = orderMapper.countByExample(orderCriteria);
                int b = 1;
                b++;
                list[b] = (int) result2;
            }
        }
        return list;
    }

    @Override
    public PageBean<Order> findAllOrder(int cuurrentPage, int pagesize) {
        PageHelper.startPage(cuurrentPage,pagesize);
        OrderCriteria storeCriteria=new OrderCriteria();
        List<Order> list=orderMapper.selectByExample(storeCriteria);
        long total=countOrder();
        int pages,sise;
        if (total%cuurrentPage==0){
            pages= (int) (total/cuurrentPage);
        }else {
            pages= (int) (total/cuurrentPage)+1;
        }
        if (pages*pagesize==total){
            sise=cuurrentPage*pagesize;
        }else {
            if (cuurrentPage<pages){
                sise=cuurrentPage*pagesize;
            }else {
                sise= (int) total;
            }
        }
        PageBean<Order> lists=new PageBean<Order>(total,cuurrentPage,pagesize,pages,sise,list);
        return lists; }

    @Override
    public long countOrder() {
        OrderCriteria orderCriteria=new OrderCriteria();
        return orderMapper.countByExample(orderCriteria);
    }

    @Override
    public Order updateOrder( Order order) {
        int result= orderMapper.updateByPrimaryKeySelective(order);
        if (result>0){
            return orderMapper.selectByPrimaryKey(order.getId());
        }else {
            throw new PeopleException("更新失败");
        }
    }


    @Override
    public PageBean<Order> findAllOStore(long storid, int cuurrentPage, int pagesize) {
        PageHelper.startPage(cuurrentPage,pagesize);
        OrderCriteria storeCriteria=new OrderCriteria();
        storeCriteria.createCriteria().andStoreidEqualTo(storid);
        List<Order> list=orderMapper.selectByExample(storeCriteria);
        long total=countOrder();
        int pages,sise;
        if (total%cuurrentPage==0){
            pages= (int) (total/cuurrentPage);
        }else {
            pages= (int) (total/cuurrentPage)+1;
        }
        if (pages*pagesize==total){
            sise=cuurrentPage*pagesize;
        }else {
            if (cuurrentPage<pages){
                sise=cuurrentPage*pagesize;
            }else {
                sise= (int) total;
            }
        }
        PageBean<Order> lists=new PageBean<Order>(total,cuurrentPage,pagesize,pages,sise,list);
        return lists; }
    }

