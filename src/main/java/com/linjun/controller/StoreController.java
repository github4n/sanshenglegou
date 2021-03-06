package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.config.ImageConfig;
import com.linjun.config.QiNiuconfig;
import com.linjun.entity.PageBean;
import com.linjun.model.*;
import com.linjun.pojo.*;
import com.linjun.service.*;
import com.lly835.bestpay.rest.type.Get;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
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
import java.util.*;

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
    WithDrawApplyService withDrawApplyService;
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
//    获取店铺的提现申请
    @GetMapping(value = "/getstorewithdraw")
    public  JsonResult getstorewithdraw(
            @RequestParam(value = "page")int page,
            @RequestParam(value = "pagesize")int pagesize,
            @RequestParam(value = "storeid")long storeid
    ){
            try{
                PageBean<WithDrawApply> list=withDrawApplyService.findAllBystoreid(storeid,page,pagesize);
          return  new JsonResult("200",list);
            }catch (Exception e){
                return  new JsonResult("500",e.getMessage());
            }
    }



//    获取店铺首页的数据
    @GetMapping(value = "/getstorehomedata")
    public  JsonResult getstorehomedata(
            @RequestParam(value = "storeid")long storeid
    ){
       try{
           StoreHeaderData storeHeaderData=new StoreHeaderData();
           storeHeaderData.setTodayorder(orderService.todayOrderstoreid(storeid));
           storeHeaderData.setTodaypay(orderService.todayOrderPaystoreid(storeid));
           storeHeaderData.setOrdersum(orderService.sumOrderstoreid(storeid));
//           Float summoney=orderService.sumMoneystoreid(storeid);
           Float summoney=null;
           try{
               summoney=orderService.sumMoneystoreid(storeid);
           }catch (Exception e){
               summoney=null;
           }


           storeHeaderData.setSummoney(summoney);
           int months=userService.monthDay();
           List<Integer> list=new ArrayList<Integer>();
           for (int i = 1; i <months+1; i++) {
               list.add(i);
           }
           storeHeaderData.setMonth(list);
           storeHeaderData.setWeekpay(orderService.weekMoneystoreid(storeid));
           storeHeaderData.setWeekplan(orderService.weekorderPlanstoreid(storeid));
           storeHeaderData.setMonthorder(orderService.monthOrderstoreid(storeid));
             Float outcome=withDrawApplyService.balance(storeid);
//           storeHeaderData.setBalance(summoney-outcome);
           return new JsonResult("200",storeHeaderData);

       }catch (Exception e){
           return new JsonResult("500",e.getMessage());
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
    @GetMapping(value = "/loginByPhone")
    public JsonResult loginByPhone(
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "passworld")String passworld
    ){
      try{
          Store store=new Store();
          store.setTel(phone);
          store.setPassworld(passworld);
          Store store1=storeService.loginByPhone(store);
          System.out.println(store1.getStorename());
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
      @RequestParam(value = "page",required = false)int page,
      @RequestParam(value = "pagesize",required = false)int pagesize

   ){
                try{

                    PageBean<Order> orderList=orderService.findAllOStore(storeID,page,pagesize);
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
                        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        orderList1.setSendtime(df.format(list.getSendtime()));
                        orderList1.setGoodsName(goodsService.findByid(list.getGoodsid()).getGoodsname());
                        orderList1.setMoney(list.getMemberprice()*list.getGoodsum());
                        lists.add(orderList1);
                }
                PageBean<OrderList> orderli=new PageBean<OrderList>(orderList.getTotal(),orderList.getPageNum(),orderList.getPageSize(),orderList.getPages(),orderList.getSize(),lists);
                    return new JsonResult("200",orderli);
       }catch (Exception e){
                    return  new JsonResult("500",e.getMessage());
                }

   }

//上架商品
    @GetMapping(value = "/addGoods")
    public JsonResult addGoods(
            @RequestParam(value = "goodsname") String goodsName,
            @RequestParam(value = "typeid") long typeID,
            @RequestParam(value = "goodssum") long goodsSum,
            @RequestParam(value = "marketprive") float marketPrive,
            @RequestParam(value = "memberprive") float memberPrive,
            @RequestParam(value = "storeid") long storeID,
            @RequestParam(value = "content")String content,
            @RequestParam(value = "credit")long credit
            ) throws ParseException {

        System.out.println(goodsName);
          Goods goods=new Goods();
          goods.setGoodsname(goodsName);
          goods.setTypeid(typeID);
          goods.setGoodssum(goodsSum);
          goods.setMarketprive(marketPrive);
          goods.setMemberprice(memberPrive);
          goods.setSoldamount((long) 0);
          goods.setCredit(credit);

        String a= String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String b=sdf2.format(sdf1.parse(a));
        Date date=sdf2.parse(b);
        goods.setCreatetime(date);
          goods.setStoreid(storeID);
           try {
               goods.setShop(storeService.findByid(storeID).getStorename());
               Goods good = goodsService.addGoods(goods);
               GoodsDetail goodsDetail = new GoodsDetail();
               goodsDetail.setContent(content);
               goodsDetail.setGoodsid(goods.getId());
               goodsDetailService.add(goodsDetail);
               return  new JsonResult("200",goods.getId());
           }catch (Exception e){
               return  new JsonResult("500",e.getMessage());
           }
    }
//图片骚操作
    public  long temp;
    @PostMapping("/uploadImage")
    public JsonResult uploadImage(@RequestParam(value ="id")long id,@RequestParam(value = "file") MultipartFile files) throws ParseException {
        String filePath = ImageConfig.imagepath;
            String fileName = files.getOriginalFilename();
            String stuffxName = fileName.substring(fileName.lastIndexOf("."));
             fileName = System.currentTimeMillis() + stuffxName;

        String a= String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String b=sdf2.format(sdf1.parse(a));
        Date date=sdf2.parse(b);

            GoodsImage goodsImage=new GoodsImage();
            goodsImage.setIamgeaddress("http://oz4zfzmr0.bkt.clouddn.com/"+fileName);
            if (temp!=id){
                goodsImage.setIskeyiamge((byte) 1);
                temp=id;
            }else {
                goodsImage.setIskeyiamge((byte) 0);
            }
                    Auth auth=Auth.create(QiNiuconfig.accessKey,QiNiuconfig.secretKey);
                   String upToken=auth.uploadToken(QiNiuconfig.bucket);
                   UploadManager uploadManager=new UploadManager(new Configuration(Zone.zone0()));
                  goodsImage.setGoodsid(id);
                  goodsImage.setCreatetime(date);
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                files.transferTo(dest);
                 Response response=uploadManager.put(dest,fileName,upToken);

                GoodsImage goodsImages=goodsImageService.built(goodsImage);
                return  new JsonResult("200",goodsImage);

            } catch (IOException e) {
                return  new JsonResult("500",e.getMessage());
            }
    }


