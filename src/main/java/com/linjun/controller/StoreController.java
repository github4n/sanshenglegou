package com.linjun.controller;

import com.github.pagehelper.PageHelper;
import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.*;
import com.linjun.pojo.GoodsList;
import com.linjun.pojo.OrderList;
import com.linjun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/store")
@RestController
public class StoreController {
    @Autowired
    StoreService storeService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    AddressMongerService addressMongerService;
    @Autowired
    GoodsImageService goodsImageService;
    @Autowired
    GoodsTypeService goodsTypeService;

//    店铺注册
    @PostMapping(value = "/register")
    public JsonResult register(
            @RequestBody Store store
    ){
        try {
          Store store1=  storeService.createStore(store);
            return new JsonResult("200",store1);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }

    }
//    店铺注销
    @DeleteMapping(value = "/delete")
    public  JsonResult delete(
       @RequestParam(value = "userid",required = false)long userid
    ){
       try {
           return new JsonResult("200",storeService.deleteByuserid(userid));
       }catch (Exception e){
           return new JsonResult("500",e.getMessage());
       }

    }

//通过id登入店铺
    @GetMapping(value = "/loginByid")
    public  JsonResult loginByid(
            @RequestParam(value = "id",required = false)long id,
            @RequestParam(value = "password",required = false)String password
    ){
           try{
               Store store=new Store();
               store.setId(id);
               store.setPassworld(password);
            Store store1=   storeService.loginByid(store);
               return new JsonResult("200",store1);
           }catch (Exception e){
               return  new JsonResult("500",e.getMessage());
           }

    }
//    通过手机号码登入店铺
    @PostMapping(value = "/loginByPhone")
    public JsonResult loginByPhone(
            @RequestBody String phone,
            @RequestBody String passworld
    ){
      try{
          Store store=new Store();
          store.setTel(phone);
          store.setPassworld(passworld);
          Store store1=storeService.loginByPhone(store);
          return new JsonResult("200",store1);

      }catch (Exception e){
       return  new JsonResult("500",e.getMessage());
      }
    }


//    店铺的登入
    @GetMapping(value = "/login")
    public  JsonResult login(
            @RequestParam(value = "username",required = false)String username,
            @RequestParam(value = "password",required = false)String password
    ){
        boolean a=userService.isExits(username,password);
        if (a){
           User user=userService.findByusername(username);
           if (storeService.findBystoreid(user.getId())!=null){
               return new JsonResult("200","登入成功");
            }else {
               return new JsonResult("500","你未注册店铺");
           }
        }else {
            return new JsonResult("600","用户名不存在");
        }
    }
//    店铺资料更新
   @PutMapping(value = "/update")
    public  JsonResult update(
           @RequestBody Store store
   ){
        try{
           storeService.updateStore(store);
            return new JsonResult("200",store);
        }catch (Exception e){
          return  new JsonResult("500",e.getMessage());
        }
   }
   @GetMapping(value = "/orderAll")
    public JsonResult queryOrderAll(
            @RequestParam(value = "page",required = false)int page
   ){
    List<Order> orders= orderService.findAll();

       return new JsonResult("200",orders);
   }

//查询店铺的订单
   @GetMapping(value = "/queryOrder")
    public  JsonResult queryOrder(
      @RequestParam(value = "storeID",required = false)long storeID,
      @RequestParam(value = "page",required = false)int page
   ){
                try{

                    PageBean<Order> orderList=orderService.findAllOStore(storeID,page,10);
                    OrderList orderList1=new OrderList();
                    List<OrderList> lists=new ArrayList<OrderList>();
                    for (Order list:orderList.getList()) {
                        orderList1.setId(list.getId());
                        orderList1.setIspay(list.getIspay());
                        orderList1.setOrderCode(list.getOrdercode());
                        orderList1.setAmount(list.getGoodsum());
                        orderList1.setPeople(addressMongerService.findbyid(list.getAddressid()).getReceivepeople());
                        orderList1.setTel(addressMongerService.findbyid(list.getAddressid()).getReceivetel());
                        orderList1.setPrice(list.getMemberprice());
                        orderList1.setStorename(list.getGoodsname());
                        orderList1.setPricesum(list.getPricesum());
                        orderList1.setSendtime(list.getSendtime());
                        lists.add(orderList1);
                }
                PageBean<OrderList> orderli=new PageBean<OrderList>(orderList.getTotal(),orderList.getPageNum(),orderList.getPageSize(),orderList.getPages(),orderList.getSize(),lists);
                    return new JsonResult("200",orderli);
       }catch (Exception e){
                    return  new JsonResult("500",e.getMessage());
                }

   }

//上架商品
    @PostMapping(value = "/addGoods")
    public JsonResult addGoods(
            @RequestBody Goods goods
            ){
          try{
              Goods goods1=goodsService.addGoods(goods);
              return new JsonResult("200",goods1);
          }catch (Exception e){
              return  new JsonResult("500",e.getMessage());
          }
    }
//店铺的商品
    @GetMapping(value = "/getGoods")
    public  JsonResult getGoods(
            @RequestParam(value = "storeID",required = false)long storeID,
            @RequestParam(value = "page",required = false)int page){
                List<Goods> list=goodsService.findByStoreID(storeID);
              List<GoodsList> goodsLists=new ArrayList<GoodsList>();
              GoodsList storedata=new GoodsList();
       try {
           for (Goods data : list) {
               storedata.setId(data.getId());
               storedata.setGoodsName(data.getGoodsname());
               storedata.setImageAddress(goodsImageService.findMainImage(data.getId()).getIamgeaddress());
               storedata.setIsstart(data.getIsstart());
               storedata.setMarketPrice(data.getMarketprive());
               storedata.setMemberPrice(data.getMemberprice());
               storedata.setSoldamount(data.getSoldamount());
               storedata.setTypeName(goodsTypeService.findById(data.getTypeid()).getTypename());
               goodsLists.add(storedata);
           }

     return  new JsonResult("200",storedata);
       }catch (Exception e){
           return  new JsonResult("500",e.getMessage());
       }
    }
//    获取今日订单 今日成交订单的数量
 @GetMapping(value = "/getTodayOrder")
 public  JsonResult getTodayOrder(
         @RequestParam(value = "storeID")long storeID
 ) {
     List<Integer> list = orderService.getTodayOrder(storeID);
     if (list != null) {
         return new JsonResult("200", list);
     } else {
         return new JsonResult("500", "失败");
     }
 }
//  一周的订单量
     @GetMapping(value = "/getWeekDayOrder")
    public  JsonResult getWeekDayOrder(
           @RequestParam(value = "storeID")long storeID
             ){
         try{
        int[] weekday= orderService.getWeekDayOrder(storeID);
        return  new JsonResult("200",weekday);
         }catch (Exception e){
             return  new JsonResult("500","失败");
         }

     }




}
