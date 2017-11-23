package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.MemberApply;
import com.linjun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
        return  new JsonResult("200",list);
    }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
    }


}





}
