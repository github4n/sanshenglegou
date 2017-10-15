package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.model.Goods;
import com.linjun.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @GetMapping(value = "/mainStore")
    public JsonResult mainStore(){
        try{
         List<Goods> list= goodsService.mainstore();
         return new JsonResult("200",list);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }

    }
    @GetMapping(value = "/yiwu")
    public JsonResult yiwu(){
       try{
         List<Goods> list=goodsService.yiwu();
         return  new JsonResult("200",list);
       }catch (Exception e){
           return  new JsonResult("500",e.getMessage());
       }
    }
    @GetMapping(value = "/composite")
    public  JsonResult composite(){
        try{
            List<Goods> list=goodsService.composite();
           return new JsonResult("200",list);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }

    }
    @GetMapping(value = "/villages")
    public JsonResult villages(){
        try{
        List<Goods> list=goodsService.Villages();
        return  new JsonResult("200",list);
        }catch (Exception e){
         return new JsonResult("500",e.getMessage())   ;
        }
    }

}
