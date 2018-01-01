package com.linjun.config;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.linjun.pojo.Location;
import com.linjun.util.HttpsUtil;
import com.linjun.util.NetUtil;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class textmain {


   public  static void main(String[] args) throws ParseException {
    Double a=39.934;
    Double b=245.7;
       String locationurl="http://api.map.baidu.com/geocoder/v2/?callback=renderReverse&location="+a+","+b+"&output=json&pois=0&ak="+ WeixinConfig.BAIDULation;
       String c="http://api.map.baidu.com/geocoder/v2/?callback=renderReverse&location=39.934,116.329&output=json&pois=0&ak=3vmb6zina9IM6ku0mkMONj8ge62Gj030";
//
       String response= HttpsUtil.httpsRequestToString(c,"GET", null);
// String response= NetUtil.sendGetRequest(c,null,null);
    response=response.replaceAll("renderReverse&&renderReverse","");
       response=response.replaceAll("\\(","");
       response=response.replaceAll("\\)","");

       Location location=new Gson().fromJson(response,Location.class);

System.out.println(response);
System.out.println(location.getResult().getAddressComponent().getCity());

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
