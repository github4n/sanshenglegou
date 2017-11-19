package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.domain.PageList;
import com.linjun.dao.UserMapper;
import com.linjun.entity.PageBean;
import com.linjun.model.User;
import com.linjun.model.UserCriteria;
import com.linjun.service.UserService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByID(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User findByusername(String username) {
        return null;
    }

    @Override
    public boolean isExits(String username, String password) {
        return false;
    }

    @Override
    public int updateByName(String name, User user) {
        return 0;
    }

    @Override
    public int deleteBykey(long id) {
        return 0;
    }

    @Override
    public int deleteByName(String username) {
        return 0;
    }

    @Override
    public long countUser() {
        UserCriteria userCriteria=new UserCriteria();

        return userMapper.countByExample(userCriteria);
    }

    @Override
    public long countUserNew() {
        String a= String.valueOf(new Date());
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
            UserCriteria userCriteria = new UserCriteria();
            UserCriteria.Criteria criteria = userCriteria.createCriteria();
            criteria.andCreatetimeBetween(date1, date2);

        return userMapper.countByExample(userCriteria);
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
    public List<Integer> nowWeekuser() {
        List<Integer> lists=new ArrayList<Integer>();
        Calendar rightNow = Calendar.getInstance();
        int day = rightNow.get(rightNow.DAY_OF_WEEK);//获取时间
        UserCriteria userCriteria = new UserCriteria();
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
                userCriteria.createCriteria().andCreatetimeBetween(getpaost(i),date );
                long result1 = userMapper.countByExample(userCriteria);
                int r = 7 - i;
                lists.add((int) result1);
            }
        } else {
            for (int i = day - 1; i < 0; i--) {
                userCriteria.createCriteria().andCreatetimeBetween(getpaost(i),date);
                long result2 = userMapper.countByExample(userCriteria);
                int w = 1;
                w++;
                lists.add( (int) result2);
            }
        }
        return lists;
    }

    @Override
    public List<Integer> nowMonthUser() {
         List<Integer>  list=new ArrayList<Integer>();
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
        for (int i = 1; i <months+1 ; i++) {

            SimpleDateFormat sdf4=new SimpleDateFormat("yyyy-MM-"+i+" 23:59:59");
            try {
                date2=sdf4.parse(b);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            UserCriteria userCriteria=new UserCriteria();
            UserCriteria.Criteria criteria=userCriteria.createCriteria();
              criteria.andCreatetimeBetween(date1,date2);
             list.add((int) userMapper.countByExample(userCriteria));
        }
        return list;
    }

    @Override
    public PageList<User> search(String username, Integer page) {
        return null;
    }

    @Override
    public PageList<User> searchSize(String username, Integer page) {
        return null;
    }

    @Override
    public User loginByPhone(User user) {
        return null;
    }

    @Override
    public User loginByUsername(User user) {
        return null;
    }

    @Override
    public User registerByPhone(User user) {
        return null;
    }

    @Override
    public User getUserByUserid(long userid) {
        return null;
    }

    @Override
    public List<User> userlist() {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public PageBean<User> findUserList(int cuurrentPage, int pageSize) {
        PageHelper.startPage(cuurrentPage,pageSize);
        UserCriteria userCriteria=new UserCriteria();
        List<User> list=userMapper.selectByExample(userCriteria);
        long total=countUser();
        int pages,sise;
        if (total%cuurrentPage==0){
            pages= (int) (total/cuurrentPage);
        }else {
            pages= (int) (total/cuurrentPage)+1;
        }
        if (pages*pageSize==total){
            sise=cuurrentPage*pageSize;
        }else {
            if (cuurrentPage<pages){
                sise=cuurrentPage*pageSize;
            }else {
                sise= (int) total;
            }
        }
        PageBean<User> lists=new PageBean<User>(total,cuurrentPage,pageSize,pages,sise,list);
        return lists;

    }
}
