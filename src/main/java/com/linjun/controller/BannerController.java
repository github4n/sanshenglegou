package com.linjun.controller;


import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.Banner;
import com.linjun.service.BannerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/banner")
public class BannerController {
    @Autowired
    BannerService bannerService;
//    获取轮播图列表
    @GetMapping(value = "/getbanner")
    public JsonResult getBanner(
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
      try{
          PageBean<Banner> list=bannerService.findAll(page,pagesize);
          return  new JsonResult("200",list);
      }catch (Exception e){
          return  new JsonResult("500",e.getMessage());
      }

    }
//修改轮播图状态
    @PutMapping(value ="/updateBanner")
    public  JsonResult updateBanner(
            @RequestBody Banner banner
    ){
          try {
              Banner banner1=bannerService.update(banner);
              return  new JsonResult("200",banner1);


          }catch (Exception e){
              return  new JsonResult("500",e.getMessage());
          }

    }
//删除轮播图
    @DeleteMapping(value = "/deletebaner")
    public  JsonResult deletebanner(
            @RequestParam(value = "id")long id
    ){

               try{
                   int result=bannerService.deletebanner(id);
  return  new JsonResult("200",result);
               }catch (Exception e){
                   return  new JsonResult("500",e.getMessage());
               }
    }

}
