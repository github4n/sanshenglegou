package com.linjun.controller;

import com.github.pagehelper.PageHelper;
import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.Goods;
import com.linjun.model.Order;
import com.linjun.model.Store;
import com.linjun.model.User;
import com.linjun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
       PageHelper.startPage(page,10);
       List<Order> list= (List<Order>) new PageBean<Order>(orderList);
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
