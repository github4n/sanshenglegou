package com.linjun.controller;

import com.linjun.common.JsonResult;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.ShoppingCartMapper;
import com.linjun.model.*;
import com.linjun.pojo.Address;
import com.linjun.pojo.Cart;
import com.linjun.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value ="/user")
public class UserController {
    @Autowired
    AdminService adminService;
    @Autowired
    StoreService storeService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;

    @Autowired
    GoodsService goodsService;
    @Autowired
    AddressMongerService addressMongerService;
    @Autowired
    GoodsImageService goodsImageService;
    @Autowired
    GoodsTypeService goodsTypeService;
    @Autowired
    LogisticsService logisticsService;
    @Autowired
    GoodsDetailService goodsDetailService;
    @Autowired
    InComeService inComeService;
    @Autowired
    OutComeService outComeService;
    @Autowired
    MemberApplyService memberApplyService;
    @Autowired
    VillageApplyService villageApplyService;
    @Autowired
    StoreApplyService storeApplyService;
    @Autowired
    WithDrawApplyService withDrawApplyService;
    @Autowired
    CreditMangerService creditMangerService;
    @Autowired
    ShoppingcartService shoppingcartService;
    @Autowired
    CreditDetialService creditDetialService;


// 用户注册
 @PostMapping(value = "/register")
 public JsonResult register(@RequestParam(value = "username") String username,
                            @RequestParam(value = "OpenID") String OpenID,
                            @RequestParam(value = "token") String token,
                            @RequestParam(value = "city") String city,
                            @RequestParam(value = "province")  String province,
                            @RequestParam(value = "country")String country,
                            @RequestParam(value = "sex")String sex,
                            @RequestParam(value = "headimge")String headimage,
                            @RequestParam(value = "ip")String ip
                            ){
  try {
      User user=new User();
      user.setUsername(username);
      user.setRole((byte) 0);
      user.setCity(city);
      user.setCountry(country);
      user.setProvince(province);
      user.setSex(sex);
      user.setHeadimage(headimage);
      user.setOpenid(OpenID);
      user.setToken(token);
      user.setIp(ip);
      String a= String.valueOf(new Date());
      SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
      SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String b=sdf2.format(sdf1.parse(a));
      Date date=sdf2.parse(b);
      user.setCreatetime(date);
      user.setLogin(date);
      User user1=userService.add(user);

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











// 用户登入
   @GetMapping(value = "/login")
  public  JsonResult login(
           @RequestParam(value = "openid",required = false)String openid) throws ParseException {
           User user=new User();
           user.setOpenid(openid);
       String a= String.valueOf(new Date());
       SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
       SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String b=sdf2.format(sdf1.parse(a));
       Date date=sdf2.parse(b);
           user.setLogin(date);
             User userold=userService.findByOpenid(user);
             user.setId(userold.getId());
           try{
               User user1=userService.updateUser(user);
               return  new JsonResult("200",user);
           }catch (Exception e){
               return new JsonResult("500",e.getMessage());
           }
   }



//  用户信息获取
 @GetMapping(value = "getUserInformation")
 public  JsonResult getUserInformation(
         @RequestParam(value = "id",required = false)Long id
 ){
    try{

          User user1=userService.findByID(id);
          return new JsonResult("200",user1);
    }catch (Exception e){
       return new JsonResult("500",e.getMessage());
    }
 }


//  用户的积分获取
 @GetMapping(value = "/getcredit")
 public  JsonResult getUserCredit(
         @RequestParam(value = "id",required = false)long id
 ){
     try{
         CreditManger creditManger=creditMangerService.findByuserid(id);
         return new JsonResult("200",creditManger);
     }catch (Exception e){
         return new JsonResult("500",e.getMessage());
     }
 }


//用户信息的更新
 @PutMapping(value = "/update")
 public JsonResult update(
         @RequestBody User user
 ){
          try{
          User user1=userService.updateUser(user);
           return  new JsonResult("200",user);
          }catch (Exception e){
           return  new JsonResult("500",e.getMessage());
          }
 }
//  删除订单
 @DeleteMapping(value = "/delete")
 public JsonResult delete(
         @RequestParam(value = "userID",required = false)long userID,
         @RequestParam(value = "orderID",required = false)long orderID
 ){
     try{
     int result= orderService.deletebyuserid(userID,orderID);
      return  new JsonResult("200",result);
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
           Order order1=orderService.add(order);
           return  new JsonResult("200",order);
          }catch (Exception e){
           return  new JsonResult("500",e.getMessage());
          }

}
//    支付订单
    @PutMapping(value = "/updateOrder")
    public  JsonResult updateOrder(
            @RequestBody Order order
    ){
             try{
                Order order1=orderService.update(order);
                return new JsonResult("200",order1);

             }catch (Exception e){
                 return new JsonResult("500",e.getMessage());
             }

    }

//加入购物车功能
  @PostMapping(value = "/creatshopping")
 public  JsonResult creatshopping(
         @RequestBody ShoppingCart shoppingCart
  ){
     try{
            ShoppingCart shoppingCart1=shoppingcartService.add(shoppingCart);
         return  new JsonResult("200",shoppingCart);
     }catch (Exception e){
      return new JsonResult("500",e.getMessage());
     }
  }
//清除购物车的功能
    @DeleteMapping(value = "/deleteShopping")
    public  JsonResult deleteShopping(
          @RequestParam(value = "shopcartid",required = false)long shopcartid
          ){
       try{
           ShoppingCart shoppingCart=new ShoppingCart();
           shoppingCart.setId(shopcartid);
           int result=shoppingcartService.deleteByid(shoppingCart);
           return new JsonResult("200",result);
       } catch (Exception e){
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
            @RequestParam(value = "addressid")long addressid
    ){
        try{
            int result=addressMongerService.delelet(addressid);
            return new JsonResult("200",result);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }

    }
//    获取用户地址列表
    @GetMapping(value = "/getAddressList")
    public  JsonResult getAddressList(
            @RequestParam(value = "userID")long userID
    ){
         try{
             List<AddressManger> list=addressMongerService.findByuser(userID);
             List<Address> addresslist=new ArrayList<Address>();
             Address address=new Address();
             for (AddressManger data: list) {
                address.setId(data.getId());
                address.setAddress(data.getAddressdetail());
                address.setTel(data.getReceivetel());
                address.setIsDefault(data.getIsdefault());

                addresslist.add(address);
             }
             return new JsonResult("200",addresslist);
         }catch (Exception e){
             return new JsonResult("500",e.getMessage());
         }

    }
//    获取所有订单
    @GetMapping(value = "/getOrderAll")
    public JsonResult getOrderAll(
            @RequestParam(value = "userid")Long userid
    ){
           try{
               List<Order> list=orderService.findByuserid(userid);
               return new JsonResult("200",list);
           }catch (Exception e){
               return new JsonResult("500",e.getMessage());
           }

    }
//    用户支付状态的订单
    @GetMapping(value = "/getOrderStatus")
    public  JsonResult getOrderStatus(
            @RequestParam(value = "userid")Long userid,
            @RequestParam(value = "status")Byte status
    ){
           try{
               List<Order> list=orderService.getOrderStatus(userid,status);
               return new JsonResult("200",list);
           }catch (Exception e){
               return  new JsonResult("500",e.getMessage());
           }
    }
//    获取用户购物车的数据
    @GetMapping(value = "/getshopcart")
    public  JsonResult getshopcart(
            @RequestParam(value = "userid")Long userid
    ){
            try{
                List<ShoppingCart> list=shoppingcartService.findByuserid(userid);
                Cart cart=new Cart();
                List<Cart> cartList=new ArrayList<Cart>();
                for (ShoppingCart data:list){
                    cart.setGoodsid(data.getGoodsid());
                    cart.setGoodimage(goodsImageService.findMainImage(data.getGoodsid()).getIamgeaddress());
                    cart.setGoodsname(data.getGoodsname());
                    cart.setMemberprice(data.getMemberprice());
                    cart.setNumber(data.getNumber());
                    cart.setStoreid(data.getStoreid());
                    cart.setStorename(data.getStorename());
                    cart.setUserid(data.getUserid());
                     cart.setId(data.getId());
                    cartList.add(cart);
                }


                return new JsonResult("200",cartList);
            }catch (Exception e){
                return  new JsonResult("500",e.getMessage());
            }
    }
//    用户积分详情
    @GetMapping(value = "/getcreditDetail")
    public JsonResult getcreditDetail(
            @RequestParam(value = "userid")Long userid
    ){
         try{
             List<CreditDetail>list=creditDetialService.findbyuserid(userid);
             return  new JsonResult("200",list);
         }catch (Exception e){
             return new JsonResult("500",e.getMessage());
         }

    }
//    获取用户默认地址
    @GetMapping(value = "/getDefaultAddress")
    public  JsonResult getDefaultAddress(
            @RequestParam(value ="userid")Long userid
    ){
       try{
           AddressManger addressManger=addressMongerService.findByUseridDefault(userid);
           return  new JsonResult("200",addressManger);
       }catch (Exception e){
           return new JsonResult("500",e.getMessage());
       }
    }
//批量删除购物车数据
    @DeleteMapping(value = "/deletecart")
    public  JsonResult deletecart(
            @RequestParam(value = "cartids")List<Long> cartids
    ){
                List<ShoppingCart> list=new ArrayList<ShoppingCart>();
                ShoppingCart shoppingCart=new ShoppingCart();
        for (Long id:cartids) {
            shoppingCart.setId(id);
            list.add(shoppingCart);
        }
         try{
             int result=shoppingcartService.deleteByList(list);
             return  new JsonResult("200",result);
         }catch (Exception e){
             return  new JsonResult("500",e.getMessage());
         }


    }




}
