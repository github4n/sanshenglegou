package com.linjun.util;

public class CreditAdd {

 private  CreditAdd(){};
 private  static  CreditAdd creditAdd=null;
 public  static  CreditAdd getInstance(){
     if (creditAdd==null){
         creditAdd=new CreditAdd();
     }
     return creditAdd;
 }
public  int addByGoods(long goodsid){


  return  0;
}


}
