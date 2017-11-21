package com.linjun.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.*;
import com.linjun.pojo.*;
import com.linjun.service.*;
import com.qiniu.util.Json;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
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


//    管理员登入
    @GetMapping(value = "/login")
    public JsonResult login(@RequestParam(value = "admin",required = false)String admin,
                            @RequestParam(value = "passworld",required = false)String passworld){
        Admin admin1=new Admin();
        admin1.setAccount(admin);
        admin1.setPassworld(passworld);
        try {
            Admin admin2 = adminService.login(admin1);
            return  new JsonResult("200",admin2);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }

    }
//    首页的数据概览
    @GetMapping(value = "/getHeaderData")
    public  JsonResult getHeaderData(){
        try{
            HearData hearData=new HearData();
            hearData.setSumUser(userService.countUser());
            hearData.setSumOrder(orderService.sumOrder());
           hearData.setSumStore(storeService.countStore());
           hearData.setSumMember(userService.countMenber());
           hearData.setMonthMoney(orderService.monthMoney());
           hearData.setMonthOrder(orderService.monthOrder());
           hearData.setMonthMoney(orderService.monthMoney());
           hearData.setMonthOrder(orderService.monthOrder());
           hearData.setMonthvistor(userService.lookuser());
           hearData.setMonthpay(orderService.monthOrder());
          return  new JsonResult("200",hearData);

        }catch (Exception e){
         return new JsonResult("500",e.getMessage());
        }
    }


//    得到所有用户列表
    @GetMapping(value = "/getUserAll")
    public JsonResult getUserAll(@RequestParam(value = "page",required = false)int page,@RequestParam(value = "pageszie")int pagesize){
        try{
            PageBean<User> listall=userService.findUserList(page,pagesize);
            return new JsonResult("200",listall);
        }catch (Exception e){
            return new JsonResult("500",e.getMessage());
        }
    }
//    获取所用用户的概览图数据
    @GetMapping(value = "/getUserAllImage")
    public  JsonResult getUserAllImage(){
        try{
            UserData userData=new UserData();
            long userall=userService.countUser();
             long nowuser=userService.countUserNew();
             List<Integer>  workuser =userService.nowWeekuser();
             List<Integer>  monthuser=userService.nowMonthUser();
             userData.setAlluser(userall);
             userData.setNewuser(nowuser);
             userData.setWeekUser(workuser);
             userData.setMonthUser(monthuser);
             userData.setMonthday(userService.monthDay());
       return  new JsonResult("200",userData);

        }catch (Exception e){
         return  new JsonResult("500",e.getMessage());
        }
    }
//   获取所有的店家列表
    @GetMapping(value = "/getStoreAll")
    public  JsonResult getStoreAll(@RequestParam(value = "page")int page,@RequestParam(value = "pagesize")int pagesize){
        try{
            PageBean<Store> list=storeService.findAllStore(page,pagesize);
            return  new JsonResult("200",list);
        }catch (Exception e){
            return  new JsonResult("500", e.getMessage());
        }
    }
//    获取启用店家列表

    @GetMapping(value = "/getStartStore")
  public  JsonResult getStartStore(
          @RequestParam(value = "page") int page,
          @RequestParam(value = "pagesize")int pagesize
    ){

        try{
            PageBean<Store> list=storeService.findStart(page,pagesize);
   return  new JsonResult("200",list);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }

    }
//获取禁用店家列表
    @GetMapping(value = "/getStopStore")
    public  JsonResult getStopStore(
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize") int pagesize
    ){
              try{
                  PageBean<Store> list=storeService.findShop(page,pagesize);
                  return  new JsonResult("200",list);

              }catch ( Exception e){
                  return  new JsonResult("500",e.getMessage());
              }
    }
