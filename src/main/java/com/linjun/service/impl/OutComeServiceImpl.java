package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.domain.PeopleException;
import com.linjun.dao.OutcomeMapper;
import com.linjun.entity.PageBean;
import com.linjun.model.Outcome;
import com.linjun.model.OutcomeCriteria;
import com.linjun.service.OutComeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OutComeServiceImpl implements OutComeService {
    @Autowired
    OutcomeMapper outcomeMapper;


    @Override
    public PageBean<Outcome> findAll(int currentPage, int pagesize) {
        PageHelper.startPage(currentPage,pagesize);
        OutcomeCriteria outcomeCriteria=new OutcomeCriteria();
        List<Outcome> list=outcomeMapper.selectByExample(outcomeCriteria);
        if (list!=null&&list.size()>0){
            long total=countOutCome();
            int pages,size;
            if (total%currentPage==0){
                pages= (int) (total/currentPage);
            }else {
                pages= (int) (total/currentPage)+1;
            }
            if (pages*pagesize==total){
                size=currentPage*pages;
            }else {
                if (currentPage<pages){
                    size=currentPage*pagesize;
                }else {
                    size=(int)total;
                }
            }

            PageBean<Outcome> lists=new PageBean<Outcome>(total,currentPage,pagesize,pages,size,list);
            return lists;
        }else {
            throw new PeopleException("查询失败");
        }


    }

    @Override
    public List<Outcome> findToday() {



        return null;
    }

    @Override
    public Long countOutCome() {
        OutcomeCriteria criteria=new OutcomeCriteria();

        return outcomeMapper.countByExample(criteria);
    }

    @Override
    public Float todayOutcome() {
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
        OutcomeCriteria outcomeCriteria=new OutcomeCriteria();
        OutcomeCriteria.Criteria criteria=outcomeCriteria.createCriteria();
        criteria.andPaytimeBetween(date1,date2);
        List<Outcome> list=outcomeMapper.selectByExample(outcomeCriteria);
        Float sumMoney=null;
        for (int i = 0; i <list.size() ; i++) {

            sumMoney+=list.get(i).getPrice();
        }

        return sumMoney;

    }

    @Override
    public Float sumOutcome() {
         OutcomeCriteria outcomeCriteria=new OutcomeCriteria();
         List<Outcome> list=outcomeMapper.selectByExample(outcomeCriteria);
         Float sumMoney = null;
        for (int i = 0; i <list.size() ; i++) {

            sumMoney+=list.get(i).getPrice();
        }

        return sumMoney;
    }

    @Override
    public Float monthMoney() {
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
        OutcomeCriteria outcomeCriteria=new OutcomeCriteria();
        outcomeCriteria.createCriteria().andPaytimeBetween(date1,date2);
        List<Outcome> list=outcomeMapper.selectByExample(outcomeCriteria);
        Float sumMoney = null;
        for (int i = 0; i < list.size(); i++) {

            sumMoney+=list.get(i).getPrice();


        }

        return sumMoney;
    }

    @Override
    public List<Float> weekMoney() {
        List<Float> lists=new ArrayList<Float>();
        Calendar rightNow = Calendar.getInstance();
        int day = rightNow.get(rightNow.DAY_OF_WEEK);//获取时间
        OutcomeCriteria outcomeCriteria = new OutcomeCriteria();
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
                outcomeCriteria.createCriteria().andPaytimeBetween(getpaost(i),getpaost(i-1) );
                List<Outcome> list=outcomeMapper.selectByExample(outcomeCriteria);
                Float sumMoney=null;
                for (int j = 0; j < list.size(); j++) {

                    sumMoney+=list.get(j).getPrice();
                }
                lists.add(sumMoney);
            }
        } else {
            for (int i = day - 1; i < 0; i--) {
                outcomeCriteria.createCriteria().andPaytimeBetween(getpaost(i-1),getpaost(i-2));
                List<Outcome> list=outcomeMapper.selectByExample(outcomeCriteria);
                Float sumMoney=null;
                for (int j = 0; j <list.size() ; j++) {
                    sumMoney+=list.get(j).getPrice();
                }
                lists.add( sumMoney);
            }
        }
        return lists;
    }

    private Date getpaost(int post) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - post);
        Date today = calendar.getTime();
        String a=String.valueOf(today);
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
    public List<Float> monthMoneys() {
        List<Float>  list=new ArrayList<Float>();
        String a= String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String b= null;
        Date date=null;
        Date date1=null;
        Date date2=null;
        Date v=null;
        try {
            Date d=sdf1.parse(a);
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
            OutcomeCriteria outcomeCriteria=new OutcomeCriteria();
            OutcomeCriteria.Criteria criteria=outcomeCriteria.createCriteria();
            criteria.andPaytimeBetween(date1,date2);
            List<Outcome> list1=outcomeMapper.selectByExample(outcomeCriteria);
            Float sumMoney=null;
            for (int j = 0; j <list1.size() ; j++) {
                sumMoney+=list1.get(j).getPrice();

            }
            list.add(sumMoney);
        }
        return list;

    }

    @Override
    public Integer countDay() {

        Calendar c=Calendar.getInstance();
        c.set(Calendar.DATE,1);
        c.roll(Calendar.DATE,-1);
        int months=c.get(Calendar.DATE);
        return months;
    }

    @Override
    public PageBean<Outcome> findBy(byte status, int currentPage, int pagesize) {
        PageHelper.startPage(currentPage,pagesize);
        OutcomeCriteria outcomeCriteria=new OutcomeCriteria();
        OutcomeCriteria.Criteria criteria=outcomeCriteria.createCriteria();
        criteria.andStutasEqualTo(status);
        List<Outcome> list=outcomeMapper.selectByExample(outcomeCriteria);
        if (list!=null&list.size()>0){
            long total=countOutCome();
            int pages,size;
            if (total%currentPage==0){
                pages= (int) (total/currentPage);
            }else {
                pages= (int) (total/currentPage)+1;
            }
            if (pages*pagesize==total){
                size=currentPage*pages;
            }else {
                if (currentPage<pages){
                    size=currentPage*pagesize;
                }else {
                    size=(int)total;
                }
            }

            PageBean<Outcome> lists=new PageBean<Outcome>(total,currentPage,pagesize,pages,size,list);
            return lists;
        }else {
            throw new PeopleException("查询失败");
        }


    }

    @Override
    public PageBean<Outcome> search(Object condition, int currentPage, int pagesize) {
        PageHelper.startPage(currentPage,pagesize);
        List<Outcome>  list=new ArrayList<Outcome>();
        if (condition instanceof String){
            list=outcomeMapper.dimfindStr('%'+(String)condition+'%');
        }else if (condition instanceof  Long ||  condition instanceof  Integer){
            list=outcomeMapper.dimfind('%'+(Long)condition+'%');
        }
        if (list!=null&list.size()>0){
            long total=countOutCome();
            int pages,size;
            if (total%currentPage==0){
                pages= (int) (total/currentPage);
            }else {
                pages= (int) (total/currentPage)+1;
            }
            if (pages*pagesize==total){
                size=currentPage*pages;
            }else {
                if (currentPage<pages){
                    size=currentPage*pagesize;
                }else {
                    size=(int)total;
                }
            }

            PageBean<Outcome> lists=new PageBean<Outcome>(total,currentPage,pagesize,pages,size,list);
            return lists;
        }else {
            throw new PeopleException("查询失败");
        }
    }

    @Override
    public PageBean<Outcome> searchByStatus(Object condition, byte status, int currentPage, int pagesize) {
        PageHelper.startPage(currentPage,pagesize);
        List<Outcome>  list=new ArrayList<Outcome>();
        if (condition instanceof String){
            list=outcomeMapper.dimfindStrStatus('%'+(String)condition+'%',status);
        }else if (condition instanceof  Long || condition instanceof  Integer){
            list=outcomeMapper.dimfindandstatus('%'+(Long)condition+'%',status);
        }
        if (list!=null&list.size()>0){
            long total=countOutCome();
            int pages,size;
            if (total%currentPage==0){
                pages= (int) (total/currentPage);
            }else {
                pages= (int) (total/currentPage)+1;
            }
            if (pages*pagesize==total){
                size=currentPage*pages;
            }else {
                if (currentPage<pages){
                    size=currentPage*pagesize;
                }else {
                    size=(int)total;
                }
            }

            PageBean<Outcome> lists=new PageBean<Outcome>(total,currentPage,pagesize,pages,size,list);
            return lists;
        }else {
            throw new PeopleException("查询失败");
        }
    }
}
