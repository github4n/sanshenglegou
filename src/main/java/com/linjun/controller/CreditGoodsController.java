package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.config.ImageConfig;
import com.linjun.config.QiNiuconfig;
import com.linjun.entity.PageBean;
import com.linjun.model.*;
import com.linjun.service.*;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.jvm.hotspot.interpreter.BytecodeGetPut;
import sun.plugin2.message.JavaScriptBaseMessage;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    CreditByUserService creditByUserService;

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
            Creditgoods creditgoods1=creditGoodsService.finbyid(creditgoodsid);
            String imagurl=creditgoods1.getImageurl();
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

            int result=creditGoodsService.delete(creditgoods);
            return  new JsonResult("200",result);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }
//    新增积分商品
    @GetMapping(value = "/addcreategoods")
    public JsonResult addcreategoods(
        @RequestParam(value = "creditgood")String creditgood,
        @RequestParam(value = "cregoodssum")long cregoodssum,
        @RequestParam(value = "price")long price
    ){
        try{
           Creditgoods creditgoods=new Creditgoods();
           creditgoods.setCreditgood(creditgood);
           creditgoods.setCregoodssum(cregoodssum);
           creditgoods.setIsstart((byte) 1);
           creditgoods.setPrice(price);
           creditgoods.setSoldamount((long) 0);
            String a= String.valueOf(new Date());
            SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String b=sdf2.format(sdf1.parse(a));
            Date date=sdf2.parse(b);
            creditgoods.setCreatetime(date);
            Creditgoods creditgoods1=creditGoodsService.add(creditgoods);
        return  new JsonResult("200",creditgoods);
        }catch (Exception e){
            return new JsonResult("500",e.getMessage());
        }
    }
//    上传图片
@PostMapping("/uploadImage")
public JsonResult uploadImage(@RequestParam(value ="id")long id,@RequestParam(value = "file") MultipartFile files) throws ParseException {
    String filePath = ImageConfig.imagepath;
    String fileName = files.getOriginalFilename();
    String stuffxName = fileName.substring(fileName.lastIndexOf("."));
    fileName = UUID.randomUUID() + stuffxName;
    fileName = System.currentTimeMillis() + fileName;
    String a= String.valueOf(new Date());
    SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
    SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String b=sdf2.format(sdf1.parse(a));
    Date date=sdf2.parse(b);
    Creditgoods creditgoods = new Creditgoods();
    creditgoods.setImageurl("http://oz4zfzmr0.bkt.clouddn.com/"+fileName);
    Auth auth=Auth.create(QiNiuconfig.accessKey,QiNiuconfig.secretKey);
    String upToken=auth.uploadToken(QiNiuconfig.bucket);
    UploadManager uploadManager=new UploadManager(new Configuration(Zone.zone0()));
    creditgoods.setId(id);
    File dest = new File(filePath + fileName);
    if (!dest.getParentFile().exists()) {
        dest.getParentFile().mkdirs();
    }
    try {
        files.transferTo(dest);
        Response response=uploadManager.put(dest,fileName,upToken);
         Creditgoods creditgoods1=creditGoodsService.update(creditgoods);
        return  new JsonResult("200",creditgoods);

    } catch (IOException e) {
        return  new JsonResult("500",e.getMessage());
    }
}






//    分页获取商品列表
    @GetMapping(value = "/getcregoodsall")
    public JsonResult getcregoodsall(
            @RequestParam(value = "page",required = false)int page,
            @RequestParam(value = "pagesize",required = false)int pagesize
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
//    购买积分商品
   @PutMapping(value = "/buycreditgoods")
    public  JsonResult buy(
            @RequestParam(value = "creditgoodsid")long creditgoodsid,
            @RequestParam(value = "userid")long userid
   ){
       try{
           Creditgoods creditg=creditGoodsService.finbyid(creditgoodsid);
           CreditManger creditManger=creditMangerService.findByuserid(userid);
           long goodsum=creditg.getCregoodssum();
           long soldsum=creditg.getSoldamount();
           long creditsum=creditg.getPrice();
           goodsum=goodsum-1;
           Creditgoods creditgoods=new Creditgoods();
           creditgoods.setCregoodssum(goodsum);
           creditgoods.setSoldamount(soldsum+1);
          long creditsuma=creditManger.getCreditsum()-creditsum;
           CreditManger creditManger1=new CreditManger();
           creditManger1.setCreditsum(creditsuma);
           creditManger1.setId(creditManger.getId());
           long creditsums=creditManger.getConsumedcredit()+creditsum;
           creditManger1.setConsumedcredit(creditsums);
           creditMangerService.updateByuserid(creditManger1);
//           更新积分细节
           String a= String.valueOf(new Date());
           SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
           SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           String b=sdf2.format(sdf1.parse(a));
           Date date=sdf2.parse(b);
           CreditDetail creditDetail=new CreditDetail();
           creditDetail.setStatus((byte) 1);
           creditDetail.setUserid(userid);
           creditDetail.setChangtime(date);
           creditDetail.setConsumcredit(creditsum);
           Creditbyuser creditbyuser=new Creditbyuser();
           creditbyuser.setUserid(userid);
           creditbyuser.setCreatetime(date);
           creditbyuser.setCreditgoodid(creditgoodsid);

           creditByUserService.add(creditbyuser);
           creditDetialService.update(creditDetail);
           creditGoodsService.update(creditgoods);
           return  new JsonResult("200",goodsum);
       }catch (Exception e){
           return new JsonResult("500",e.getMessage());
       }
   }
//  获取用户的兑换记录
    @GetMapping(value = "/getuserconvent")
    public JsonResult getuserconvent(
            @RequestParam(value = "userid")long userid
    ){
       try{
           List<Creditbyuser> list=creditByUserService.findbyuseri(userid);
           List<Creditgoods> creditgoods=new ArrayList<Creditgoods>();
           for (Creditbyuser data:list) {
               Creditgoods creditgoods1=creditGoodsService.finbyid(data.getCreditgoodid());
               creditgoods.add(creditgoods1);
           }
           return  new JsonResult("200",creditgoods);
       }catch (Exception e){
           return  new JsonResult("500",e.getMessage());
       }

    }

}
