package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
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

}
