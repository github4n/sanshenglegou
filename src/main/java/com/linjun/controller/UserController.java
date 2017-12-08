package com.linjun.controller;

import com.linjun.common.JsonResult;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.ShoppingCartMapper;
import com.linjun.model.*;
import com.linjun.pojo.Address;
import com.linjun.pojo.Cart;
import com.linjun.pojo.GoodsModel;
import com.linjun.pojo.Ordermodel;
import com.linjun.service.*;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.oops.LongField;


import javax.xml.bind.util.JAXBSource;
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
      CollectService collectService;
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

//根据id值获取地址
    @GetMapping(value = "/getAddressid")
    public JsonResult getAddressid(
            @RequestParam(value = "addressid")long addressid
    ){
     try{
         AddressManger addressManger=addressMongerService.findbyid(addressid);
         return  new JsonResult("200",addressManger);
     }catch (Exception e){
         return  new JsonResult("500",e.getMessage());
     }
    }



//  用户信息获取
 @GetMapping(value = "/getUserInformation")
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
  @RequestParam(value = "userid")long userid,
  @RequestParam(value = "storeid")long storeid,
  @RequestParam(value = "goodsid")long goodsid,
  @RequestParam(value = "addressid")long addressid,
  @RequestParam(value = "goodsum")int goodsum
 ) throws ParseException {
     try{
     Order order=new Order();
     order.setIspay((byte) 0);
     order.setUserid(userid);
     order.setStoreid(storeid);
     order.setGoodsid(goodsid);
     order.setAddressid(addressid);
     order.setGoodsum(goodsum);
     String a= String.valueOf(new Date());
     SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
     SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     String b=sdf2.format(sdf1.parse(a));
     Date date=sdf2.parse(b);
    order.setCreatetime(date);
     Goods goods=goodsService.findByid(goodsid);
     order.setGoodsname(goods.getGoodsname());
     Float marketprice=goods.getMarketprive();
      order.setMarketpricce(marketprice);
      Float memberprice=goods.getMemberprice();
      order.setMemberprice(memberprice);
      long times=new Date().getTime();
      order.setOrdercode(times);
      byte isrole=userService.findByID(userid).getRole();
      Float pricesum;
      if (isrole==0){
          pricesum=goodsum*marketprice;
      }else {
          pricesum=goodsum*memberprice;
      }
         order.setPricesum(pricesum);
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
    @PostMapping(value = "/addAdressManger")
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
    @DeleteMapping(value = "/deleteAddress")
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
               List<Ordermodel> orderlist=new ArrayList<Ordermodel>();
               Ordermodel ordermodel=new Ordermodel();
               for (Order data:list) {
                   ordermodel.setAddressid(data.getAddressid());
                   ordermodel.setCancel(data.getCancel());
                   ordermodel.setCompletetime(data.getCompletetime());
                   ordermodel.setCreatetime(data.getCreatetime());
                   ordermodel.setGoodiamge(goodsImageService.findMainImage(data.getGoodsid()).getIamgeaddress());
                   ordermodel.setGoodsname(data.getGoodsname());
                   ordermodel.setIspay(data.getIspay());
                   ordermodel.setGoodsum(data.getGoodsum());
                   ordermodel.setUserid(data.getUserid());
                   ordermodel.setPricesum(data.getPricesum());
                   ordermodel.setStoreid(data.getStoreid());
                   ordermodel.setSendtime(data.getSendtime());
                   ordermodel.setLogistics(data.getLogistics());
                   ordermodel.setLogisticscode(data.getLogisticscode());
                   ordermodel.setPaytime(data.getPaytime());
                   ordermodel.setMessage(data.getMessage());
                   ordermodel.setOrdercode(data.getOrdercode());
                   ordermodel.setId(data.getId());
                   if (userService.findByID(data.getUserid()).getRole()==1){
                       ordermodel.setPrice(data.getMemberprice());
                   }else{
                       ordermodel.setPrice(data.getMemberprice());
                   }
                   ordermodel.setCreatetime(data.getCreatetime());
                   orderlist.add(ordermodel);
               }



               return new JsonResult("200",orderlist);
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

                   List<Ordermodel> orderlist=new ArrayList<Ordermodel>();
                   Ordermodel ordermodel=new Ordermodel();
                   for (Order data:list) {
                       ordermodel.setAddressid(data.getAddressid());
                       ordermodel.setCancel(data.getCancel());
                       ordermodel.setCompletetime(data.getCompletetime());
                       ordermodel.setCreatetime(data.getCreatetime());
                       ordermodel.setGoodiamge(goodsImageService.findMainImage(data.getGoodsid()).getIamgeaddress());
                       ordermodel.setGoodsname(data.getGoodsname());
                       ordermodel.setIspay(data.getIspay());
                       ordermodel.setGoodsum(data.getGoodsum());
                       ordermodel.setUserid(data.getUserid());
                       ordermodel.setPricesum(data.getPricesum());
                       ordermodel.setStoreid(data.getStoreid());
                       ordermodel.setSendtime(data.getSendtime());
                       ordermodel.setLogistics(data.getLogistics());
                       ordermodel.setLogisticscode(data.getLogisticscode());
                       ordermodel.setPaytime(data.getPaytime());
                       ordermodel.setMessage(data.getMessage());
                       ordermodel.setOrdercode(data.getOrdercode());
                       ordermodel.setId(data.getId());
                       ordermodel.setStorename(storeService.findByid(data.getStoreid()).getStorename());
                       if (userService.findByID(data.getUserid()).getRole()==1){
                           ordermodel.setPrice(data.getMemberprice());
                       }else{
                           ordermodel.setPrice(data.getMemberprice());
                       }
                       ordermodel.setCreatetime(data.getCreatetime());
                       orderlist.add(ordermodel);
                   }

               return new JsonResult("200",orderlist);
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
//获取收藏列表
    @GetMapping(value = "/getcollect")
    public  JsonResult getCollect(
            @RequestParam(value = "userid")Long userid
    ){
       try{

          List<Collect> collect=collectService.findByuserid(userid);
           List<GoodsModel> list=new ArrayList<GoodsModel>();
           for (Collect data:collect) {
               GoodsModel goodsModel=new GoodsModel();

               goodsModel.setGoodsName(goodsService.findByid(data.getGoodsid()).getGoodsname());
               goodsModel.setImageaddress(goodsImageService.findimage(data.getGoodsid()));
               goodsModel.setSoldamount(goodsService.findByid(data.getGoodsid()).getSoldamount());
               goodsModel.setStorename(goodsService.findByid(data.getGoodsid()).getShop());
               goodsModel.setPrice(goodsService.findByid(data.getGoodsid()).getMarketprive());
               goodsModel.setMemberprice(goodsService.findByid(data.getGoodsid()).getMemberprice());
               goodsModel.setId(data.getId());
               goodsModel.setStoreid(goodsService.findByid(data.getGoodsid()).getStoreid());
               goodsModel.setGoodsSum(goodsService.findByid(data.getGoodsid()).getGoodssum());
               goodsModel.setContent(goodsDetailService.findByGoodsid(data.getGoodsid()).getContent());
               list.add(goodsModel);
           }
          return  new JsonResult("200",list);
       }catch (Exception e){
           return new JsonResult("500",e.getMessage());
       }
    }
    @DeleteMapping(value = "/deletecollect")
    public  JsonResult deletecollect(
            @RequestParam(value = "collectid")Long collectid
    ){
        try{
            int result=collectService.deleteByUserid(collectid);
            return  new JsonResult("200",result);
        }catch (Exception e){
            return new JsonResult("500",e.getMessage());
        }
    }
     @PostMapping(value ="/addcollect")
    public JsonResult addcollect(
            @RequestParam(value = "userid")Long userid,
            @RequestParam(value = "goodsid")Long goodsid
     ){
         try{
             Collect collect=new Collect();
             collect.setUserid(userid);
             collect.setGoodsid(goodsid);
             String a= String.valueOf(new Date());
             SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
             SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String b=sdf2.format(sdf1.parse(a));
             Date date=sdf2.parse(b);
             collect.setCreatetime(date);
             Collect collect1=collectService.add(collect);
             return  new JsonResult("200",collect);
         }catch (Exception e){
             return  new JsonResult("500",e.getMessage());
         }
     }
//     得到商品详情页数据
    @GetMapping(value = "/getgoodsdetail")
    public JsonResult getgoodsdetail(
            @RequestParam(value = "goodsid")Long goodsid
    ){
                try{
                    Goods goods=goodsService.findByid(goodsid);
                    GoodsModel goodsModel=new GoodsModel();
                    goodsModel.setStoreid(goods.getStoreid());
                    goodsModel.setGoodsName(goods.getGoodsname());
                    goodsModel.setSoldamount(goods.getSoldamount());
                    goodsModel.setPrice(goods.getMarketprive());
                    goodsModel.setStorename(goods.getShop());
                    goodsModel.setMemberprice(goods.getMemberprice());
                    goodsModel.setGoodsSum(goods.getGoodssum());
                   goodsModel.setImageaddress(goodsImageService.findimage(goodsid));
                   String content=null;
                   try{
                       content=goodsDetailService.findByGoodsid(goodsid).getContent();
                   }catch (Exception e){
                     content=null;
                   }
              goodsModel.setContent(content);
                    goodsModel.setId(goods.getId());
                    return new JsonResult("200",goodsModel);
                }catch (Exception e){
                    return  new JsonResult("500",e.getMessage());
                }

    }


}
