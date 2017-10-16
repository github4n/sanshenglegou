package com.linjun.controller;

import com.github.pagehelper.PageHelper;
import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.*;
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
       PageHelper.startPage(page,10);
       return new JsonResult("200",new PageBean<Order>(orders));
   }
//查询店铺的订单
   @GetMapping(value = "/queryOrder")
    public  JsonResult queryOrder(
      @RequestParam(value = "storeID",required = false)long storeID,
      @RequestParam(value = "page",required = false)int page
   ){
                List<Order> orderList=orderService.queryOrder(storeID);
                OrderList orderList1=new OrderList();
       List<OrderList> lists=new ArrayList<OrderList>();
       for (Order list:orderList) {
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
       PageHelper.startPage(page,10);
       List<OrderList> list= (List<OrderList>) new PageBean<OrderList>(lists);


       return new JsonResult("200",list) ;

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



}
