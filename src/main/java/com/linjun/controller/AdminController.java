package com.linjun.controller;

import com.github.pagehelper.PageHelper;
import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.Order;
import com.linjun.model.Store;
import com.linjun.model.User;
import com.linjun.service.AdminService;
import com.linjun.service.OrderService;
import com.linjun.service.StoreService;
import com.linjun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    StoreService storeService;

//    管理员登入
    @GetMapping(value = "login")
    public JsonResult login(@RequestParam(value = "admin",required = false)String admin,
                            @RequestParam(value = "passworld",required = false)String passworld){
     boolean a=adminService.IsExits(admin,passworld);
     if (a){
         return  new JsonResult("200","成");
     }else {
         return new JsonResult("500","失败");
     }
    }
//    得到所有用户列表
    @GetMapping(value = "/getUserAll")
    public JsonResult getUserAll(@RequestParam(value = "page",required = false)int page){
        try{
            PageHelper.startPage(page,10);
            List<User> listall=userService.findAll();
            List<User> list= (List<User>) new PageBean<User>(listall);
            return new JsonResult("200",new PageBean<User>(listall));
        }catch (Exception e){
            return new JsonResult("500",e.getMessage());
        }
    }

// 得到所有订单
 @GetMapping(value = "/getOrderAll")
    public  JsonResult getOrderAll(
         @RequestParam(value = "page",required = false)int page

 ){
      try{
          List<Order> orderList=orderService.findAll();
        PageHelper.startPage(page,10);
        List<Order> list= (List<Order>) new PageBean<Order>(orderList);
          return new JsonResult("200",list);
      }catch (Exception e){
          return  new JsonResult("500",e.getMessage());
      }
 }
//  获得所有店铺
    @GetMapping(value = "/getStore")
    public  JsonResult getStore(
            @RequestParam(value = "page",required = false)int page
    ){
        try {
            List<Store> storeList=storeService.findAll();
            PageHelper.startPage(page,10);
            List<Store> list= (List<Store>) new PageBean<Store>(storeList);
            return  new JsonResult("200",list);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }


    }



}
