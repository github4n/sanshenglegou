package com.linjun.controller;

import com.linjun.common.JsonResult;

import com.linjun.model.*;
import com.linjun.service.*;
import com.sun.xml.internal.ws.api.addressing.AddressingVersion;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
 public JsonResult register(@RequestParam(value = "username",required = false)String username,
                            @RequestParam(value = "password",required = false)String password,
                            @RequestParam(value = "token",required =false)String token,
                            @RequestParam(value = "tel",required = false)String tel,
                            @RequestParam(value = "ip",required = false)String ip){
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
// 用户登入
   @GetMapping(value = "/login")
  public  JsonResult login(
           @RequestParam(value = "username",required = false)String username,
           @RequestParam(value = "password",required = false)String password){
           boolean a=userService.isExits(username,password);
           if (a){
            return  new JsonResult("200","成功");
           }else {
            return new JsonResult("600","用户名不存在");
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
         @RequestParam(value = "username",required = false)String username,
         @RequestParam(value = "password",required = false)String password,
         @RequestParam(value = "sex",required =false)String sex,
         @RequestParam(value = "tel",required = false)String tel,
         @RequestParam(value = "email",required = false)String email
 ){
          try{
           User user=new User();
           user.setTel(tel);
           user.setPassworld(password);

           user.setEmail(email);
           user.setSex(sex);
           userService.updateByName(username,user);
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
   @RequestParam(value = "userID",required = false)long userID,
   @RequestParam(value = "goodsID",required = false)long goodsID,
   @RequestParam(value = "sum",required = false)int sum
 ) {
          try{
           Goods goods= goodsService.findByid(goodsID);
           Order order=new Order();
           order.setGoodsid(goodsID);
           order.setGoodsname(goods.getGoodsname());
           order.setGoodsum((int) (goods.getMemberprice()*3));
           order.setIspay((byte) 0);
           order.setIsreceive((byte) 0);
           order.setMarketpricce(goods.getMarketprive());
           order.setMemberprice(goods.getMemberprice());
           order.setGoodsum(sum);
           order.setUserid(userID);
           orderService.add(order);
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
          @RequestParam(value = "userID",required = false)long userID,
          @RequestParam(value = "goodsID",required = false)long goodsID,
          @RequestParam(value = "sum",required = false)long sum
  ){
     try{
       Goods goods= goodsService.findByid(goodsID);
     ShoppingCart shoppingCart=new ShoppingCart();
     shoppingCart.setGoodsid(goodsID);
     shoppingCart.setUserid(userID);
     shoppingCart.setGoodsname(goods.getGoodsname());
     shoppingCart.setMemberprice(goods.getMemberprice());
     shoppingCart.setNumber(sum);
      shoppingCart.setStoreid(goods.getStoreid());
      shoppingCart.setStorename(goods.getGoodsname());
     boolean a= shoppingcartService.add(shoppingCart);
     if (a){
         return  new JsonResult("200",shoppingCart);
     }else {
         return new JsonResult("600","数据导入失败");
     }

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
            @RequestParam(value = "userID",required = false)long userID,
            @RequestParam(value = "type",required = false)String type,
            @RequestParam(value = "recommendName",required = false)String recommendName
    ){
        Recommend recommend=new Recommend();
        recommend.setCreatetime(new Date());
        recommend.setIscheck((byte) 0);
        recommend.setRecommendname(recommendName);
        recommend.setType(type);
        recommend.setUserid(userID);
        if (recommendService.add(recommend)){
            return new JsonResult("200",recommend);
        }else {
            return new JsonResult("500","失败");
        }
    }


}
