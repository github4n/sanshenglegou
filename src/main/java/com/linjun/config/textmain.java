package com.linjun.config;

import com.google.gson.Gson;
import com.linjun.common.JsonResult;
import com.linjun.controller.StoreController;
import com.linjun.model.Goods;
import com.linjun.model.GoodsImage;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;

public class textmain {
    public static  String accessKey="WNiSKaCk1gu5mt3JtW5cqwhtBMD0pCvitUhzKRwI";
    public  static  String secretKey="g9wBcCWARvYjEjyA8dHqsocB5qolKir-mqIvv-9l";
    public  static  String bucket="sansheng";

   public  static void main(String[] args) {

       StoreController storeController=new StoreController();
       Goods goods=new Goods();
       goods.setId((long) 3);
       goods.setGoodsname("s入网费威");



   }

}
