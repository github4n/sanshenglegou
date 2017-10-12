package com.linjun.controller;

import com.github.pagehelper.PageHelper;
import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.Order;
import com.linjun.model.Store;
import com.linjun.model.User;
import com.linjun.service.OrderDetailService;
import com.linjun.service.OrderService;
import com.linjun.service.StoreService;
import com.linjun.service.UserService;
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
    @PostMapping(value = "/register")
    public JsonResult register(
            @RequestParam(value = "storeName",required = false)String storeName,
            @RequestParam(value = "storeAddress",required = false)String storeAddress,
            @RequestParam(value = "storeType",required = false)String storeType,
            @RequestParam(value = "storer",required = false)String storer,
            @RequestParam(value = "scope",required = false)String scope,
            @RequestParam(value = "introduce",required = false)String introduce,
            @RequestParam(value = "storeUserID",required = false)long storeUserID,
            @RequestParam(value = "tel",required = false)String tel
    ){
        try {
            Store store = new Store();
            store.setCreatetime(new Date());
            store.setIntroduce(introduce);
            store.setScope(scope);
            store.setStoreaddress(storeAddress);
            store.setStoretype(storeType);
            store.setStorer(storer);
            store.setStorename(storeName);
            User user = userService.findByKey(storeUserID);
            store.setPassworld(user.getPassworld());
            store.setTel(tel);
            return new JsonResult("200",store);
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
   @PutMapping(value = "/update")
    public  JsonResult update(
            @RequestParam(value = "id",required = false)long id,
           @RequestParam(value = "storeAddress",required = false)String storeAddress,
           @RequestParam(value = "storeType",required = false)String storeType,
           @RequestParam(value = "scope",required = false)String scope,
           @RequestParam(value = "introduce",required = false)String introduce,
           @RequestParam(value = "tel",required = false)String tel
   ){
        try{
            Store store=new Store();
            store.setTel(tel);
            store.setStoretype(storeType);
            store.setStoreaddress(storeAddress);
            store.setScope(scope);
            store.setIntroduce(introduce);
            storeService.updatebyid(id,store);
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


}
