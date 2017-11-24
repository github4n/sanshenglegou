package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.domain.PeopleException;
import com.linjun.dao.IncomeMapper;
import com.linjun.entity.PageBean;
import com.linjun.model.Income;
import com.linjun.model.IncomeCriteria;
import com.linjun.service.InComeService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class IncomeServiceImpl implements InComeService {
    @Autowired
    IncomeMapper incomeMapper;


    @Override
    public PageBean<Income> findall(int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        IncomeCriteria incomeCriteria=new IncomeCriteria();
        List<Income> list=incomeMapper.selectByExample(incomeCriteria);
         if (list!=null&&list.size()>0){
             long total=countIncome();
             int pages,sise;
             if (total%currentpage==0){
                 pages= (int) (total/currentpage);
             }else {
                 pages= (int) (total/currentpage)+1;
             }
             if (pages*pagesize==total){
                 sise=currentpage*pagesize;
             }else {
                 if (currentpage<pages){
                     sise=currentpage*pagesize;
                 }else {
                     sise= (int) total;
                 }
             }
             PageBean<Income> lists=new PageBean<Income>(total,currentpage,pagesize,pages,sise,list);
             return lists;
         }else {
             throw new PeopleException("查询失败");
         }


    }

    @Override
    public Long countIncome() {
        IncomeCriteria incomeCriteria=new IncomeCriteria();

        return incomeMapper.countByExample(incomeCriteria);
    }

    @Override
    public Float todayincome() {
          String a=String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat sdf3= new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String b= null;
        String c=null;
        Date date1 = null;
        Date date2=null;
        try {
            b = sdf2.format(sdf1.parse(a));
            c=sdf3.format(sdf1.parse(a));
            date1=sdf2.parse(b);
            date2=sdf3.parse(c);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        IncomeCriteria incomeCriteria=new IncomeCriteria();
        IncomeCriteria.Criteria criteria=incomeCriteria.createCriteria();
        criteria.andPaytimeBetween(date1,date2);
        List<Income> list=incomeMapper.selectByExample(incomeCriteria);
        Float sumMoney=null;
        for (int i = 0; i <list.size() ; i++) {

            sumMoney+=list.get(i).getPrice();
        }

        return sumMoney;
    }

    @Override
    public Float sumincome() {
        IncomeCriteria incomeCriteria=new IncomeCriteria();
        List<Income> list=incomeMapper.selectByExample(incomeCriteria);
        Float sumMoney=null;
        for (int i = 0; i <list.size() ; i++) {

            sumMoney+=list.get(i).getPrice();
        }

        return sumMoney;
    }

    @Override
    public Float monthcome() {
        String a= String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-01 00:00:00");
        String b= null;
        Date date=null;
        Date date1=null;
        Date date2=null;
        try {
            b = sdf2.format(sdf1.parse(a));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            date=sdf2.parse(b);
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
        try {
            date1=sdf3.parse(b);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf4=new SimpleDateFormat("yyyy-MM-"+months+" 23:59:59");
        try {
            date2=sdf4.parse(b);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        IncomeCriteria incomeCriteria=new IncomeCriteria();
        incomeCriteria.createCriteria().andPaytimeBetween(date1,date2);
        List<Income> list=incomeMapper.selectByExample(incomeCriteria);
        Float sumMoney = null;
        for (int i = 0; i < list.size(); i++) {

            sumMoney+=list.get(i).getPrice();


        }
        return sumMoney;
    }

    @Override
    public List<Float> weekincome() {
        List<Float> lists=new ArrayList<Float>();
        Calendar rightNow = Calendar.getInstance();
        int day = rightNow.get(rightNow.DAY_OF_WEEK);//获取时间
        IncomeCriteria incomeCriteria = new IncomeCriteria();
        String a= String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String b= null;
        Date date=null;
        try {
            b = sdf2.format(sdf1.parse(a));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            date=sdf2.parse(b);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (day == 1) {
            for (int i = 7; i > 0; i--) {
                incomeCriteria.createCriteria().andPaytimeBetween(getpost(i),getpost(i-1) );
                List<Income> list=incomeMapper.selectByExample(incomeCriteria);
                Float sumMoney=null;
                for (int j = 0; j < list.size(); j++) {

                    sumMoney+=list.get(j).getPrice();
                }
                lists.add(sumMoney);
            }
        } else {
            for (int i = day - 1; i < 0; i--) {
                incomeCriteria.createCriteria().andPaytimeBetween(getpost(i-1),getpost(i-2));
                List<Income> list=incomeMapper.selectByExample(incomeCriteria);
                Float sumMoney=null;
                for (int j = 0; j <list.size() ; j++) {
                    sumMoney+=list.get(j).getPrice();
                }
                lists.add( sumMoney);
            }
        }
        return lists;
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
    public List<Float> monthincome() {
        return null;
    }

    @Override
    public Integer monthday() {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.DATE,1);
        c.roll(Calendar.DATE,-1);
        int months=c.get(Calendar.DATE);
        return months;    }

    @Override
    public PageBean<Income> findBy(byte status, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        IncomeCriteria incomeCriteria=new IncomeCriteria();
        IncomeCriteria.Criteria criteria=incomeCriteria.createCriteria();
        criteria.andStutasEqualTo(status);

        List<Income> list=incomeMapper.selectByExample(incomeCriteria);
      if (list!=null&&list.size()>0){
          long total=countIncome();
          int pages,sise;
          if (total%currentpage==0){
              pages= (int) (total/currentpage);
          }else {
              pages= (int) (total/currentpage)+1;
          }
          if (pages*pagesize==total){
              sise=currentpage*pagesize;
          }else {
              if (currentpage<pages){
                  sise=currentpage*pagesize;
              }else {
                  sise= (int) total;
              }
          }
          PageBean<Income> lists=new PageBean<Income>(total,currentpage,pagesize,pages,sise,list);
          return lists;
      }else {
          throw new PeopleException("查询失败");
      }


    }

    @Override
    public PageBean<Income> search(Object condition, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        List<Income> list=new ArrayList<Income>();
        if (condition instanceof String){
            IncomeCriteria incomeCriteria=new IncomeCriteria();
            IncomeCriteria.Criteria criteria=incomeCriteria.createCriteria();
            criteria.andPaynameLike(('%'+(String)condition+'%'));
             list=incomeMapper.selectByExample(incomeCriteria);
        }else if (condition instanceof Long){
            list=incomeMapper.dimfind('%'+(Long)condition+'%');
        }
        if (list!=null&&list.size()>0){
            long total=countIncome();
            int pages,sise;
            if (total%currentpage==0){
                pages= (int) (total/currentpage);
            }else {
                pages= (int) (total/currentpage)+1;
            }
            if (pages*pagesize==total){
                sise=currentpage*pagesize;
            }else {
                if (currentpage<pages){
                    sise=currentpage*pagesize;
                }else {
                    sise= (int) total;
                }
            }
            PageBean<Income> lists=new PageBean<Income>(total,currentpage,pagesize,pages,sise,list);
            return lists;
        }else {
            throw new PeopleException("查询失败");
        }


    }

    @Override
    public PageBean<Income> searchByStatus(Object condition, byte status, int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        List<Income> list=new ArrayList<Income>();
        if (condition instanceof String){
            list=incomeMapper.dimfindStrStatus('%'+(String)condition+'%',status);
        }else if (condition instanceof Long){
            list=incomeMapper.dimfindandstatus('%'+(Long)condition+'%',status);
        }
        if (list!=null&&list.size()>0){
            long total=countIncome();
            int pages,sise;
            if (total%currentpage==0){
                pages= (int) (total/currentpage);
            }else {
                pages= (int) (total/currentpage)+1;
            }
            if (pages*pagesize==total){
                sise=currentpage*pagesize;
            }else {
                if (currentpage<pages){
                    sise=currentpage*pagesize;
                }else {
                    sise= (int) total;
                }
            }
            PageBean<Income> lists=new PageBean<Income>(total,currentpage,pagesize,pages,sise,list);
            return lists;
        }else {
            throw new PeopleException("查询失败");
        }
    }
}
