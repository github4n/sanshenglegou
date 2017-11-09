package com.linjun.controller;

import com.linjun.common.JsonResult;

import com.linjun.model.*;
import com.linjun.service.*;
import com.sun.xml.internal.ws.api.addressing.AddressingVersion;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.ECMAException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;
import sun.jvm.hotspot.debugger.Address;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value ="/user")
public class UserController {
 @Autowired
 UserService userService;
 @Autowired
 CreditMangerService creditMangerService;/**/
@Autowired
 OrderService orderService;
@Autowired
 GoodsService goodsService;
@Autowired
ShoppingcartService shoppingcartService;
@Autowired
RecommendService recommendService;
@Autowired
OrderDetailService orderDetailService;
@Autowired
AddressMongerService addressMongerService;

// 用户注册
 @PostMapping(value = "/register")
 public JsonResult register(@RequestBody String username,
                            @RequestBody String password,
                            @RequestBody String token,
                            @RequestBody String tel,
                            @RequestBody  String ip){
  try {
   User user = new User();
   user.setUsername(username);
   user.setCreatetime(new Date());
   user.setPassworld(password);
   user.setLogin(new Date());
   user.setIp(ip);
   user.setTel(tel);
   user.setToken(token);
   userService.add(user);



   return new JsonResult("200", "注册成功",user);
  }catch (Exception e){
   return new JsonResult("500",e.getMessage());
  }
 }
 private  String randommuber(){
     Random rand = new Random();
     char[] letters=new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
             'R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i',
             'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','r',
             '0','1','2','3','4','5','6','7','8','9'};
     String str = "";
     int index;
     boolean[] flags = new boolean[letters.length];//默认为false
     for(int i=0;i<5;i++){
         do{
             index = rand.nextInt(letters.length);
         }while(flags[index]==true);
         char c = letters[index];
         str += c;
         flags[index]=true;
     }
  return str;
 }
private  int rands(){
    int[] array = {0,1,2,3,4,5,6,7,8,9};
    Random rand = new Random();
    for (int i = 10; i > 1; i--) {
        int index = rand.nextInt(i);
        int tmp = array[index];
        array[index] = array[i - 1];
        array[i - 1] = tmp;
    }
    int result = 0;
    for(int i = 0; i < 6; i++)
        result = result * 10 + array[i];
    return result;
}





 @PostMapping(value = "/registerByTel")
 public  JsonResult registerByTel(
         @RequestParam(value ="tel",required = false)String tel,
         @RequestParam(value ="password",required = false)String password
 ){
      try{
          User user=new User();
          user.setPassworld(password);
          user.setTel(tel);
          user.setUsername(randommuber());
          user.setLogin(new Date());
          user.setCreatetime(new Date());
          userService.registerByPhone(user);
          return new JsonResult("200",user);
      }catch (Exception e){
          return  new JsonResult("500",e.getMessage());
      }

 }

//用户手机登入
    @GetMapping(value = "/loginByTel")
    public  JsonResult loginByTel(
            @RequestParam(value = "tel",required = false)String tel,
            @RequestParam(value = "password",required = false)String password
    ){
        User user=new User();
        user.setTel(tel);
        user.setPassworld(password);
        try{
            User user1=userService.loginByPhone(user);
            return  new JsonResult("200",user1);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }

    }



// 用户登入
   @GetMapping(value = "/login")
  public  JsonResult login(
           @RequestParam(value = "username",required = false)String username,
           @RequestParam(value = "password",required = false)String password){
           User user=new User();
           user.setUsername(username);
           user.setPassworld(password);
           try{
               User usesr=  userService.loginByUsername(user);
               return  new JsonResult("200",usesr);
           }catch (Exception e){
               return new JsonResult("500",e.getMessage());
           }
   }
//  用户信息获取
 @GetMapping(value = "getUserInformation")
 public  JsonResult getUserInformation(
         @RequestParam(value = "username",required = false)String username,
         @RequestParam(value = "password",required = false)String password
 ){

  boolean a=userService.isExits(username,password);
  if (a){
     User user=userService.findByusername(username);

  return  new JsonResult("200","成功",user);
  }else {
   return new JsonResult("600","用户名不存在");
  }

 }
//  用户的积分获取
 @GetMapping(value = "/getcredit")
 public  JsonResult getUserCredit(
         @RequestParam(value = "userID",required = false)long userID
 ){
     CreditManger creditManger= creditMangerService.findByuserid(userID);
   return  new JsonResult("200",creditManger);
 }






//用户信息的更新
 @PutMapping(value = "/update")
 public JsonResult update(
         @RequestBody User user
 ){
          try{
          userService.updateUser(user);
           return  new JsonResult("200",user);
          }catch (Exception e){
           return  new JsonResult("500",e.getMessage());
          }
 }
//用户订单的获取
 @GetMapping(value = "/getOrder")
 public JsonResult getOrder(
         @RequestParam(value = "userID",required = false)long userID
 ){
  List<Order> orderList=orderService.findByuserid(userID);
  return  new JsonResult("200",orderList);

 }
