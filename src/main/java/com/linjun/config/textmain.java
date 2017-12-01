package com.linjun.config;



import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class textmain {


   public  static void main(String[] args) throws ParseException {

       List<Integer> list=new ArrayList<Integer>();
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

       for (int i = 1; i <6 ; i++) {
           SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-"+i+" 00:00:00");
           SimpleDateFormat sdf4=new SimpleDateFormat("yyyy-MM-"+i+" 23:59:59");
           try {
               b=sdf3.format(v);
               date1=sdf2.parse(b);
               System.out.println(date1);
               String ds=sdf4.format(v);
               System.out.println(ds);
               date2=sdf2.parse(ds);
               System.out.println(date2);

           } catch (ParseException e) {
               e.printStackTrace();
           }

       }


   }







    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
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
