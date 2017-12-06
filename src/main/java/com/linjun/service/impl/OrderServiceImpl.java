package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.domain.PeopleException;
import com.linjun.dao.OrderMapper;
import com.linjun.dao.UserMapper;
import com.linjun.entity.PageBean;
import com.linjun.model.Order;
import com.linjun.model.OrderCriteria;
import com.linjun.model.UserCriteria;
import com.linjun.service.OrderService;
import io.swagger.models.auth.In;
import netscape.javascript.JSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.LongHashMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;

    public Order add(Order order) {
        long result=orderMapper.insertSelective(order);
        if (result>0){
            return orderMapper.selectByPrimaryKey(result);
        }else {
            throw new PeopleException("添加失败");
        }
    }

    public int deletebyuserid(long id, long goodsID) {
        OrderCriteria orderCriteria = new OrderCriteria();
        OrderCriteria.Criteria criteria = orderCriteria.createCriteria();
        criteria.andGoodsidEqualTo(goodsID);
        criteria.andUseridEqualTo(id);
       int result=orderMapper.deleteByExample(orderCriteria);
       if (result>0){
           return result;
       }else {
           throw new PeopleException("删除失败");
       }
    }

    public List<Order> findByuserid(long id) {
        OrderCriteria orderCriteria = new OrderCriteria();
        OrderCriteria.Criteria criteria = orderCriteria.createCriteria();
        criteria.andUseridEqualTo(id);
        List<Order> list=orderMapper.selectByExample(orderCriteria);
        if (list.size()>0&&list!=null){
            return list;
        }else {
            throw new PeopleException("获取数据失败");
        }
    }

    public List<Order> findAll() {
        OrderCriteria orderCriteria = new OrderCriteria();
        OrderCriteria.Criteria criteria = orderCriteria.createCriteria();
        return orderMapper.selectByExample(orderCriteria);
    }

    public Order update(Order order) {
      int result=orderMapper.updateByPrimaryKeySelective(order);
      if (result>0){
          return orderMapper.selectByPrimaryKey(order.getId());
      }else {
          throw new PeopleException("更新失败");
      }


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
        OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
        criteria.andUseridEqualTo(id);
        criteria.andGoodsidEqualTo(goodsID);
        List<Order> list = orderMapper.selectByExample(orderCriteria);
        if (list != null && list.size() == 1) {
            Order order = list.get(0);
            return order;
        } else {
            throw new PeopleException("查询指定订单失败");
        }
    }

    @Override
    public Order findByID(long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Integer> getTodayOrder(long storeid) {
        OrderCriteria orderCriteria = new OrderCriteria();
        OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
        criteria.andStoreidEqualTo(storeid);
        criteria.andSendtimeEqualTo(new Date());
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



    @Override
    public int[] getWeekDayOrder(long storeid) {
        int[] list = new int[7];
        Calendar rightNow = Calendar.getInstance();
        int day = rightNow.get(rightNow.DAY_OF_WEEK);//获取时间
        OrderCriteria orderCriteria = new OrderCriteria();
        if (day == 1) {
            for (int i = 7; i > 0; i--) {
                orderCriteria.createCriteria().andSendtimeBetween(getpost(i), new Date());
                long result1 = orderMapper.countByExample(orderCriteria);
                int a = 7 - i;
                list[a] = (int) result1;
            }
        } else {
            for (int i = day - 1; i < 0; i--) {
                orderCriteria.createCriteria().andSendtimeBetween(getpost(i), new Date());
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
        if (list!=null&&list.size()>0){
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
            return lists;
        }else {
            throw new PeopleException("获取数据失败");
        }
         }

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
    public Long todayOrder() {
       String a=String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat sdf3= new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String b=null;
        String c=null;
        Date date1=null;
        Date date2=null;
        try {
            b=sdf2.format(sdf1.parse(a));
            c=sdf3.format(sdf1.parse(a));
            date1=sdf2.parse(b);
            date2=sdf3.parse(c);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        OrderCriteria orderCriteria=new OrderCriteria();
        OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
        criteria.andPaytimeBetween(date1,date2);
        return orderMapper.countByExample(orderCriteria);
    }

    @Override
    public Long toadayOrderPay() {

        String a=String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat sdf3= new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String b=null;
        String c=null;
        Date date1=null;
        Date date2=null;
        try {
            b=sdf2.format(sdf1.parse(a));
            c=sdf3.format(sdf1.parse(a));
            date1=sdf2.parse(b);
            date2=sdf3.parse(c);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        OrderCriteria orderCriteria=new OrderCriteria();
        OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
        criteria.andPaytimeBetween(date1,date2);
        criteria.andIspayEqualTo((byte) 1);
        return orderMapper.countByExample(orderCriteria);
    }

    @Override
    public Float todayMoney() {
        String a=String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat sdf3= new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String b=null;
        String c=null;
        Date date1=null;
        Date date2=null;
        try {
            b=sdf2.format(sdf1.parse(a));
            c=sdf3.format(sdf1.parse(a));
            date1=sdf2.parse(b);
            date2=sdf3.parse(c);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        OrderCriteria orderCriteria=new OrderCriteria();
        OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
        criteria.andPaytimeBetween(date1,date2);
        criteria.andIspayEqualTo((byte) 1);
        long acount=orderMapper.countByExample(orderCriteria);
        Float Todaymoney = null;
        List<Order> list=orderMapper.selectByExample(orderCriteria);
        for (int i = 0; i <acount ; i++) {
            if (userMapper.selectByPrimaryKey(list.get(i).getUserid()).getRole()==1){
                Todaymoney+=list.get(i).getMemberprice();
            }else {
                Todaymoney+=list.get(i).getMarketpricce();
            }
        }
        return  Todaymoney;
    }
    @Override
    public Long sumOrder() {
        OrderCriteria orderCriteria=new OrderCriteria();
        OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
        criteria.andIspayEqualTo((byte) 1);
        return orderMapper.countByExample(orderCriteria);
    }
    @Override
    public Float sumMoney() {
        OrderCriteria orderCriteria=new OrderCriteria();
        OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
        criteria.andIspayEqualTo((byte) 1);
      List<Order> list=orderMapper.selectByExample(orderCriteria);
      long sum=orderMapper.countByExample(orderCriteria);
      Float sumMoney=null;
        for (int i = 0; i < sum; i++) {
            if (userMapper.selectByPrimaryKey(list.get(i).getUserid()).getRole()==1){
                sumMoney+=list.get(i).getMemberprice();
            }else {
                sumMoney+=list.get(i).getMarketpricce();
            }
        }
        return sumMoney;
    }
    private Date getpost(int post) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - post);
        Date today = calendar.getTime();
        String a=String.valueOf(today);
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String b=null;
        Date todays=null;
        try {
            b=sdf2.format(sdf1.parse(a));
            todays=sdf2.parse(b);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return todays;
    }


    @Override
    public List<Float> weekMoney() {
         List<Float> list=new ArrayList<Float>();
         Calendar rightNow=Calendar.getInstance();
        int day = rightNow.get(rightNow.DAY_OF_WEEK);//获取时间
        String a= String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String b= null;
        Date date=null;
        try {
            b = sdf2.format(sdf1.parse(a));
            date=sdf2.parse(b);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (day==1){
            for (int i=7;i>0;i--){
                OrderCriteria orderCriteria=new OrderCriteria();
                OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
                criteria.andPaytimeBetween(getpost(i),getpost(i-1));
                criteria.andIspayEqualTo((byte) 1);
                List<Order> list1=orderMapper.selectByExample(orderCriteria);
                Float dayMoney=null;
                for (int j = 0; j <list1.size() ; j++) {
                    dayMoney+=list1.get(j).getPricesum();
                }
                list.add(dayMoney);

            }
        }else {
            for (int i = day-1; i < 0; i++) {

                OrderCriteria orderCriteria=new OrderCriteria();
                OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
                criteria.andPaytimeBetween(getpost(i-1),getpost(i-2));
                criteria.andIspayEqualTo((byte) 1);
                List<Order> list1=orderMapper.selectByExample(orderCriteria);
                Float dayMoney=null;
                for (int j = 0; j <list1.size() ; j++) {
                    dayMoney+=list1.get(j).getPricesum();
                }
                list.add(dayMoney);

            }
            }
        return  list;

    }

    @Override
    public List<Long> weekorderPlan() {
       List<Long> list=new ArrayList<Long>();
        Calendar rightNow=Calendar.getInstance();
        int day = rightNow.get(rightNow.DAY_OF_WEEK);//获取日期是周几；
        String a= String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String b= null;
        Date date=null;
        try {
            b = sdf2.format(sdf1.parse(a));
            date=sdf2.parse(b);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long notpay = 0;
        long pay=0;
        long sendGoods=0;
        long cancel=0;
        long complete=0;
        if (day==1){
            for (int i = 7; i >0 ; i--) {
//                统计未支付的订单；
                OrderCriteria orderCriteria =new OrderCriteria();
                OrderCriteria.Criteria criteria= orderCriteria.createCriteria();
                criteria.andIspayEqualTo((byte) 0);
                 criteria.andPaytimeBetween(getpost(i),getpost(i-1));
                 notpay+=orderMapper.countByExample(orderCriteria);
                OrderCriteria orderCriteria1 =new OrderCriteria();
                OrderCriteria.Criteria criteria1= orderCriteria.createCriteria();
                criteria.andIspayEqualTo((byte) 1);
                criteria.andPaytimeBetween(getpost(i),getpost(i-1));
                pay+=orderMapper.countByExample(orderCriteria);
                OrderCriteria orderCriteria2 =new OrderCriteria();
                OrderCriteria.Criteria criteria2= orderCriteria.createCriteria();
                criteria.andIspayEqualTo((byte) 2);
                criteria.andPaytimeBetween(getpost(i),getpost(i-1));
                sendGoods+=orderMapper.countByExample(orderCriteria);
                OrderCriteria orderCriteria3 =new OrderCriteria();
                OrderCriteria.Criteria criteria3= orderCriteria.createCriteria();
                criteria.andIspayEqualTo((byte) 3);
                criteria.andPaytimeBetween(getpost(i),getpost(i-1));
                cancel+=orderMapper.countByExample(orderCriteria);
                OrderCriteria orderCriteria4 =new OrderCriteria();
                OrderCriteria.Criteria criteria4= orderCriteria.createCriteria();
                criteria.andIspayEqualTo((byte) 0);
                criteria.andPaytimeBetween(getpost(i),getpost(i-1));
                complete+=orderMapper.countByExample(orderCriteria);

            }


        }else {
            for (int i = day-1; i < 0; i++) {
                OrderCriteria orderCriteria =new OrderCriteria();
                OrderCriteria.Criteria criteria= orderCriteria.createCriteria();
                criteria.andIspayEqualTo((byte) 0);
                criteria.andPaytimeBetween(getpost(i),getpost(i-1));
                notpay+=orderMapper.countByExample(orderCriteria);
                OrderCriteria orderCriteria1 =new OrderCriteria();
                OrderCriteria.Criteria criteria1= orderCriteria.createCriteria();
                criteria.andIspayEqualTo((byte) 1);
                criteria.andPaytimeBetween(getpost(i),getpost(i-1));
                pay+=orderMapper.countByExample(orderCriteria);
                OrderCriteria orderCriteria2 =new OrderCriteria();
                OrderCriteria.Criteria criteria2= orderCriteria.createCriteria();
                criteria.andIspayEqualTo((byte) 2);
                criteria.andPaytimeBetween(getpost(i),getpost(i-1));
                sendGoods+=orderMapper.countByExample(orderCriteria);
                OrderCriteria orderCriteria3 =new OrderCriteria();
                OrderCriteria.Criteria criteria3= orderCriteria.createCriteria();
                criteria.andIspayEqualTo((byte) 3);
                criteria.andPaytimeBetween(getpost(i),getpost(i-1));
                cancel+=orderMapper.countByExample(orderCriteria);
                OrderCriteria orderCriteria4 =new OrderCriteria();
                OrderCriteria.Criteria criteria4= orderCriteria.createCriteria();
                criteria.andIspayEqualTo((byte) 0);
                criteria.andPaytimeBetween(getpost(i),getpost(i-1));
                complete+=orderMapper.countByExample(orderCriteria);

            }
        }
        list.add(notpay);
        list.add(pay);
        list.add(sendGoods);
        list.add(cancel);
        list.add(complete);
        return list;
    }

    @Override
    public List<Integer> monthorderPlan() {
        List<Integer> list=new ArrayList<Integer>();
        String currentTime=String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String b= null;
        Date date=null;
        Date date1=null;
        Date date2=null;
        Date v=null;
        try {
            Date d=sdf1.parse(currentTime);
            b = sdf2.format(d);
            v=d;
            System.out.println(v);
            date=sdf2.parse(b);
            System.out.println(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        Calendar c=Calendar.getInstance();
        c.set(Calendar.DATE,1);
        c.roll(Calendar.DATE,-1);
        int months=c.get(Calendar.DATE);

        for (int i = 1; i <months+1 ; i++) {

            SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-"+i+" 00:00:00");
            SimpleDateFormat sdf4=new SimpleDateFormat("yyyy-MM-"+i+" 23:59:59");
            try {
                b=sdf3.format(v);
                date1=sdf2.parse(b);
                String ds=sdf4.format(v);
                date2=sdf2.parse(ds);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Integer notpay;
            Integer pay;
            Integer sendGoods;
            Integer cancel;
            Integer complete;
            OrderCriteria orderCriteria=new OrderCriteria();
            OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
            criteria.andPaytimeBetween(date1,date2);
            criteria.andIspayEqualTo((byte) 0);
            List<Order> list1=orderMapper.selectByExample(orderCriteria);
            notpay=list1.size();
            OrderCriteria orderCriteria1=new OrderCriteria();
            OrderCriteria.Criteria criteria1=orderCriteria.createCriteria();
            criteria.andPaytimeBetween(date1,date2);
            criteria.andIspayEqualTo((byte) 1);
            List<Order> list2=orderMapper.selectByExample(orderCriteria);
            pay=list2.size();
            OrderCriteria orderCriteria2=new OrderCriteria();
            OrderCriteria.Criteria criteria2=orderCriteria.createCriteria();
            criteria.andPaytimeBetween(date1,date2);
            criteria.andIspayEqualTo((byte) 2);
            List<Order> list3=orderMapper.selectByExample(orderCriteria);
            sendGoods=list3.size();
            OrderCriteria orderCriteria3=new OrderCriteria();
            OrderCriteria.Criteria criteria3=orderCriteria.createCriteria();
            criteria.andPaytimeBetween(date1,date2);
            criteria.andIspayEqualTo((byte) 3);
            List<Order> list4=orderMapper.selectByExample(orderCriteria);
            cancel=list4.size();
            OrderCriteria orderCriteria4=new OrderCriteria();
            OrderCriteria.Criteria criteria4=orderCriteria.createCriteria();
            criteria.andPaytimeBetween(date1,date2);
            criteria.andIspayEqualTo((byte) 4);
            List<Order> list5=orderMapper.selectByExample(orderCriteria);
            complete=list5.size();
            list.add(notpay);
            list.add(pay);
            list.add(sendGoods);
            list.add(cancel);
            list.add(complete);

        }
        return list;
    }

    @Override
    public List<Float> monthMoney() {
        List<Float> list=new ArrayList<Float>();
        String currentTime=String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String b= null;
        Date date=null;
        Date date1=null;
        Date date2=null;
        Date v=null;
        try {
            Date d=sdf1.parse(currentTime);
            b = sdf2.format(d);
            v=d;
            System.out.println(v);
            date=sdf2.parse(b);
            System.out.println(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        Calendar c=Calendar.getInstance();
        c.set(Calendar.DATE,1);
        c.roll(Calendar.DATE,-1);
        int months=c.get(Calendar.DATE);

        for (int i = 1; i <months+1 ; i++) {

            SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-"+i+" 00:00:00");
            SimpleDateFormat sdf4=new SimpleDateFormat("yyyy-MM-"+i+" 23:59:59");
            try {
                b=sdf3.format(v);
                date1=sdf2.parse(b);
                String ds=sdf4.format(v);
                date2=sdf2.parse(ds);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            OrderCriteria orderCriteria=new OrderCriteria();
            OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
            criteria.andPaytimeBetween(date1,date2);
            criteria.andIspayNotEqualTo((byte) 0);
            criteria.andIspayNotEqualTo((byte) 4);
            List<Order> list1=orderMapper.selectByExample(orderCriteria);
            Float sumMoney=null;
            for (int j = 0; j <list1.size() ; j++) {
                sumMoney+=list1.get(j).getPricesum();
            }
             list.add(sumMoney);
        }
        return list;

    }

    @Override
    public PageBean<Order> findBy(byte status, int cuurrentPage, int pagesize) {
        PageHelper.startPage(cuurrentPage,pagesize);
        OrderCriteria storeCriteria=new OrderCriteria();
        List<Order> list=orderMapper.selectByExample(storeCriteria);
        if (list!=null&&list.size()>0){
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
            return lists;
        }else {
            throw new PeopleException("获取数据失败");
        }
    }

    @Override
    public List<Integer> monthOrder() {
      List<Integer> list=new ArrayList<Integer>();
      String currentTime=String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String b= null;
        Date date=null;
        Date date1=null;
        Date date2=null;
        Date v=null;
        try {
            Date d=sdf1.parse(currentTime);
            b = sdf2.format(d);
            v=d;
            System.out.println(v);
            date=sdf2.parse(b);
            System.out.println(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        Calendar c=Calendar.getInstance();
        c.set(Calendar.DATE,1);
        c.roll(Calendar.DATE,-1);
        int months=c.get(Calendar.DATE);

        for (int i = 1; i <months+1 ; i++) {

            SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-"+i+" 00:00:00");
            SimpleDateFormat sdf4=new SimpleDateFormat("yyyy-MM-"+i+" 23:59:59");
            try {
                b=sdf3.format(v);
                date1=sdf2.parse(b);
                String ds=sdf4.format(v);
                date2=sdf2.parse(ds);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            OrderCriteria orderCriteria=new OrderCriteria();
            OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
            criteria.andPaytimeBetween(date1,date2);
            long acount=orderMapper.countByExample(orderCriteria);
            list.add((int) acount);

        }
        return list;
    }

    @Override
    public Integer monthday() {

        Calendar c=Calendar.getInstance();
        c.set(Calendar.DATE,1);
        c.roll(Calendar.DATE,-1);
        int months=c.get(Calendar.DATE);
        return months;
    }


    @Override
    public PageBean<Order> findAllOStore(long storid, int cuurrentPage, int pagesize) {
        PageHelper.startPage(cuurrentPage,pagesize);
        OrderCriteria storeCriteria=new OrderCriteria();
        storeCriteria.createCriteria().andStoreidEqualTo(storid);
        List<Order> list=orderMapper.selectByExample(storeCriteria);
        if (list!=null&&list.size()>0){
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
            return lists;
        }else {
            throw new PeopleException("获取数据失败");
        }
        }

    @Override
    public PageBean<Order> search(Long condition, int cuurrentPage, int pagesize) {
        PageHelper.startPage(cuurrentPage,pagesize);
        OrderCriteria storeCriteria=new OrderCriteria();
        storeCriteria.createCriteria().andIdEqualTo(condition);
        List<Order> list=orderMapper.selectByExample(storeCriteria);
        if (list!=null&&list.size()>0){
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
            return lists;
        }else {
            throw new PeopleException("获取数据失败");
        }
    }

    @Override
    public PageBean<Order> searchByStatus(Long condition, byte status, int cuurrentPage, int pagesize) {
        PageHelper.startPage(cuurrentPage,pagesize);

        List<Order> list=orderMapper.dimStatus(condition,status);
        if (list!=null&&list.size()>0){
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
            return lists;
        }else {
            throw new PeopleException("获取数据失败");
        }
    }

    @Override
    public List<Order> getOrderStatus(Long userid, byte status) {
        OrderCriteria orderCriteria=new OrderCriteria();
        OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andIspayEqualTo(status);
        List<Order> list=orderMapper.selectByExample(orderCriteria);
        if (list!=null&&list.size()>0){
            return list;
        }else {
            throw new PeopleException("查询失败");
        }
    }
}