//  删除订单
 @DeleteMapping(value = "/delete")
 public JsonResult delete(
         @RequestParam(value = "userID",required = false)long userID,
         @RequestParam(value = "orderID",required = false)long orderID
 ){
     try{
         Order order=orderService.findByOrder(userID,orderID);
         orderDetailService.deletebyid(order.getId());
      orderService.deletebyuserid(userID,orderID);
      return  new JsonResult("200","删除成功");
     }catch (Exception e){
      return  new JsonResult("500",e.getMessage());
     }
 }
//生成用户订单
 @PostMapping(value = "/creatOrder")
   public JsonResult creatOrder(
   @RequestParam(value = "goodsid")long goodsid,
   @RequestParam(value = "userid")long userid,
   @RequestParam(value = "goodsum")int goodsum
 ) {
          try{
        Goods goods;
        goods=goodsService.findByid(goodsid);
          Order order=new Order();
          order.setUserid(userid);
          order.setGoodsum(goodsum);
          order.setIspay((byte) 0);
          order.setIsreceive((byte) 0);
          order.setGoodsname(goods.getGoodsname());
          order.setGoodsid(goodsid);
          order.setMarketpricce(goods.getMarketprive());
          order.setMemberprice(goods.getMemberprice());
          order.setOrdercode((long) rands());
          order.setStoreid(goods.getStoreid());
          order.setSendtime(new Date());
        AddressManger addressManger=addressMongerService.findByUserid(userid);
          order.setAddressid(addressManger.getId());
          Order order1=orderService.createOrder(order);
          OrderDetail orderDetail=new OrderDetail();
          orderDetail.setOrderstate(String.valueOf(1));
          orderDetail.setOrderid(order1.getId());
              OrderDetail orderDetail1=orderDetailService.add(orderDetail);
           return  new JsonResult("200","成功");
          }catch (Exception e){
           return  new JsonResult("500",e.getMessage());
          }

}
//    支付订单
    @PutMapping(value = "/updateOrder")
    public  JsonResult updateOrder(
            @RequestParam(value = "userID",required = false)long userID,
            @RequestParam(value = "orderID",required = false)long orderID
    ){

      Order order=new Order();
      order.setIspay((byte) 1);
       orderService.update(userID,orderID,order);
       return  new JsonResult("200","更新成功");
    }

//加入购物车功能
  @PostMapping(value = "/creatshopping")
 public  JsonResult creatshopping(
         @RequestBody ShoppingCart shoppingCart
  ){
     try{
         ShoppingCart shoppingCart1=  shoppingcartService.addCart(shoppingCart);
         return  new JsonResult("200",shoppingCart1);
     }catch (Exception e){
      return new JsonResult("500",e.getMessage());
     }
  }
//清除购物车的功能
    @DeleteMapping(value = "/deleteShopping")
    public  JsonResult deleteShopping(
          @RequestParam(value = "userID",required = false)long userID,
          @RequestParam(value = "goodsID",required = false)long goodsID
          ){
       try{
           shoppingcartService.deletebygoodsid(goodsID,userID);
           return new JsonResult("200",shoppingcartService.findByuserid(userID));
       } catch (Exception e){
           return  new JsonResult("500",e.getMessage());
       }
    }
//推荐入驻
    @PostMapping(value = "/recommend")
    public JsonResult recommend(
            @RequestBody Order order
    ){
       try{
           orderService.createOrder(order);
          return  new JsonResult("200",order);
       }catch (Exception e){
           return  new JsonResult("500",e.getMessage());
       }
    }

//添加地址管理
    @PostMapping(value = "addAdressManger")
    public  JsonResult addAddressManger(
            @RequestBody AddressManger addressManger
    ){
                try {
                    AddressManger addressManger1 = addressMongerService.add(addressManger);
                    return  new JsonResult("200",addressManger1);
                }catch (Exception e){
                    return  new JsonResult("500","查询失败");
                }

    }


//删除地址
    @DeleteMapping(value = "deleteAddress")
    public  JsonResult deleteAddressManger(
            @RequestParam(value = "userid")long userid,
            @RequestParam(value = "addressID")long addressID
    ){
         int reasult=addressMongerService.delelet(userid,addressID);
         if (reasult>0){
             List<AddressManger> list=addressMongerService.findByuser(userid);


             return  new JsonResult("200",list);
         }else{
             return  new JsonResult("500","删除地址失败");
         }
    }
//    获取用户地址列表
    @GetMapping(value = "/getAddressList")
    public  JsonResult getAddressList(
            @RequestParam(value = "userID")long userid
    ){
          List<AddressManger> list=addressMongerService.findByuser(userid);
          if (list!=null&&list.size()>=0){
            return new JsonResult("200",list);
          }else {
              return  new JsonResult("500","获取地址失败");
          }

    }



}
