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
               return  new JsonResult("200",user);
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
         @RequestParam(value = "orderID",required = false)long gooid
 ){
     try{
      orderService.deletebyuserid(userID,gooid);
      return  new JsonResult("200","删除成功");
     }catch (Exception e){
      return  new JsonResult("500",e.getMessage());
     }
 }

//生成用户订单
 @PostMapping(value = "/creatOrder")
   public JsonResult creatOrder(
   @RequestBody Order order
 ) {
          try{
             orderService.createOrder(order);
           return  new JsonResult("200",order);
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


}
