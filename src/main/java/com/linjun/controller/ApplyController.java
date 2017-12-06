package com.linjun.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.google.gson.Gson;
import com.linjun.common.JsonResult;
import com.linjun.common.domain.PeopleException;
import com.linjun.config.ImageConfig;
import com.linjun.config.QiNiuconfig;
import com.linjun.model.*;
import com.linjun.pojo.Base64jiexin;
import com.linjun.service.*;
import com.linjun.util.RandomString;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import javax.xml.bind.util.JAXBSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping(value = "/apply")
public class ApplyController {
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
//  base64图片上传
//    村村通图片上传
@PostMapping(value = "/villageiamge")
    public JsonResult villageimage(
            @RequestBody String file
){

    Gson gson=new Gson();
    Base64jiexin base64jiexin=gson.fromJson(file, Base64jiexin.class);
     if (GenerateImage(base64jiexin.getContent())){
         String data="http://oz4zfzmr0.bkt.clouddn.com/"+temps;
         return new JsonResult("200",data);
     }else {
      return  new JsonResult("500","上传失败");
     }
}
//删除图片
 @DeleteMapping(value = "/deletevillageimage")
         public  JsonResult deletevillageimage(
                 @RequestParam String imagurl
 ){
     imagurl=imagurl.replaceAll("http://oz4zfzmr0.bkt.clouddn.com/","");
     System.out.println(imagurl);
     Auth auth=Auth.create(QiNiuconfig.accessKey,QiNiuconfig.secretKey);
         BucketManager bucketManager=new BucketManager(auth,new Configuration(Zone.zone0()));

     try {
         bucketManager.delete(QiNiuconfig.bucket,imagurl);
         String path=ImageConfig.imagepath;
         String imagepath=path+imagurl;
         System.out.println(imagepath);
         File file=new File(imagepath);
         file.delete();
         return new JsonResult("200","成功");
     } catch (Exception e) {
         return  new JsonResult("500",e.getMessage());
     }
 }


