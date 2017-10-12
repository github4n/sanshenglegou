package com.linjun.controller;

import com.github.pagehelper.PageHelper;
import com.linjun.common.JsonResult;

import com.linjun.entity.PageBean;
import com.linjun.model.User;
import com.linjun.model.UserDetail;
import com.linjun.service.UserDetailService;
import com.linjun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value ="/user")
public class UserController {
 @Autowired
 UserService userService;
 @Autowired
 UserDetailService userDetailService;
 @PutMapping(value = "/register")
 public JsonResult register(@RequestParam(value = "username",required = false)String username,
                            @RequestParam(value = "password",required = false)String password,
                            @RequestParam(value = "token",required =false)String token,
                            @RequestParam(value = "tel",required = false)String tel,
                            @RequestParam(value = "ip",required = false)String ip){
  try {
   User user = new User();
   UserDetail userDetail = new UserDetail();
   user.setUsername(username);
   user.setCreatetime(new Date());
   user.setPassworld(password);
   user.setLogin(new Date());
   user.setIp(ip);
   userDetail.setTel(tel);
   userService.add(user);
   userDetailService.add(userDetail);
   return new JsonResult("200", "注册成功",user);
  }catch (Exception e){
   return new JsonResult("500",e.getMessage());
  }
 }
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


}
