package com.linjun.controller;


import com.linjun.common.JsonResult;
import com.linjun.config.QiNiuconfig;
import com.linjun.entity.PageBean;
import com.linjun.model.Banner;
import com.linjun.service.BannerService;

import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

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
    //   首页轮播图的添加
    @PostMapping(value = "/uploadBanner")
    public JsonResult uploadBanner(
            @RequestParam(value = "status")byte status,
            @RequestParam(value = "file") MultipartFile files) throws ParseException
            {

                String filePath = "/Users/linjun/deaProjects/image/";
                String fileName = files.getOriginalFilename();
                String stuffxName = fileName.substring(fileName.lastIndexOf("."));
                fileName = UUID.randomUUID() + stuffxName;
                fileName = System.currentTimeMillis() + fileName;
                String a= String.valueOf(new Date());
                SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String b=sdf2.format(sdf1.parse(a));
                Date date=sdf2.parse(b);
                Banner banner=new Banner();
                banner.setImageurl(fileName);
                banner.setIsstart(status);
                Auth auth=Auth.create(QiNiuconfig.accessKey,QiNiuconfig.secretKey);
                String upToken=auth.uploadToken(QiNiuconfig.bucket);
                UploadManager uploadManager=new UploadManager(new Configuration(Zone.zone0()));

                File dest = new File(filePath + fileName);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    files.transferTo(dest);
                    Response response=uploadManager.put(dest,fileName,upToken);

                    Banner banner1=bannerService.add(banner);
                    return  new JsonResult("200",banner);
                } catch (IOException e) {
                    return  new JsonResult("500",e.getMessage());
                }
    }

}
