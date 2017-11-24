package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.*;
import com.linjun.pojo.OrderListAdmin;
import com.linjun.service.*;
import com.qiniu.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.debugger.Page;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//搜索类
@RestController
@RequestMapping(value = "/search")
public class SearchController {
    @Autowired
    AdminService adminService;
    @Autowired
    StoreService storeService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;

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

//    会员申请搜索
@GetMapping(value = "/searchMember")
    public JsonResult searchMember(
            @RequestParam(value = "condition") String condition,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize

){
    try{
        PageBean<MemberApply> list=memberApplyService.findBy(condition,page,pagesize);
        System.out.println(list);
        return  new JsonResult("200",list);
    }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
    }
}
//会员状态搜索
    @GetMapping(value = "/searchMenberStatus")
   public  JsonResult searchMemberStatus(
            @RequestParam(value = "condition") String condition,
            @RequestParam(value = "status")byte status,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
                try{
                    PageBean<MemberApply> list=memberApplyService.findByStatus(condition,status,page,pagesize);

                    return  new JsonResult("200",list);
                }catch (Exception e){
                    return  new JsonResult("500",e.getMessage());
                }
    }
//商城申请搜索
    @GetMapping(value = "/searchStoreApply")
    public  JsonResult searchStoreApply(
            @RequestParam(value = "condition") String condition,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
        try{
            PageBean<StoreApply> list =storeApplyService.search(condition,page,pagesize);
            return  new JsonResult("200",list);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }
//    商城状态申请
    @GetMapping(value = "/searchStoreApplyStatus")
    public JsonResult searchStoreAStatus(
            @RequestParam(value = "condition") String condition,
            @RequestParam(value = "status")byte status,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
             try{
                 PageBean<StoreApply> list =storeApplyService.searchByStatus(condition,status,page,pagesize);
                 return  new JsonResult("200",list);
             }catch (Exception e){
                 return  new JsonResult("500",e.getMessage());
             }
    }
//    村村通申请搜索
    @GetMapping(value = "/searchVillage")
    public  JsonResult searchVillage(
            @RequestParam(value = "condition") String condition,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
          try{
             PageBean<VillageApply> list=villageApplyService.search(condition,page,pagesize);
              return new JsonResult("200",list);
          }catch (Exception e){
              return  new JsonResult("500",e.getMessage());
          }
    }
//    村村通申请状态搜索
    @GetMapping(value = "/searchVillageStatus")
    public  JsonResult searchVillageStatus(
            @RequestParam(value = "condition") String condition,
            @RequestParam(value = "status")byte status,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
         try{
             PageBean<VillageApply> list=villageApplyService.searchByStatus(condition,status,page,pagesize);
             return  new JsonResult("200",list);
         }catch (Exception e){
             return  new JsonResult("500",e.getMessage());
         }
    }
//    提现申请搜索
    @GetMapping(value = "/searchWithDraw")
    public JsonResult searchWithDraw(
            @RequestParam(value = "condition") String condition,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
                try{
                   PageBean<WithDrawApply> list=withDrawApplyService.search(condition,page,pagesize);
                   return  new JsonResult("200",list);

                }catch (Exception e){
                    return  new JsonResult("500",e.getMessage());
                }

    }
//提现申请状态搜索
    @GetMapping(value = "/searchWithDraw")
    public  JsonResult searchWithDraw(
            @RequestParam(value = "condition") String condition,
            @RequestParam(value = "status")byte status,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
          try {
              PageBean<WithDrawApply> list=withDrawApplyService.searchByStatus(condition,status,page,pagesize);
              return  new JsonResult("200",list);

          }catch (Exception e){
              return new JsonResult("500",e.getMessage());
          }
    }
//收入搜索
    @GetMapping(value = "/searchIncome")
    public  JsonResult searchIncome(
            @RequestParam(value = "condition") Object condition,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
         try{
            PageBean<Income> list=inComeService.search(condition,page,pagesize);
            return  new JsonResult("200",list);
         }catch (Exception e){
             return  new JsonResult("500",e.getMessage());
         }
    }
//收入状态搜索
    @GetMapping(value = "/searchIncomeStatus")
    public  JsonResult searchIncomStatus(
            @RequestParam(value = "condition") Object condition,
            @RequestParam(value = "status")byte status,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
       try{
           PageBean<Income> list=inComeService.searchByStatus(condition,status,page,pagesize);
           return  new JsonResult("200",list);
       }catch (Exception e){
           return  new JsonResult("500",e.getMessage());
       }
    }
//支出搜索
    @GetMapping(value = "/searchOutcome")
    public  JsonResult searchOutcome(
            @RequestParam(value = "condition") Object condition,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
  try{
      PageBean<Outcome> list=outComeService.search(condition,page,pagesize);
      return  new JsonResult("200",list);
  }catch (Exception e){
      return  new JsonResult("500",e.getMessage());
  }
    }
// 支出状态搜索
    @GetMapping(value = "/searchOutcomeStatus")
    public  JsonResult searchOutcomeStatus(
            @RequestParam(value = "condition") Object condition,
            @RequestParam(value = "status")byte status,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
        try{
            PageBean<Outcome> list=outComeService.searchByStatus(condition,status,page,pagesize);
            return  new JsonResult("200",list);

        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }
//    订单搜索
    @GetMapping(value = "/searchOrder")
    public JsonResult searchOrder(
            @RequestParam(value = "condition") Long condition,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
        PageBean<Order> orderList=orderService.search(condition,page,pagesize);
        List<OrderListAdmin> list=new ArrayList<OrderListAdmin>();
          try{

                  for (Order data:orderList.getList()) {
                      OrderListAdmin orderListAdmin=new OrderListAdmin();
                      orderListAdmin.setGoodsName(data.getGoodsname());
                      orderListAdmin.setAcount(data.getGoodsum());
                      orderListAdmin.setAddress(addressMongerService.findByUseridDefault(data.getUserid()).getAddressdetail());
                      orderListAdmin.setAllPrice(data.getPricesum());
                      SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                      orderListAdmin.setCreateTime(df.format(data.getCreatetime()));
                      orderListAdmin.setSendTime(df.format(data.getSendtime()));
                      orderListAdmin.setPayTime(df.format(data.getPaytime()));
                      orderListAdmin.setCompletTime(df.format(data.getCompletetime()));
                      orderListAdmin.setCancelTime(df.format(data.getCancel()));
                      orderListAdmin.setOrderCode(data.getOrdercode());
                      int a=userService.findByID(data.getUserid()).getRole();
                      if (a==1){
                          orderListAdmin.setPrice(data.getMemberprice());
                      }else {
                          orderListAdmin.setPrice(data.getMarketpricce());
                      }
                      orderListAdmin.setRevierPeople(addressMongerService.findByUseridDefault(data.getUserid()).getReceivepeople());
                      orderListAdmin.setTel(addressMongerService.findByUseridDefault(data.getUserid()).getReceivetel());
                      orderListAdmin.setId(data.getId());
                      orderListAdmin.setStorer(storeService.findByid(data.getUserid()).getStorer());
                      orderListAdmin.setStoreid(data.getUserid());
                      orderListAdmin.setStatus(data.getIspay());


                      list.add(orderListAdmin);
                  }
                 return new JsonResult("200",list);
          }catch (Exception e){
              return  new JsonResult("500",e.getMessage());
          }
    }
//   订单状态搜索
    @GetMapping(value = "/searchOrderStatus")
    public  JsonResult searchOrderStatus(
            @RequestParam(value = "condition") Long condition,
            @RequestParam(value = "status")byte status,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){

        PageBean<Order> orderList=orderService.searchByStatus(condition,status,page,pagesize);
        List<OrderListAdmin> list=new ArrayList<OrderListAdmin>();
        try{
            for (Order data:orderList.getList()) {
                OrderListAdmin orderListAdmin=new OrderListAdmin();
                orderListAdmin.setGoodsName(data.getGoodsname());
                orderListAdmin.setAcount(data.getGoodsum());
                orderListAdmin.setAddress(addressMongerService.findByUseridDefault(data.getUserid()).getAddressdetail());
                orderListAdmin.setAllPrice(data.getPricesum());
                SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                orderListAdmin.setCreateTime(df.format(data.getCreatetime()));
                orderListAdmin.setSendTime(df.format(data.getSendtime()));
                orderListAdmin.setPayTime(df.format(data.getPaytime()));
                orderListAdmin.setCompletTime(df.format(data.getCompletetime()));
                orderListAdmin.setCancelTime(df.format(data.getCancel()));
                orderListAdmin.setOrderCode(data.getOrdercode());
                int a=userService.findByID(data.getUserid()).getRole();
                if (a==1){
                    orderListAdmin.setPrice(data.getMemberprice());
                }else {
                    orderListAdmin.setPrice(data.getMarketpricce());
                }
                orderListAdmin.setRevierPeople(addressMongerService.findByUseridDefault(data.getUserid()).getReceivepeople());
                orderListAdmin.setTel(addressMongerService.findByUseridDefault(data.getUserid()).getReceivetel());
                orderListAdmin.setId(data.getId());
                orderListAdmin.setStorer(storeService.findByid(data.getUserid()).getStorer());
                orderListAdmin.setStoreid(data.getUserid());
                orderListAdmin.setStatus(data.getIspay());


                list.add(orderListAdmin);
            }
            return new JsonResult("200",list);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }
//    商品搜索
    @GetMapping(value = "/searchGoods")
    public  JsonResult searchGoods(
            @RequestParam(value = "condition") Object condition,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
          try{
            PageBean<Goods> list=goodsService.search(condition,page,pagesize);
            return  new JsonResult("200",list);
          }catch (Exception e){
              return  new JsonResult("500",e.getMessage());
          }

    }
//  商品状态搜索
    @GetMapping(value = "/searchGoodsStatus")
    public  JsonResult searchGoodStatus(
            @RequestParam(value = "condition") Object condition,
            @RequestParam(value = "status")byte status,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
         try{
             PageBean<Goods> list=goodsService.searchByStatus(condition,status,page,pagesize);
             return  new JsonResult("200",list);
         }catch (Exception e){
             return  new JsonResult("500",e.getMessage());
         }
    }
//    用户状态的搜索

}
