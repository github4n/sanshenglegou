package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.model.Goods;
import com.linjun.pojo.GoodsModel;
import com.linjun.service.GoodsDetailService;
import com.linjun.service.GoodsImageService;
import com.linjun.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecommendController {
      @Autowired
    GoodsService goodsService;
      @Autowired
    GoodsDetailService goodsDetailService;
    @Autowired
    GoodsImageService goodsImageService;
    @RequestMapping(value = "/recommend")
    public JsonResult getRecommend(){
        try {
            long sum = goodsService.countGoods();
            int[] random = randomCommon(0, (int) sum, 12);
            List<GoodsModel> list = new ArrayList<GoodsModel>();
            for (int i : random) {
                Goods goods=goodsService.findByid(i);
                    GoodsModel goodsModel=new GoodsModel();
                    goodsModel.setStoreid(goods.getStoreid());
                    goodsModel.setGoodsName(goods.getGoodsname());
                    goodsModel.setSoldamount(goods.getSoldamount());
                    goodsModel.setPrice(goods.getMarketprive());
                    goodsModel.setStorename(goods.getShop());
                    goodsModel.setMemberprice(goods.getMemberprice());
                    goodsModel.setGoodsSum(goods.getGoodssum());
                    goodsModel.setImageaddress(goodsImageService.findimage(goods.getId()));
                    goodsModel.setContent(goodsDetailService.findByGoodsid(goods.getId()).getContent());
                    goodsModel.setId(goods.getId());
                list.add(goodsModel);
            }
            return new JsonResult("200",list);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }
//    去重算法
public static int[] randomCommon(int min, int max, int n){
    if (n > (max - min + 1) || max < min) {
        return null;
    }
    int[] result = new int[n];
    int count = 0;
    while(count < n) {
        int num = (int) (Math.random() * (max - min)) + min;
        boolean flag = true;
        for (int j = 0; j < n; j++) {
            if(num == result[j]){
                flag = false;
                break;
            }
        }
        if(flag){
            result[count] = num;
            count++;
        }
    }
    return result;
}



}