  String temps=null;
    public  boolean GenerateImage(String imgStr)
    {   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return  false;
        imgStr=imgStr.replaceAll("data:image/jpeg;base64,", "");
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            String filePath = ImageConfig.imagepath;
            String temp=RandomString.getRandomString(6);
            String fileName = System.currentTimeMillis()+temp+ ".jpg";
            temps=fileName;
            Auth auth=Auth.create(QiNiuconfig.accessKey,QiNiuconfig.secretKey);
            String upToken=auth.uploadToken(QiNiuconfig.bucket);
            UploadManager uploadManager=new UploadManager(new Configuration(Zone.zone0()));
            Response response=uploadManager.put(b,fileName,upToken);
            //生成jpeg图片
//            String imgFilePath = "/Users/linjun/deaProjects/image/222.jpg";//新生成的图片
            OutputStream out = new FileOutputStream(filePath+fileName);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
//  村村通提交申请
    @PostMapping(value = "/submitvillage")
    public JsonResult submitvillage(
            @RequestParam(value = "userid")long userid,
            @RequestParam(value = "username")String username,
            @RequestParam(value = "tel")String tel,
            @RequestParam(value = "bankaccount")String bankaccount,
            @RequestParam(value = "identityimage")String identityimage,
            @RequestParam(value = "identityimages")String identityimages

    ){
        try{
            VillageApply villageApply=new VillageApply();
            villageApply.setBankacount(bankaccount);
            villageApply.setIdentityimage(identityimage);
            villageApply.setIdentityimages(identityimages);
            villageApply.setUsername(username);
            String a= String.valueOf(new Date());
            SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String b=sdf2.format(sdf1.parse(a));
            Date date=sdf2.parse(b);
            villageApply.setAppletime(date);
            villageApply.setUserid(userid);
            VillageApply villageApply1=villageApplyService.add(villageApply);
            return new JsonResult("200",villageApply);
        }catch (Exception e){
         return  new JsonResult("500",e.getMessage());
        }
    }
//    判断村村通申请
    @GetMapping(value = "/isvillage")
    public JsonResult isvillage(
            @RequestParam(value = "userid")Long userid
    ){
                VillageApply villageApply1=new VillageApply();
                villageApply1.setUserid(userid);
           try{
               VillageApply villageApply=villageApplyService.isexit(villageApply1);
               return new JsonResult("200",villageApply);
           }catch (Exception e){
               return new JsonResult("500",e.getMessage());
           }


    }




//    商城申请提交
    @PostMapping(value = "/submitstore")
    public JsonResult submitstore(
            @RequestParam(value = "userid")long userid,
            @RequestParam(value = "username")String username,
         @RequestParam(value = "tel") String tel,
         @RequestParam(value = "bankaccount")String bankaccount,
         @RequestParam(value = "identityimage")String identityimage,
         @RequestParam(value = "identityimages")String identityimages,
         @RequestParam(value = "businessimages")String businessimages
    ){

       try{
           StoreApply storeApply=new StoreApply();
           String a= String.valueOf(new Date());
           SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
           SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           String b=sdf2.format(sdf1.parse(a));
           Date date=sdf2.parse(b);
           storeApply.setAppletime(date);
           storeApply.setTel(tel);
           storeApply.setUsername(username);
           storeApply.setBankacount(bankaccount);
           storeApply.setBusinessimages(businessimages);
           storeApply.setIdentityimage(identityimage);
           storeApply.setBusinessimages(identityimages);
           storeApply.setUserid(userid);
       StoreApply storeApply1=   storeApplyService.add(storeApply);
           return new JsonResult("200",storeApply);
       }catch (Exception e){
           return new JsonResult("500",e.getMessage());
       }
    }
//    判断商城申请
    @GetMapping(value = "/isstoreapply")
    public JsonResult isstoreapply(
            @RequestParam(value = "userid")Long userid
    ){
        try{
            StoreApply storeApply=new StoreApply();
            storeApply.setUserid(userid);
            StoreApply storeApply1=storeApplyService.isexit(storeApply);
            return  new JsonResult("200",storeApply1);

        }catch (Exception e){
            return new JsonResult("500",e.getMessage());
        }


    }



//   会员申请提交
    @PostMapping(value = "/submitmember")
    public JsonResult submitmember(
            @RequestParam(value = "userid")long userid,
            @RequestParam(value = "tel")String tel,
            @RequestParam(value = "username")String username,
            @RequestParam(value = "bankaccount")String bankaccount,
            @RequestParam(value = "identityimage")String identityimage,
            @RequestParam(value = "identityimages")String identityimages
    ){
         try{
             MemberApply memberApply=new MemberApply();
             String a= String.valueOf(new Date());
             SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
             SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String b=sdf2.format(sdf1.parse(a));
             Date date=sdf2.parse(b);
             memberApply.setAppletime(date);
             memberApply.setIdentityimage(identityimage);
             memberApply.setIdentityimages(identityimages);
             memberApply.setBankacount(bankaccount);
             memberApply.setUsername(username);
             memberApply.setUserid(userid);
              MemberApply memberApply1= memberApplyService.add(memberApply);
             return new JsonResult("200",memberApply);
         }catch (Exception e){
            return new JsonResult("500",e.getMessage());
         }

    }
//    判断会员申请
    @GetMapping(value = "/ismember")
    public JsonResult ismember(
            @RequestParam(value = "userid")Long userid
    ){
             try{
                 MemberApply memberApply=new MemberApply();
                 memberApply.setUserid(userid);
                 MemberApply memberApply1=memberApplyService.isexit(memberApply);
                 return new JsonResult("200",memberApply1);
             }catch (Exception e){
                 return  new JsonResult("500",e.getMessage());
             }
    }


//    提现申请提交
    @PostMapping(value = "/submitwithdraw")
    public JsonResult submitwithdraw(
            @RequestParam(value = "userid")long userid,
            @RequestParam(value = "username")String username,
            @RequestParam(value = "storename")String storename,
            @RequestParam(value = "price")Float price,
            @RequestParam(value = "bankacount")String bankacount
    ){
   try{
       String a= String.valueOf(new Date());
       SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
       SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String b=sdf2.format(sdf1.parse(a));
       Date date=sdf2.parse(b);
       WithDrawApply withDrawApply=new WithDrawApply();
       withDrawApply.setAppletime(date);
       withDrawApply.setBankacount(bankacount);
       withDrawApply.setPrice(price);
       withDrawApply.setUserid(userid);
       withDrawApply.setUsername(username);
       withDrawApply.setStorename(storename);
       WithDrawApply withDrawApply1=withDrawApplyService.add(withDrawApply);
       return new JsonResult("200",withDrawApply);
   }catch (Exception e){
       return new JsonResult("500",e.getMessage());
   }

    }
//  判断提现申请
    @GetMapping(value = "/iswithdraw")
    public  JsonResult iswithdraw(
            @RequestParam(value = "userid")Long userid
    ){
        try{
            WithDrawApply withDrawApply=new WithDrawApply();
            withDrawApply.setUserid(userid);
            WithDrawApply withDrawApply1=withDrawApplyService.isexit(withDrawApply);
            return new JsonResult("200",withDrawApply1);
        }catch (Exception e){
            return new JsonResult("500",e.getMessage());
        }
    }
//    店铺、村村通注册
    @PostMapping(value = "/register")
    public  JsonResult register(
            @RequestBody Store store
    ){
       try{
           Store store1=storeService.add(store);
           return new JsonResult("200",store);
       }catch (Exception e){
           return  new JsonResult("500",e.getMessage());
       }

    }


}