//    更新商品
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
    String filePath=ImageConfig.imagepath;
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


//列表页商品操作
    @PutMapping(value = "/controlGoods")
    public  JsonResult controlGoods(
            @RequestBody Goods goods
    ){
       try{
           Goods goods1=goodsService.updateGoods(goods);
           return new JsonResult("200",goods1);
       }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
       }
    }

//删除商品
    @DeleteMapping(value = "/deleteGoods")
    public JsonResult deleteGoods(
        @RequestParam(value = "id")long id
    ) throws QiniuException {
        int result=goodsImageService.deletebygoodsid(id);
        List<GoodsImage> list=goodsImageService.find(id);
        for (int i = 0; i <list.size() ; i++) {
            String imagurl=list.get(i).getIamgeaddress();
            imagurl=imagurl.replaceAll("http://oz4zfzmr0.bkt.clouddn.com/","");
            System.out.println(imagurl);
            Auth auth=Auth.create(QiNiuconfig.accessKey,QiNiuconfig.secretKey);
            BucketManager bucketManager=new BucketManager(auth,new Configuration(Zone.zone0()));
            bucketManager.delete(QiNiuconfig.bucket,imagurl);
            String path= ImageConfig.imagepath;
            String imagepath=path+imagurl;
            System.out.println(imagepath);
            File file=new File(imagepath);
            file.delete();
        }
        int  b=goodsDetailService.deletebygoodid(id);
        boolean a=goodsService.delete(id);

        if (a){
            return  new JsonResult("200","删除商品成功");
        }else {
            return  new JsonResult("500","删除商品失败");
        }
    }

