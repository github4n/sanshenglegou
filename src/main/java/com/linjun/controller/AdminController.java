package com.linjun.controller;

import com.github.pagehelper.PageHelper;
import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.Admin;
import com.linjun.model.Order;
import com.linjun.model.Store;
import com.linjun.model.User;
import com.linjun.service.*;
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
    @Autowired
    LogisticsService logisticsService;
    @Autowired
    GoodsDetailService goodsDetailService;

//    管理员登入
    @GetMapping(value = "/login")
    public JsonResult login(@RequestParam(value = "admin",required = false)String admin,
                            @RequestParam(value = "passworld",required = false)String passworld){
        Admin admin1=new Admin();
        admin1.setAccount(admin);
        admin1.setPassworld(passworld);
        try {
            Admin admin2 = adminService.login(admin1);
            return  new JsonResult("200",admin2);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }

    }
//    得到所有用户列表
    @GetMapping(value = "/getUserAll")
    public JsonResult getUserAll(@RequestParam(value = "page",required = false)int page){
        try{
            PageHelper.startPage(page,10);
            List<User> listall=userService.findAll();
            return new JsonResult("200",listall);
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

          return new JsonResult("200",orderList);
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
//            PageHelper.startPage(page,2);
//            List<Store> storeList=storeService.findAll();


            return  new JsonResult("200",storeService.findAllStore(page,2));
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }
   @GetMapping(value = "/getstorelist")
    public  JsonResult getstorelist(){
       List<Store> stores=storeService.findAll();
       return  new JsonResult("200",stores);
   }


}
