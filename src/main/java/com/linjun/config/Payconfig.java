package com.linjun.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Payconfig {
   String mpAppId=WeixinConfig.APPID;
   String mchId=WeixinConfig.MCH_ID;
   String mchKey=WeixinConfig.API_KEY;
   String keyPath=WeixinConfig.KeyPath;
   String notifyUrl=WeixinConfig.notifyUrl;

    @Bean
    public WxPayH5Config wxPayH5Config() {
        WxPayH5Config wxPayH5Config = new WxPayH5Config();
        wxPayH5Config.setAppId(mpAppId);
        wxPayH5Config.setMchId(mchId);
        wxPayH5Config.setMchKey(mchKey);
        wxPayH5Config.setKeyPath(keyPath);
        wxPayH5Config.setNotifyUrl(notifyUrl);
        return wxPayH5Config;
    }

    @Bean
    public BestPayServiceImpl bestPayService(WxPayH5Config wxPayH5Config) {
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayH5Config(wxPayH5Config);
        return bestPayService;
    }
}
