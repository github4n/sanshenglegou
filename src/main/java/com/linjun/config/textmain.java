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

       String a= String.valueOf(new Date());
       SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
       SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String b= null;
       Date date=null;
       try {
           b = sdf2.format(sdf1.parse(a));

           System.out.println(b);
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
       SimpleDateFormat sdf4= new SimpleDateFormat("yyyy-MM-"+dayOfMonth+" HH:mm:ss");
              String r= sdf4.format(sdf1.parse(a));
               System.out.println(r);


       Calendar c=Calendar.getInstance();
       c.set(Calendar.DATE,1);
    c.roll(Calendar.DATE,-1);
       int months=c.get(Calendar.DATE);



System.out.println(dayOfMonth);
       System.out.println(months);
   }

    public static Date getpaost(int post) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - post);
        Date today = calendar.getTime();
        return today;
    }
}
