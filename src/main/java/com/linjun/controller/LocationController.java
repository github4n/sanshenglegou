package com.linjun.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.linjun.common.JsonResult;
import com.linjun.config.WeixinConfig;
import com.linjun.pojo.Location;
import com.linjun.util.HttpsUtil;
import com.linjun.util.NetUtil;
import com.qiniu.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@Slf4j
public class LocationController {

    @GetMapping(value = "/getweixnconfigin")
public JsonResult getweixnconfigin(
        @RequestParam(value = "/openid")String opendid
    ){
        try{
            String jsapi_ticket = "jsapi_ticket";
            Map<String, String> ret = sign(jsapi_ticket, opendid);
        return new JsonResult("200",ret);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }

   @GetMapping(value = "/getzhlocation")
   public JsonResult getzhlocation(
           @RequestParam(value = "a") double a,
           @RequestParam(value = "b") double b){
        try{
            String locationurl="http://api.map.baidu.com/geocoder/v2/?callback=renderReverse&location="+a+","+b+"&output=json&pois=0&ak="+ WeixinConfig.BAIDULation;
            Map<String, String> res = new HashMap<String, String>();
            String response= NetUtil.sendGetRequest(locationurl,null,null);
            response=response.replaceAll("renderReverse&&renderReverse","");
            response=response.replaceAll("\\(","");
            response=response.replaceAll("\\)","");

            Location location=new Gson().fromJson(response,Location.class);
            res.put("privince",location.getResult().getAddressComponent().getProvince());
            res.put("city",location.getResult().getAddressComponent().getCity());
            res.put("country",location.getResult().getAddressComponent().getCountry());

            return new JsonResult("200",res);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }


   }


    public static Map<String, String> sign(String jsapi_ticket, String url) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