//商品类别设置
    @PutMapping(value = "/updateGoodsType")
    public  JsonResult updateGoodsType(
            @RequestBody GoodsType goodsType
    ){
        try{
            GoodsType goodsType1=goodsTypeService.update(goodsType);
            return  new JsonResult("200",goodsType1);

        }catch ( Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }








//    获取所有商品
    @GetMapping(value = "/getGoodsAll")
    public JsonResult getGoodsAll(@RequestParam(value = "page")int page,@RequestParam(value = "pagesise")int pagesize){
            PageBean<Goods> goodslist=goodsService.goodsAll(page,pagesize);
            List<GoodsListAdmin> list=new ArrayList<GoodsListAdmin>();
            try{
                for (Goods data:goodslist.getList()) {
                  GoodsListAdmin admindata=new GoodsListAdmin();
                  admindata.setGoodsname(data.getGoodsname());
                  admindata.setId(data.getId());
                  admindata.setGoodsSum(data.getGoodssum());
                  admindata.setIsstart(data.getIsstart());
                  admindata.setMarketPrice(data.getMarketprive());
                  admindata.setMemberPrice(data.getMemberprice());
                  admindata.setSoldamount(data.getSoldamount());
                  admindata.setStoreid(data.getStoreid());
                  admindata.setStorename(storeService.findByid(data.getId()).getStorename());
                  admindata.setStorer(storeService.findByid(data.getId()).getStorer());
                  String a=null;
                  try{
                      a=goodsImageService.findMainImage(data.getId()).getIamgeaddress();
                  }catch (Exception e){
                      a=null;
                  }
                  admindata.setGoodsimage(a);
                  admindata.setTypeName(goodsTypeService.findById(data.getId()).getTypename());
                    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    admindata.setCreateTime(df.format(data.getCreatetime()));
                    list.add(admindata);
                }
                return new JsonResult("200",list);


            }catch (Exception e){
             return  new JsonResult("500",e.getMessage());
            }
    }


// 得到所有订单
 @GetMapping(value = "/getOrderAll")
    public  JsonResult getOrderAll(
         @RequestParam(value = "page",required = false)int page,
         @RequestParam(value = "page",required = false)int pagesize
 ){

          PageBean<Order> orderList=orderService.findAllOrder(page,pagesize);
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
//    订单概览
    @GetMapping(value = "/getOrderImage")
    public  JsonResult getOrderImage(){
      try{
          OrderData orderData=new OrderData();
            long todayOrder=orderService.todayOrder();
            long todayOrderPay=orderService.toadayOrderPay();
            Float todaymoneyPay=orderService.todayMoney();
            long sumOredr=orderService.sumOrder();
            float sumMoney=orderService.sumMoney();
            List<Float> weeklistOredr=orderService.weekMoney();
            List<Integer> monthOrders=orderService.monthOrder();
            List<Long> weekorderplan=orderService.weekorderPlan();
            orderData.setMoneySum(sumMoney);
            orderData.setMonthMoney(monthOrders);
            orderData.setWeekMoney(weeklistOredr);
            orderData.setNoworder(todayOrder);
            orderData.setNowOrderPay(todayOrderPay);
            orderData.setTodayMoney(todaymoneyPay);
             orderData.setOrderSum(sumOredr);
             orderData.setWeekPlan(weekorderplan);
             orderData.setMonthDay(orderService.monthday());

    return  new JsonResult("200",orderData);
      }catch (Exception e) {
       return  new JsonResult("500",e.getMessage());
      }
    }
//    交易概览
    @GetMapping(value = "/getDealImage")
    public  JsonResult getDealImage(){
        try{
            DealImsgeData dealImsgeData=new DealImsgeData();
            dealImsgeData.setIncome(inComeService.sumincome());
             dealImsgeData.setMoneyDay(inComeService.monthday());
             dealImsgeData.setOutcome(outComeService.sumOutcome());
             dealImsgeData.setTodayincome(inComeService.todayincome());
             dealImsgeData.setTodayoutcome(outComeService.todayOutcome());
             List<Float> list=new ArrayList<Float>();
             list.add(inComeService.monthcome());
             list.add(outComeService.monthMoney());
             dealImsgeData.setMonthcome(list);
             dealImsgeData.setMonthMeneyincome(inComeService.monthincome());
             dealImsgeData.setMonthMeneyoutcome(outComeService.monthMoneys());
             dealImsgeData.setWeekIncome(inComeService.weekincome());
             dealImsgeData.setWeekOutcome(outComeService.weekMoney());
             return  new JsonResult("200",dealImsgeData);

        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }

//收入列表
    @GetMapping(value = "/getIncomeList")
    public  JsonResult getIncomeList(
            @RequestParam(value = "page") int page,@RequestParam(value = "pagesize")int pagesize
    ){
        try{
            PageBean<Income> list=inComeService.findall(page,pagesize);
            return  new JsonResult("200",list);

        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }

    }
//    支出列表
    @GetMapping(value = "/getOutcomeList")
    public  JsonResult getOutcomeList(
            @RequestParam(value = "page")int page,@RequestParam(value = "pagesize")int pagesize
    ){
            try{
                PageBean<Outcome> list=outComeService.findAll(page,pagesize);
                return  new JsonResult("200",list);

            }catch (Exception e){
                return  new JsonResult("500",e.getMessage());
            }

    }
//  会员申请
    @GetMapping(value = "/getMemberApply")
    public JsonResult getMenberApply(
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
              try{
               PageBean<MemberApply> list=memberApplyService.findAll(page,pagesize);
             return  new JsonResult("200",list);
              }catch (Exception e){
                  return  new JsonResult("500",e.getMessage());
              }

    }
//    会员申请更新
    @PutMapping(value = "updateMemberApply")
    public JsonResult update(
            @RequestBody MemberApply memberApply
    ){
       try{
           MemberApply memberApply1=memberApplyService.update(memberApply);
           return  new JsonResult("200",memberApply1);
       }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
       }
    }



//村村通申请
    @GetMapping(value = "/getVillageApply")
    public  JsonResult getVillageApply(
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
         try{
           PageBean<VillageApply> list=villageApplyService.findAll(page,pagesize);
             return  new JsonResult("200",list);
         }catch (Exception e){
             return  new JsonResult("500",e.getMessage());
         }
    }
//    村村通申请更新
    @PutMapping(value = "/updateVillageApply")
    public  JsonResult updateVillageApply(
            @RequestBody VillageApply villageApply
    ){
          try{
              VillageApply villageApply1=villageApplyService.update(villageApply);
              return  new JsonResult("200",villageApply1);
          }catch (Exception e){
              return  new JsonResult("500",e.getMessage());
          }
    }



//商城申请
  @GetMapping(value = "/getStoreApply")
  public JsonResult getStoreApply(
          @RequestParam(value = "page")int page,
          @RequestParam(value = "pagesize") int pagesize
  ){
         try{
             PageBean<StoreApply> list=storeApplyService.findAll(page,pagesize);
             return  new JsonResult("200",list);
         }catch (Exception e){
             return  new JsonResult("500",e.getMessage());
         }
  }
//  商城申请更新
    @PutMapping(value = "/updateStoreApply")
    public  JsonResult updateStoreApply(
            @RequestBody StoreApply storeApply
    ){
       try{
           StoreApply storeApply1=storeApplyService.update(storeApply);
           return  new JsonResult("200",storeApply1);
       }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
       }
    }

//提现申请
    @GetMapping(value = "/getWithDrawApply")
    public  JsonResult getWithDrawApply(
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize
    ){
        try{
            PageBean<WithDrawApply> list=withDrawApplyService.findAll(page,pagesize);
            return  new JsonResult("200",list);
        }catch (Exception e) {
return new JsonResult("500",e.getMessage());
        }
    }
//    提现状态更新
    @PutMapping(value = "/updateWithDrawApply")
    public JsonResult updateWithDrawApply(
            @RequestBody WithDrawApply withDrawApply
    ){
       try{
          WithDrawApply withDrawApply1=withDrawApplyService.update(withDrawApply);
           return  new JsonResult("200",withDrawApply1);
       }catch (Exception e){
           return  new JsonResult("500",e.getMessage());
       }

    }

   @GetMapping(value = "/getstorelist")
    public  JsonResult getstorelist(){
       List<Store> stores=storeService.findAll();
       return  new JsonResult("200",stores);
   }


}
