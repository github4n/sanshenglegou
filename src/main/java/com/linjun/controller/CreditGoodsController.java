package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.Creditgoods;
import com.linjun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.interpreter.BytecodeGetPut;
import sun.plugin2.message.JavaScriptBaseMessage;

import java.util.List;

@RestController
@RequestMapping(value = "/credit")
public class CreditGoodsController {
    @Autowired
    AdminService adminService;
    @Autowired
    StoreService storeService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    CollectService collectService;
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
    @Autowired
    InComeService inComeService;
    @Autowired
    OutComeService outComeService;
    @Autowired
    MemberApplyService memberApplyService;
    @Autowired
    VillageApplyService villageApplyService;
    @Autowired
    StoreApplyService storeApplyService;
    @Autowired
    WithDrawApplyService withDrawApplyService;
    @Autowired
    CreditMangerService creditMangerService;
    @Autowired
    ShoppingcartService shoppingcartService;
    @Autowired
    CreditDetialService creditDetialService;
    @Autowired
    CreditGoodsService creditGoodsService;

//    获取全部积分商品
    @GetMapping(value = "/getcreditgoods")
    public JsonResult getcreditgoods(){
        try{
            List<Creditgoods> list=creditGoodsService.findall();
            return  new JsonResult("200",list);
        }catch (Exception e){
            return new JsonResult("500",e.getMessage());
        }
    }
//    更新积分商品
    @PutMapping(value = "/updatecreditgoods")
    public  JsonResult updatecreditgoods(
            @RequestBody Creditgoods creditgoods
    ){
        try{
            Creditgoods creditgoods1=creditGoodsService.update(creditgoods);
            return  new JsonResult("200",creditgoods1);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }
//删除积分商品
    @DeleteMapping(value = "/deletecreditgods")
    public  JsonResult deletecreditgods(
            @RequestParam(value = "creditgoodsid")Long creditgoodsid
    ){
        try{
            Creditgoods creditgoods=new Creditgoods();
            creditgoods.setId(creditgoodsid);
            int result=creditGoodsService.delete(creditgoods);
            return  new JsonResult("200",result);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }
//    分页获取商品列表
    @GetMapping(value = "/getcregoodsall")
    public JsonResult getcregoodsall(
            @RequestParam(value = "page",required = false)int page,
            @RequestParam(value = "page",required = false)int pagesize
    ){
          try{
              PageBean<Creditgoods> list=creditGoodsService.findBypage(page,pagesize);
              return  new JsonResult("200",list);

          }catch (Exception e){
              return  new JsonResult("500",e.getMessage());
          }
    }
//    获取积分商品详情
    @GetMapping(value = "/getcregoodsdetail")
    public  JsonResult getcregoodsdetail(
            @RequestParam(value = "creditgoodsid") long creditgoodsid
    ){
             try{
                 Creditgoods creditgoods =creditGoodsService.finbyid(creditgoodsid);
                 return  new JsonResult("200",creditgoods);
             }catch ( Exception e){
                 return  new JsonResult("500",e.getMessage());
             }
    }

}
