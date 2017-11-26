package com.linjun.config;

import com.linjun.common.JsonResult;
import com.linjun.controller.StoreController;
import com.linjun.model.Goods;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class textmain {


   public  static void main(String[] args) throws ParseException {

       Auth auth=Auth.create(QiNiuconfig.accessKey,QiNiuconfig.secretKey);
       BucketManager bucketManager=new BucketManager(auth,new Configuration(Zone.zone0()));
       String imagurl="tupian1.jpg";
       try {           System.out.println("成是功");

           bucketManager.delete(QiNiuconfig.bucket,imagurl);
           System.out.println("成功");
       } catch (Exception e) {
           e.printStackTrace();
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
