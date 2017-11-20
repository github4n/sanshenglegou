package com.linjun.config;

import com.linjun.controller.StoreController;
import com.linjun.model.Goods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class textmain {


   public  static void main(String[] args) throws ParseException {
          System.out.println(getpost(7));
       Calendar rightNow=Calendar.getInstance();
       int day = rightNow.get(rightNow.DAY_OF_WEEK);//获取时间
       System.out.println(day);

   }

    private static Date getpost(int post) {
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
            System.out.println(b);
            todays=sdf2.parse(b);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return todays;
    }
}
