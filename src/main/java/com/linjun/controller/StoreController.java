package com.linjun.controller;

import com.github.pagehelper.PageHelper;
import com.linjun.common.JsonResult;
import com.linjun.config.QiNiuconfig;
import com.linjun.entity.PageBean;
import com.linjun.model.*;
import com.linjun.pojo.GoodsList;
import com.linjun.pojo.OrderList;
import com.linjun.service.*;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequestMapping(value = "/store")
@RestController
public class StoreController {
    @Autowired
    StoreService storeService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    AddressMongerService addressMongerService;
    @Autowired
    GoodsImageService goodsImageService;
    @Autowired
    GoodsTypeService goodsTypeService;

//    店铺注册
    @PostMapping(value = "/register")
    public JsonResult register(
            @RequestBody Store store
    ){
        try {
          Store store1=  storeService.createStore(store);
            return new JsonResult("200",store1);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }

    }
//    店铺注销
    @DeleteMapping(value = "/delete")
    public  JsonResult delete(
       @RequestParam(value = "userid",required = false)long userid
    ){
       try {
           return new JsonResult("200",storeService.deleteByuserid(userid));
       }catch (Exception e){
           return new JsonResult("500",e.getMessage());
       }

    }

//通过id登入店铺
    @GetMapping(value = "/loginByid")
    public  JsonResult loginByid(
            @RequestParam(value = "id",required = false)long id,
            @RequestParam(value = "password",required = false)String password
    ){
           try{
               Store store=new Store();
               store.setId(id);
               store.setPassworld(password);
            Store store1=   storeService.loginByid(store);
               return new JsonResult("200",store1);
           }catch (Exception e){
               return  new JsonResult("500",e.getMessage());
           }

    }
//    通过手机号码登入店铺
    @PostMapping(value = "/loginByPhone")
    public JsonResult loginByPhone(
            @RequestBody String phone,
            @RequestBody String passworld
    ){
      try{
          Store store=new Store();
          store.setTel(phone);
          store.setPassworld(passworld);
          Store store1=storeService.loginByPhone(store);
          return new JsonResult("200",store1);

      }catch (Exception e){
       return  new JsonResult("500",e.getMessage());
      }
    }


//    店铺的登入
    @GetMapping(value = "/login")
    public  JsonResult login(
            @RequestParam(value = "username",required = false)String username,
            @RequestParam(value = "password",required = false)String password
    ){
        boolean a=userService.isExits(username,password);
        if (a){
           User user=userService.findByusername(username);
           if (storeService.findBystoreid(user.getId())!=null){
               return new JsonResult("200","登入成功");
            }else {
               return new JsonResult("500","你未注册店铺");
           }
        }else {
            return new JsonResult("600","用户名不存在");
        }
    }
//    店铺资料更新
   @PutMapping(value = "/update")
    public  JsonResult update(
           @RequestBody Store store
   ){
        try{
           storeService.updateStore(store);
            return new JsonResult("200",store);
        }catch (Exception e){
          return  new JsonResult("500",e.getMessage());
        }
   }
   @GetMapping(value = "/orderAll")
    public JsonResult queryOrderAll(
            @RequestParam(value = "page",required = false)int page
   ){
    List<Order> orders= orderService.findAll();

       return new JsonResult("200",orders);
   }

//查询店铺的订单
   @GetMapping(value = "/queryOrder")
    public  JsonResult queryOrder(
      @RequestParam(value = "storeID",required = false)long storeID,
      @RequestParam(value = "page",required = false)int page
   ){
                try{

                    PageBean<Order> orderList=orderService.findAllOStore(storeID,page,10);
                    List<OrderList> lists=new ArrayList<OrderList>();
                    for (Order list:orderList.getList()) {
                        OrderList orderList1=new OrderList();
                        orderList1.setId(list.getId());
                        orderList1.setIspay(list.getIspay());
                        orderList1.setOrderCode(list.getOrdercode());
                        orderList1.setAmount(list.getGoodsum());
                        orderList1.setPeople(addressMongerService.findbyid(list.getAddressid()).getReceivepeople());
                        orderList1.setTel(addressMongerService.findbyid(list.getAddressid()).getReceivetel());
                        orderList1.setPrice(list.getMemberprice());
                        orderList1.setStorename(list.getGoodsname());
                        orderList1.setPricesum(list.getPricesum());
                        orderList1.setSendtime(list.getSendtime());
                        lists.add(orderList1);
                }
                PageBean<OrderList> orderli=new PageBean<OrderList>(orderList.getTotal(),orderList.getPageNum(),orderList.getPageSize(),orderList.getPages(),orderList.getSize(),lists);
                    return new JsonResult("200",orderli);
       }catch (Exception e){
                    return  new JsonResult("500",e.getMessage());
                }

   }

//上架商品
    @PostMapping(value = "/addGoods")
    public JsonResult addGoods(
            @RequestParam(value = "goodsName") String goodsName,
            @RequestParam(value = "TypeID") long TypeID,
            @RequestParam(value = "goodsSum") long goodsSum,
            @RequestParam(value = "marketPrive") float marketPrive,
            @RequestParam(value = "memberPrive") float memberPrive,
            @RequestParam(value = "storeID") long storeID,
            @RequestParam(value = "soldamount") long soldamount,
            @RequestParam(value = "iamges") MultipartFile files[]
            ) {
          Goods goods=new Goods();
          goods.setGoodsname(goodsName);
          goods.setTypeid(TypeID);
          goods.setCreatetime(new Date());
          goods.setGoodssum(goodsSum);
          goods.setMarketprive(marketPrive);
          goods.setMemberprice(memberPrive);
          goods.setStoreid(storeID);
          goods.setSoldamount(soldamount);
          goods.setShop(storeService.findByid(storeID).getStorename());
            Goods good= goodsService.addGoods(goods);
            if (files.length==0){
                return  new JsonResult("404","图片为空");
            }
            String filePath="/Users/linjun/deaProjects/image/";
        for (int i = 0; i < files.length; i++) {
            String fileName=files[i].getOriginalFilename();
            String stuffxName=fileName.substring(fileName.lastIndexOf("."));
            fileName= UUID.randomUUID()+stuffxName;
            fileName=System.currentTimeMillis()+fileName;
            File dest=new File(filePath+fileName);
            if (!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            Auth auth=Auth.create(QiNiuconfig.accessKey,QiNiuconfig.secretKey);
            UploadManager uploadManager=new UploadManager(new Configuration(Zone.zone0()));
            String uptakon=auth.uploadToken(QiNiuconfig.bucket);
            try {
                Response response=uploadManager.put(dest,fileName,uptakon);
                GoodsImage goodsImage=new GoodsImage();
                goodsImage.setGoodsid(good.getId());
                goodsImage.setCreatetime(new Date());
                goodsImage.setIamgeaddress(fileName);
                if (i==0){
                    goodsImage.setIskeyiamge((byte) 1);
                }else {
                    goodsImage.setIskeyiamge((byte) 0);
                }
                 goodsImageService.add(goodsImage);
                files[i].transferTo(dest);
            } catch (QiniuException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
   return new JsonResult("200","成功");
    }

//    更新商品
//上架商品
@PostMapping(value = "/updateGoods")
public JsonResult addGoods(
        @RequestParam(value ="id") long id,
        @RequestParam(value = "goodsName") String goodsName,
        @RequestParam(value = "TypeID") long TypeID,
        @RequestParam(value = "goodsSum") long goodsSum,
        @RequestParam(value = "marketPrive") float marketPrive,
        @RequestParam(value = "memberPrive") float memberPrive,
        @RequestParam(value = "storeID") long storeID,
        @RequestParam(value = "soldamount") long soldamount,
        @RequestParam(value = "iamges") MultipartFile files[]
) {
    Goods goods=new Goods();
    goods.setId(id);
    goods.setGoodsname(goodsName);
    goods.setTypeid(TypeID);
    goods.setCreatetime(new Date());
    goods.setGoodssum(goodsSum);
    goods.setMarketprive(marketPrive);
    goods.setMemberprice(memberPrive);
    goods.setStoreid(storeID);
    goods.setSoldamount(soldamount);
    goods.setShop(storeService.findByid(storeID).getStorename());
    Goods good= goodsService.addGoods(goods);
    if (files.length==0){
        return  new JsonResult("404","图片为空");
    }
    String filePath="/Users/linjun/deaProjects/image/";
    for (int i = 0; i < files.length; i++) {
        String fileName=files[i].getOriginalFilename();
        String stuffxName=fileName.substring(fileName.lastIndexOf("."));
        fileName= UUID.randomUUID()+stuffxName;
        fileName=System.currentTimeMillis()+fileName;
        File dest=new File(filePath+fileName);
        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        Auth auth=Auth.create(QiNiuconfig.accessKey,QiNiuconfig.secretKey);
        UploadManager uploadManager=new UploadManager(new Configuration(Zone.zone0()));
        String uptakon=auth.uploadToken(QiNiuconfig.bucket);
        try {
            Response response=uploadManager.put(dest,fileName,uptakon);
            GoodsImage goodsImage=new GoodsImage();
            goodsImage.setGoodsid(good.getId());
            goodsImage.setCreatetime(new Date());
            goodsImage.setIamgeaddress(fileName);
            if (i==0){
                goodsImage.setIskeyiamge((byte) 1);
            }else {
                goodsImage.setIskeyiamge((byte) 0);
            }
            goodsImageService.add(goodsImage);
            files[i].transferTo(dest);
        } catch (QiniuException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return new JsonResult("200","成功");
}




//店铺的商品
    @GetMapping(value = "/getGoods")
    public  JsonResult getGoods(
            @RequestParam(value = "storeID",required = false)long storeID,
            @RequestParam(value = "page",required = false)int page){
                PageBean<Goods>  goodslist=goodsService.findBySID(storeID,page,10);
             List<GoodsList> goodsLists=new ArrayList<GoodsList>();
       try {
           for (Goods data : goodslist.getList()) {
               GoodsList storedata=new GoodsList();
               storedata.setId(data.getId());
               storedata.setGoodsName(data.getGoodsname());
               storedata.setImageAddress("http://oz4zfzmr0.bkt.clouddn.com/"+goodsImageService.findMainImage(data.getId()).getIamgeaddress());
               storedata.setIsstart(data.getIsstart());
               storedata.setMarketPrice(data.getMarketprive());
               storedata.setMemberPrice(data.getMemberprice());
               storedata.setSoldamount(data.getSoldamount());
               storedata.setTypeName(goodsTypeService.findById(data.getTypeid()).getTypename());
               goodsLists.add(storedata);
           }
           PageBean<GoodsList> goodslists=new PageBean<GoodsList>(goodslist.getTotal(),goodslist.getPageNum(),goodslist.getPageSize(),goodslist.getPages(),goodslist.getSize(),goodsLists);
           return  new JsonResult("200",goodslists);
       }catch (Exception e){
           return  new JsonResult("500",e.getMessage());
       }
    }
//    获取今日订单 今日成交订单的数量
 @GetMapping(value = "/getTodayOrder")
 public  JsonResult getTodayOrder(
         @RequestParam(value = "storeID")long storeID
 ) {
     List<Integer> list = orderService.getTodayOrder(storeID);
     if (list != null) {
         return new JsonResult("200", list);
     } else {
         return new JsonResult("500", "失败");
     }
 }
//  一周的订单量
     @GetMapping(value = "/getWeekDayOrder")
    public  JsonResult getWeekDayOrder(
           @RequestParam(value = "storeID")long storeID
             ){
         try{
        int[] weekday= orderService.getWeekDayOrder(storeID);
        return  new JsonResult("200",weekday);
         }catch (Exception e){
             return  new JsonResult("500","失败");
         }

     }
//     订单状态更新
    @PostMapping(value = "/upDataOrder")
   public  JsonResult updataOrder(
         @RequestBody Order order
    ){
               try{
                   Order order1=orderService.updateOrder(order);
                   if (order.getIspay()==1){
                       OrderDetail orderDetail=new OrderDetail();
                       orderDetail.setOrderid(order.getId());
                       orderDetail.setOrderstate("待发货");
                       orderDetailService.add(orderDetail);
                   }
                   return new JsonResult("200",order1);
               }catch (Exception e){
                   return  new JsonResult("500",e.getMessage());
               }
    }
//   更新物流
      @PutMapping(value = "/updateOrderDetail")
    public  JsonResult updateOrderDetail(
            @RequestBody OrderDetail orderDetail
      ){
             try{
                 OrderDetail orderDetail1=orderDetailService.updateOrderDetail(orderDetail);
              return    new JsonResult("200",orderDetail1);
             }catch (Exception e){
              return    new JsonResult("500",e.getMessage());
             }
      }



}
