package com.linjun.config;

import com.linjun.controller.StoreController;
import com.linjun.model.Goods;

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
