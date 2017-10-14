package com.linjun.controller;

import com.github.pagehelper.PageHelper;
import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.User;
import com.linjun.service.AdminService;
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
}
