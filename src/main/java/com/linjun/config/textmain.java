package com.linjun.config;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class textmain {
    public static  String accessKey="WNiSKaCk1gu5mt3JtW5cqwhtBMD0pCvitUhzKRwI";
    public  static  String secretKey="g9wBcCWARvYjEjyA8dHqsocB5qolKir-mqIvv-9l";
    public  static  String bucket="sansheng";

   public  static void main(String[] args) {
          String key="pthosdsts.jpg";
       String filepath="/Users/linjun/Desktop/9BA2B3A5B4BFD9821D6FC01BEEEBB999.jpg";
       Auth auth=Auth.create(accessKey,secretKey);
         UploadManager uploadManager=new UploadManager(new com.qiniu.storage.Configuration(Zone.zone0()));
       String uptakon=auth.uploadToken(bucket);
        System.out.println(uptakon);
       try {
           Response response=uploadManager.put(filepath,key,uptakon);
           DefaultPutRet putRet =new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
           System.out.println(putRet.key);
           System.out.println(putRet.hash);
       } catch (QiniuException e) {
           e.printStackTrace();
       }

   }

}
