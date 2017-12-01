package com.linjun.config;



import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class textmain {


   public  static void main(String[] args) throws ParseException {


      


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
