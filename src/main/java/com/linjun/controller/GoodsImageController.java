package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.model.GoodsImage;
import com.linjun.service.GoodsImageService;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
@RequestMapping(value = "/filerquire")
@RestController
public class GoodsImageController {
    @Autowired
    GoodsImageService goodsImageService;
   @PostMapping(value = "")
   public JsonResult upload(
           @RequestParam("goodsID")long goodsID,
           @RequestParam("iskey")int key,
           @RequestParam("file")MultipartFile file){
       if (file.isEmpty()){
           return new JsonResult("500","文件为空");
       }
      String fileName=file.getOriginalFilename();
       String suffix=fileName.substring(fileName.lastIndexOf("."));
       String filepath="E://text//";
       File dest=new File(filepath+fileName);
       if (!dest.getParentFile().exists()){
           dest.getParentFile().mkdirs();
       }
       try{
           file.transferTo(dest);
          GoodsImage goodsImage=new GoodsImage();
          goodsImage.setCreatetime(new Date());
          goodsImage.setIamgeaddress(filepath+fileName);
          goodsImage.setGoodsid(goodsID);
          goodsImage.setIskeyiamge((byte) key);
        boolean a=goodsImageService.add(goodsImage);
        if (a){
            return new JsonResult("200","文件上传成功");
        }
           return new JsonResult("300","文件存储失败");

       }catch (IllegalStateException e){
           e.printStackTrace();
       }catch (Exception e){
           e.printStackTrace();
       }
       return new JsonResult("600","文件上传失败");
   }




}
