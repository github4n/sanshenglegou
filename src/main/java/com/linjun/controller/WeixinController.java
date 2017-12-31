package com.linjun.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.linjun.common.JsonResult;
import com.linjun.config.WeixinConfig;
import com.linjun.model.User;
import com.linjun.service.UserService;
import com.linjun.util.HttpsUtil;
import com.linjun.util.UserInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

@RestController
public class WeixinController {
    @Autowired
    UserService userService;





//    校验微信服务器
    private Logger logger = LoggerFactory.getLogger(getClass());
private String TOKEN="weixin";
@GetMapping(value = "/weixin")
    public  String checkName(@RequestParam(name = "signature") String signature,
                             @RequestParam(name = "timestamp") String timestamp,
                             @RequestParam(name = "nonce") String nonce,
                             @RequestParam(name = "echostr") String echostr){

    logger.info("微信-开始校验签名");
    logger.info("收到来自微信的 echostr 字符串:{}", echostr);

    String sortString = sort(TOKEN, timestamp, nonce);
    // 2.sha1加密
    String myString = sha1(sortString);
    // 3.字符串校验
    if (myString != null && myString != "" && myString.equals(signature)) {
        logger.info("微信-签名校验通过");
        //如果检验成功原样返回echostr，微信服务器接收到此输出，才会确认检验完成。
        logger.info("回复给微信的 echostr 字符串:{}", echostr);
        return echostr;
    } else {
        logger.error("微信-签名校验失败");
        return "";
    }
}

//微信用户信息的获取
//    微信登入

   @GetMapping(value = "/wechat")
   public JsonResult wechatLogin(
           @RequestParam(value = "code",required = false)String code,
           @RequestParam(value = "state")String state
   ){
       logger.info("收到微信重定向跳转.");
       logger.info("用户同意授权,获取code:{} , state:{}", code, state);
       if (code !=null||!(code.equals(""))){

           String APPID = WeixinConfig.WX_APPID;
           String SECRET = WeixinConfig.WX_APPSECRET;
           String CODE = code;
           String WebAccessToken = "";
           String openId = "";
           String nickName,sex,openid = "";
           String REDIRECT_URI = WeixinConfig.REDIRECT_URI;
           String SCOPE = "snsapi_userinfo";
           String getCodeUrl = UserInfoUtil.getCode(APPID, REDIRECT_URI, SCOPE);
           logger.info("第一步:用户授权, get Code URL:{}", getCodeUrl);
           // 替换字符串，获得请求access token URL
           String tokenUrl = UserInfoUtil.getWebAccess(APPID, SECRET, CODE);
           logger.info("第二步:get Access Token URL:{}", tokenUrl);
           // 通过https方式请求获得web_access_token
           String response = HttpsUtil.httpsRequestToString(tokenUrl, "GET", null);

           JSONObject jsonObject = JSON.parseObject(response);
           logger.info("请求到的Access Token:{}", jsonObject.toJSONString());
         if (jsonObject!=null){
             try{
                 WebAccessToken = jsonObject.getString("access_token");
                 openId = jsonObject.getString("openid");
                 logger.info("获取access_token成功!");
                 logger.info("WebAccessToken:{} , openId:{}", WebAccessToken, openId);

                 // 3. 使用获取到的 Access_token 和 openid 拉取用户信息
                 String userMessageUrl = UserInfoUtil.getUserMessage(WebAccessToken, openId);
                 logger.info("第三步:获取用户信息的URL:{}", userMessageUrl);

                 // 通过https方式请求获得用户信息响应
                 String userMessageResponse = HttpsUtil.httpsRequestToString(userMessageUrl, "GET", null);

                 JSONObject userMessageJsonObject = JSON.parseObject(userMessageResponse);

                 logger.info("用户信息:{}", userMessageJsonObject.toJSONString());

                 if (userMessageJsonObject != null) {
                     try {
                         //用户昵称
                         nickName = userMessageJsonObject.getString("nickname");
                         //用户性别
                         sex = userMessageJsonObject.getString("sex");
                         sex = (sex.equals("1")) ? "男" : "女";
                         //用户唯一标识
                         openid = userMessageJsonObject.getString("openid");
                         String headimage=userMessageJsonObject.getString("headimgurl");
                         String city=userMessageJsonObject.getString("city");
                         String country=userMessageJsonObject.getString("country");
                         String province=userMessageJsonObject.getString("province");

                         if (userService.isExitByopenid(openid)){
                           User user=userService.findByopenid(openid);
                             String a= String.valueOf(new Date());
                             SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                             SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                             String b=sdf2.format(sdf1.parse(a));
                             System.out.println(b);
                             Date date=sdf2.parse(b);
                             System.out.println(date);
                           user.setLogin(new Date());
                          User user1= userService.updateUser(user);
                             System.out.println(user.toString());
                          String time =sdf2.format(user1.getLogin());
                             return  new JsonResult("200",user);
                         }else {
                             User user=new User();
                             user.setUsername(nickName);
                             user.setRole((byte) 0);
                             user.setCity(city);
                             user.setCountry(country);
                             user.setProvince(province);
                             user.setSex(sex);
                             user.setHeadimage(headimage);
                             user.setOpenid(openid);
                             String a= String.valueOf(new Date());
                             user.setToken(String.valueOf(new Date().getTime()));
                             SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                             SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                             String b=sdf2.format(sdf1.parse(a));
                             Date date=sdf2.parse(b);
                             user.setCreatetime(date);
                             user.setLogin(date);
                             User user1=userService.add(user);
                            return new JsonResult("200",user);
                         }

                     } catch (JSONException e) {
                         logger.error("获取用户信息失败");
                         return  new JsonResult("500",e.getMessage());
                     } catch (ParseException e) {
                         e.printStackTrace();
                         return  new JsonResult("400",e.getMessage());
                     }
                 }

             }catch (JSONException e){
                 logger.error("获取web ACCess token失败");
                 return  new JsonResult("600",e.getMessage());
             }
         }
       }
       return new JsonResult("","");

   }
//微信支付
@GetMapping(value = "/getuserinfo")
public JsonResult getuserinfo(
        @RequestParam(value = "openid")String openid
){
    try{
        User user=userService.findByopenid(openid);
       return  new JsonResult("200",user);
    }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
    }

}





    /**
     * 排序方法
     * @param token     Token
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @return
     */
    public String sort(String token, String timestamp, String nonce) {
        String[] strArray = {token, timestamp, nonce};
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
        }

        return sb.toString();
    }

    /**
     * 将字符串进行sha1加密
     *
     * @param str 需要加密的字符串
     * @return    加密后的内容
     */
    public String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();
            // 创建 16进制字符串
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
