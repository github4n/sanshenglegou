package com.linjun.controller;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lly835.bestpay.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Random;

@Controller
@Slf4j
public class PayController {

    @Autowired
    private BestPayServiceImpl bestPayService;
    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 发起支付
     */
    @GetMapping(value = "/pay")
    public ModelAndView pay(@RequestParam("openid") String openid,
                            @RequestParam("privce")float privce,
                            @RequestParam("orderid")String orderid,
                            @RequestParam("ordername")String ordername,
                            Map<String, Object> map) {
        PayRequest request = new PayRequest();
        Random random = new Random();
        request.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        request.setOrderId(orderid);
        request.setOrderAmount((double) privce);
        request.setOrderName("最好的支付sdk");
        request.setOpenid(openid);
        log.info("【发起支付】request={}", JsonUtil.toJson(request));

        PayResponse payResponse = bestPayService.pay(request);
        log.info("【发起支付】response={}", JsonUtil.toJson(payResponse));

        map.put("payResponse", payResponse);

        return new ModelAndView("pay/create", map);



    }

    /**
     * 异步回调
     */
    @PostMapping(value = "/notify")
    public ModelAndView notify(@RequestBody String notifyData) throws Exception {
        log.info("【异步回调】request={}", notifyData);
        PayResponse response = bestPayService.asyncNotify(notifyData);
        log.info("【异步回调】response={}", JsonUtil.toJson(response));

        return new ModelAndView("pay/success");
    }


}