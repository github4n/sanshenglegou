package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.model.Goods;
import com.linjun.pojo.GoodsModel;
import com.linjun.service.GoodsImageService;
import com.linjun.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/composite")
public class CompositeController {
    @Autowired
    GoodsImageService goodsImageService;
    @Autowired
    GoodsService goodsService;
//食品保健
    @GetMapping(value = "/food")
    public JsonResult getfish(){
        List<Goods> goodsList=goodsService.findByID(13);
        List<GoodsModel> goodsModelList=new ArrayList<GoodsModel>();
        for (Goods list:goodsList){
            GoodsModel goodsModel=new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        return new JsonResult("200",goodsModelList);
    }
//    美容护理
    @GetMapping(value = "/nurse")
    public JsonResult getNurse(){
        List<Goods> goodsList=goodsService.findByID(14);
        List<GoodsModel> goodsModelList=new ArrayList<GoodsModel>();
        for (Goods list:goodsList){
            GoodsModel goodsModel=new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        return new JsonResult("200",goodsModelList);
    }
//    手机数码
    @GetMapping(value = "/phone")
    public JsonResult getPhone(){
        List<Goods> goodsList=goodsService.findByID(15);
        List<GoodsModel> goodsModelList=new ArrayList<GoodsModel>();
        for (Goods list:goodsList){
            GoodsModel goodsModel=new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        return new JsonResult("200",goodsModelList);
    }
//    装修建材
    @GetMapping(value = "/finish")
    public JsonResult getfinish(){
        List<Goods> goodsList=goodsService.findByID(16);
        List<GoodsModel> goodsModelList=new ArrayList<GoodsModel>();
        for (Goods list:goodsList){
            GoodsModel goodsModel=new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        return new JsonResult("200",goodsModelList);
    }
//    男女服饰
    @GetMapping(value = "/cloth")
    public JsonResult getCloth(){
        List<Goods> goodsList=goodsService.findByID(17);
        List<GoodsModel> goodsModelList=new ArrayList<GoodsModel>();
        for (Goods list:goodsList){
            GoodsModel goodsModel=new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        return new JsonResult("200",goodsModelList);
    }
//    鞋帽箱包
    @GetMapping(value = "/shoe")
    public JsonResult getShoe(){
        List<Goods> goodsList=goodsService.findByID(18);
        List<GoodsModel> goodsModelList=new ArrayList<GoodsModel>();
        for (Goods list:goodsList){
            GoodsModel goodsModel=new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        return new JsonResult("200",goodsModelList);
    }
//    饰品摆件
    @GetMapping(value = "/accessories")
    public JsonResult getAccessories(){
        List<Goods> goodsList=goodsService.findByID(19);
        List<GoodsModel> goodsModelList=new ArrayList<GoodsModel>();
        for (Goods list:goodsList){
            GoodsModel goodsModel=new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        return new JsonResult("200",goodsModelList);
    }
//    珠宝首饰
    @GetMapping(value = "/jewelry")
    public JsonResult getJewelry(){
        List<Goods> goodsList=goodsService.findByID(20);
        List<GoodsModel> goodsModelList=new ArrayList<GoodsModel>();
        for (Goods list:goodsList){
            GoodsModel goodsModel=new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        return new JsonResult("200",goodsModelList);
    }
//    日用刚需
    @GetMapping(value = "/wash")
    public JsonResult getWash(){
        List<Goods> goodsList=goodsService.findByID(21);
        List<GoodsModel> goodsModelList=new ArrayList<GoodsModel>();
        for (Goods list:goodsList){
            GoodsModel goodsModel=new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        return new JsonResult("200",goodsModelList);
    }
//    母婴童装
    @GetMapping(value = "/bady")
    public JsonResult getBady(){
        List<Goods> goodsList=goodsService.findByID(22);
        List<GoodsModel> goodsModelList=new ArrayList<GoodsModel>();
        for (Goods list:goodsList){
            GoodsModel goodsModel=new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        return new JsonResult("200",goodsModelList);
    }
}
