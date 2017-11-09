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
@RequestMapping(value = "/mainShop")
public class MainShopController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsImageService goodsImageService;
//    鱼禽肉蛋
    @GetMapping(value = "/fish")
    public JsonResult getfish(){
        List<Goods> goodsList=goodsService.findByID(3);
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

//    蔬菜水果
    @GetMapping(value = "/fruits")
    public  JsonResult getFruits(){
        List<Goods> goodsList=goodsService.findByID(4);
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
//    园林花卉
    @GetMapping(value = "/flower")
    public  JsonResult getFlower(){
        List<Goods> goodsList=goodsService.findByID(5);
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
//    粮油食品
    @GetMapping(value = "/foodstuff")
    public  JsonResult getFoodstuff(){
        List<Goods> goodsList=goodsService.findByID(6);
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
//    农机设备
    @GetMapping(value = "/equipment")
    public  JsonResult getEquipment(){
        List<Goods> goodsList=goodsService.findByID(7);
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
//    生态花果
    @GetMapping(value = "/seed")
    public  JsonResult getSeed(){
        List<Goods> goodsList=goodsService.findByID(8);
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
//    土地改良
    @GetMapping(value = "/soil")
    public  JsonResult getSoil(){
        List<Goods> goodsList=goodsService.findByID(9);
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
//    有机种植
    @GetMapping(value = "/plant")
    public  JsonResult getPlant(){
        List<Goods> goodsList=goodsService.findByID(10);
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
//    农副产品
    @GetMapping(value = "/coopertion")
    public  JsonResult getCoopertion(){
        List<Goods> goodsList=goodsService.findByID(11);
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
//    虫草药材
    @GetMapping(value = "/medicine")
    public  JsonResult getMedicine(){
        List<Goods> goodsList=goodsService.findByID(12);
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