//店铺的商品
    @GetMapping(value = "/getGoods")
    public  JsonResult getGoods(
            @RequestParam(value = "storeID",required = false)long storeID,
            @RequestParam(value = "page",required = false)int page,
            @RequestParam(value = "pagesize",required = false)int pagesize
    ){
                PageBean<Goods>  goodslist=goodsService.findBySID(storeID,page,pagesize);
             List<GoodsList> goodsLists=new ArrayList<GoodsList>();
       try {
           for (Goods data : goodslist.getList()) {
               GoodsList storedata=new GoodsList();
               storedata.setId(data.getId());
               storedata.setGoodsName(data.getGoodsname());
               String a;
               try{
                    a=goodsImageService.findMainImage(data.getId()).getIamgeaddress();
               }catch (Exception e){
                   a=null;
               }
               storedata.setImageAddress(a);
               storedata.setIsstart(data.getIsstart());
               storedata.setMarketPrice(data.getMarketprive());
               storedata.setMemberPrice(data.getMemberprice());
               storedata.setSoldamount(data.getSoldamount());
               storedata.setGoodsSum(data.getGoodssum());
               String time=null;
               try{
                   SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                   time=df.format(data.getCreatetime());
               }catch (Exception e){
                   time=null;
               }

               storedata.setCreateTime(time);
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
    @PutMapping(value = "/upDataOrder")
   public  JsonResult updataOrder(
         @RequestBody Order order
    ){
               try{
                   Order order1=orderService.updateOrder(order);

                   return new JsonResult("200",order1);
               }catch (Exception e){
                   return  new JsonResult("500",e.getMessage());
               }
    }
////   更新物流
//      @PutMapping(value = "/updateOrderDetail")
//    public  JsonResult updateOrderDetail(
//            @RequestBody OrderDetail orderDetail
//      ){
//             try{
//                 OrderDetail orderDetail1=orderDetailService.updateOrderDetail(orderDetail);
//              return    new JsonResult("200",orderDetail1);
//             }catch (Exception e){
//              return    new JsonResult("500",e.getMessage());
//             }
//      }
      //获取订单细节
    @GetMapping(value = "/orderDatail")
    public  JsonResult getOrderDetail(
            @RequestParam(value = "id") long id
    ){
                try {
                    Order order = orderService.findByID(id);
                    OrderDetailList orderDetailList = new OrderDetailList();
                    orderDetailList.setId(order.getId());
                    orderDetailList.setCount(order.getGoodsum());
                    orderDetailList.setGoodsName(order.getGoodsname());
                    orderDetailList.setImageAddress(goodsImageService.findMainImage(order.getGoodsid()).getIamgeaddress());
                    orderDetailList.setPrice(order.getMemberprice());
                    orderDetailList.setMeneySum(order.getPricesum());
                    orderDetailList.setIsstate(order.getIspay());
                    orderDetailList.setMessage(order.getMessage());
                    orderDetailList.setOrderCode(order.getOrdercode());
                    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    orderDetailList.setSendTime(df.format(order.getSendtime()));
                    orderDetailList.setLogistics(order.getLogistics());
                    orderDetailList.setLogisticsCode(order.getLogisticscode());
                    orderDetailList.setTel(addressMongerService.findByUseridDefault(order.getUserid()).getReceivetel());
                    orderDetailList.setReceiver(addressMongerService.findByUseridDefault(order.getUserid()).getReceivepeople());
                    orderDetailList.setAddress(addressMongerService.findByUseridDefault(order.getUserid()).getAddressdetail());
                   return new JsonResult("200",orderDetailList);
                }catch (Exception e){
                    return  new JsonResult("500",e.getMessage());
                }
    }
    @GetMapping(value = "/findByID")
    public  JsonResult getFindByID(
            @RequestParam(value = "id")long id
    ){
        try{
            Order order=orderService.findByID(id);
            return new JsonResult("200",order);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }
    @PostMapping(value = "/add")
    public  JsonResult add(
            @RequestParam(value = "orderid")long orderid,
            @RequestParam(value = "userid")long userid,
            @RequestParam(value = "logisticsName")String logisticsName
    ){
            Logistics logistics=new Logistics();
            logistics.setOrderid(orderid);
            logistics.setUserid(userid);
            logistics.setLogisticsname(logisticsName);
            Logistics logistics1=logisticsService.built(logistics);
           return  new JsonResult("200",logistics);

    }
//获取时间
    @GetMapping(value = "/gettime")
    public JsonResult gettime() throws ParseException {
                GoodsImage goodsImage=new GoodsImage();
                goodsImage.setGoodsid((long) 3);
                String a= String.valueOf(new Date());
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String b=sdf2.format(sdf1.parse(a));
               Date date=sdf2.parse(b);
        goodsImage.setCreatetime(date);
                goodsImage.setIskeyiamge((byte) 0);
                goodsImage.setIamgeaddress("sfsdfsdf");
                goodsImageService.built(goodsImage);
                return new JsonResult("200",goodsImage);
    }
//获得所有的店铺列表
    @GetMapping(value = "/getstorelist")
    public JsonResult getstorelist(){
                try{
                    List<Store> list=storeService.getaddstore();
                    return  new JsonResult("200",list);
                }catch (Exception e){
                    return  new JsonResult("500",e.getMessage());
                }
    }

//  获取店铺信息
    @GetMapping(value = "/getstoreinfo")
    public JsonResult getstoreinfo(
            @RequestParam(value = "storeid")Long storeid
    ){
           try{
               Store store=storeService.findByid(storeid);
               return  new JsonResult("200",store);

           }catch (Exception e){
               return  new JsonResult("500",e.getMessage());
           }
    }
//    获取店铺的商品发送移动端
    @GetMapping(value = "/getstoregoodsmobil")
    public  JsonResult getstoregoodsmobil(
            @RequestParam(value ="storeid")Long storeid
    ){
                try{
                     List<Goods> goodslist=goodsService.findBystoreid(storeid);
                    List<GoodsModel> list=new ArrayList<GoodsModel>();
                    for (Goods data:goodslist) {
                        GoodsModel goodsModel = new GoodsModel();
                        goodsModel.setStoreid(data.getStoreid());
                        goodsModel.setGoodsName(data.getGoodsname());
                        goodsModel.setSoldamount(data.getSoldamount());
                        goodsModel.setPrice(data.getMarketprive());
                        goodsModel.setStorename(data.getShop());
                        goodsModel.setMemberprice(data.getMemberprice());
                        goodsModel.setGoodsSum(data.getGoodssum());
                        List<String> iamgeurl = null;
                        try {
                            iamgeurl = goodsImageService.findimage(data.getId());
                        } catch (Exception e) {
                            iamgeurl = null;
                        }
                        goodsModel.setImageaddress(iamgeurl);
                        String content = null;
                        try {
                            content = goodsDetailService.findByGoodsid(data.getId()).getContent();
                        } catch (Exception e) {
                            content = "";
                        }
                        goodsModel.setContent(content);
                        goodsModel.setId(data.getId());
                        list.add(goodsModel);}
                    return  new JsonResult("200",list);
                }catch (Exception e){
                    return  new JsonResult("500",e.getMessage());
                }
    }
//    随机商家列表
    @GetMapping(value = "/getrandomstore")
    public JsonResult getrandomstore(){
        try{
            int sum = (int) storeService.countStore();
            int n=0;
            if (sum>8){
                 n=6;
            }else {
                n=sum;
            }
            HashSet<Integer> set = new HashSet<Integer>();

              randomCommon(1, sum+1, n+1,set);
           List<Store> list = new ArrayList<Store>();
          for (int i : set) {


                Store store=storeService.findByid(i);
                list.add(store);
           }
            return  new JsonResult("200",list);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }
    //    去重算法
    public  void randomCommon(int min, int max,int n, HashSet<Integer> set){
        if (n > (max - min + 1) || max < min) {
        }
        for (int i = 0; i < n; i++) {
            // 调用Math.random()方法
            int num = (int) (Math.random() * (max - min)) + min;
            set.add(num);// 将不同的数存入HashSet中
        }
        int setSize = set.size();
        // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小
        if (setSize < n) {
            randomCommon(min, max, n - setSize, set);// 递归
        }
    }



}
