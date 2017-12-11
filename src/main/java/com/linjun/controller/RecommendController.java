package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.model.Goods;
import com.linjun.pojo.GoodsModel;
import com.linjun.service.GoodsDetailService;
import com.linjun.service.GoodsImageService;
import com.linjun.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
public class RecommendController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsDetailService goodsDetailService;
    @Autowired
    GoodsImageService goodsImageService;

    @GetMapping(value = "/recommend")
    public JsonResult getRecommend() {
        try {
            long sum = goodsService.countGoods();
            int n = 1;

            if (sum > 2) {
                n = 1;
            } else {
                n = (int) sum;
            }
            HashSet<Integer> set = new HashSet<Integer>();

            randomCommon(1, (int) sum, n, set);
            List<GoodsModel> list = new ArrayList<GoodsModel>();
            for (int i : set) {
                Goods goods = goodsService.findByid(i);
                GoodsModel goodsModel = new GoodsModel();
                goodsModel.setStoreid(goods.getStoreid());
                goodsModel.setGoodsName(goods.getGoodsname());
                goodsModel.setSoldamount(goods.getSoldamount());
                goodsModel.setPrice(goods.getMarketprive());
                goodsModel.setStorename(goods.getShop());
                goodsModel.setMemberprice(goods.getMemberprice());
                goodsModel.setGoodsSum(goods.getGoodssum());
                List<String> iamgeurl = null;
                try {
                    iamgeurl = goodsImageService.findimage(goods.getId());
                } catch (Exception e) {
                    iamgeurl = null;
                }
                goodsModel.setImageaddress(iamgeurl);
                String content = null;
                try {
                    content = goodsDetailService.findByGoodsid(goods.getId()).getContent();
                } catch (Exception e) {
                    content = "";
                }
                goodsModel.setContent(content);
                goodsModel.setId(goods.getId());
                list.add(goodsModel);
            }
            return new JsonResult("200", list);
        } catch (Exception e) {
            return new JsonResult("500", e.getMessage());
        }
    }

    //    去重算法
    public void randomCommon(int min, int max, int n, HashSet<Integer> set) {
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