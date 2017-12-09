package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.Goods;
import com.linjun.model.GoodsDetail;
import com.linjun.pojo.GoodsModel;
import com.linjun.service.GoodsDetailService;
import com.linjun.service.GoodsImageService;
import com.linjun.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/composite")
public class CompositeController {
    @Autowired
    GoodsImageService goodsImageService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsDetailService goodsDetailService;
//获取内容
    @GetMapping(value = "/index")
    public JsonResult getfish(@RequestParam(value = "goodstype") long goodstype){
        try {
            List<Goods> goodsList = goodsService.gettypeGoods(goodstype);
            List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
            for (Goods goods : goodsList) {
                GoodsModel goodsModel=new GoodsModel();
                goodsModel.setStoreid(goods.getStoreid());
                goodsModel.setGoodsName(goods.getGoodsname());
                goodsModel.setSoldamount(goods.getSoldamount());
                goodsModel.setPrice(goods.getMarketprive());
                goodsModel.setStorename(goods.getShop());
                goodsModel.setMemberprice(goods.getMemberprice());
                goodsModel.setGoodsSum(goods.getGoodssum());
                List<String> imageurl=new ArrayList<String>();
                try{
                    imageurl=goodsImageService.findimage(goods.getId());
                }catch (Exception e){
                   imageurl= null;
                }
                goodsModel.setImageaddress(imageurl);
                String content=null;
                try{
                    content=goodsDetailService.findByGoodsid(goods.getId()).getContent();
                }catch (Exception e){
                    content="";
                }
                goodsModel.setContent(content);
                goodsModel.setId(goods.getId());
                goodsModelList.add(goodsModel);
            }

            return new JsonResult("200", goodsModelList);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }


}
