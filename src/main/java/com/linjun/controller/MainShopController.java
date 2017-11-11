package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.Goods;
import com.linjun.pojo.GoodsModel;
import com.linjun.service.GoodsImageService;
import com.linjun.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@GetMapping(value = "/fish/{page}")
public JsonResult getFish(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(13, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress("http://oz4zfzmr0.bkt.clouddn.com/"+goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        PageBean<GoodsModel> list = new PageBean<GoodsModel>(goodsList.getTotal(), goodsList.getPageNum(), goodsList.getPageSize(), goodsList.getPages(), goodsList.getSize(), goodsModelList);

        return new JsonResult("200", list);
    }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
    }
}

//    蔬菜水果
@GetMapping(value = "/fruits/{page}")
public JsonResult getFruits(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(14, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress("http://oz4zfzmr0.bkt.clouddn.com/"+goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        PageBean<GoodsModel> list = new PageBean<GoodsModel>(goodsList.getTotal(), goodsList.getPageNum(), goodsList.getPageSize(), goodsList.getPages(), goodsList.getSize(), goodsModelList);

        return new JsonResult("200", list);
    }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
    }
}
//    园林花卉
@GetMapping(value = "/flower/{page}")
public JsonResult getFlower(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(15, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress("http://oz4zfzmr0.bkt.clouddn.com/"+goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        PageBean<GoodsModel> list = new PageBean<GoodsModel>(goodsList.getTotal(), goodsList.getPageNum(), goodsList.getPageSize(), goodsList.getPages(), goodsList.getSize(), goodsModelList);

        return new JsonResult("200", list);
    }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
    }
}
//    粮油食品
@GetMapping(value = "/foodstuff/{page}")
public JsonResult getFoodStuff(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(16, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress("http://oz4zfzmr0.bkt.clouddn.com/"+goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        PageBean<GoodsModel> list = new PageBean<GoodsModel>(goodsList.getTotal(), goodsList.getPageNum(), goodsList.getPageSize(), goodsList.getPages(), goodsList.getSize(), goodsModelList);

        return new JsonResult("200", list);
    }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
    }
}
//    农机设备
@GetMapping(value = "/equipment/{page}")
public JsonResult getEquipment(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(17, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress("http://oz4zfzmr0.bkt.clouddn.com/"+goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        PageBean<GoodsModel> list = new PageBean<GoodsModel>(goodsList.getTotal(), goodsList.getPageNum(), goodsList.getPageSize(), goodsList.getPages(), goodsList.getSize(), goodsModelList);

        return new JsonResult("200", list);
    }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
    }
}
//    生态花果
@GetMapping(value = "/seed/{page}")
public JsonResult getSeed(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(18, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress("http://oz4zfzmr0.bkt.clouddn.com/"+goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        PageBean<GoodsModel> list = new PageBean<GoodsModel>(goodsList.getTotal(), goodsList.getPageNum(), goodsList.getPageSize(), goodsList.getPages(), goodsList.getSize(), goodsModelList);

        return new JsonResult("200", list);
    }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
    }
}
//    土地改良
@GetMapping(value = "/soil/{page}")
public JsonResult getSoil(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(19, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress("http://oz4zfzmr0.bkt.clouddn.com/"+goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        PageBean<GoodsModel> list = new PageBean<GoodsModel>(goodsList.getTotal(), goodsList.getPageNum(), goodsList.getPageSize(), goodsList.getPages(), goodsList.getSize(), goodsModelList);

        return new JsonResult("200", list);
    }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
    }
}
//    有机种植
@GetMapping(value = "/plant/{page}")
public JsonResult getPlant(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(20, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress("http://oz4zfzmr0.bkt.clouddn.com/"+goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        PageBean<GoodsModel> list = new PageBean<GoodsModel>(goodsList.getTotal(), goodsList.getPageNum(), goodsList.getPageSize(), goodsList.getPages(), goodsList.getSize(), goodsModelList);

        return new JsonResult("200", list);
    }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
    }
}
//    农副产品
@GetMapping(value = "/coopertion/{page}")
public JsonResult getCoopertion(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(21, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress("http://oz4zfzmr0.bkt.clouddn.com/"+goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        PageBean<GoodsModel> list = new PageBean<GoodsModel>(goodsList.getTotal(), goodsList.getPageNum(), goodsList.getPageSize(), goodsList.getPages(), goodsList.getSize(), goodsModelList);

        return new JsonResult("200", list);
    }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
    }
}
//    虫草药材
@GetMapping(value = "/medicine/{page}")
public JsonResult getMedicine(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(22, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress("http://oz4zfzmr0.bkt.clouddn.com/"+goodsImageService.findMainImage(list.getId()).getIamgeaddress());
            goodsModel.setPrice(list.getMemberprice());
            goodsModel.setSoldamount(list.getSoldamount());
            goodsModelList.add(goodsModel);
        }
        PageBean<GoodsModel> list = new PageBean<GoodsModel>(goodsList.getTotal(), goodsList.getPageNum(), goodsList.getPageSize(), goodsList.getPages(), goodsList.getSize(), goodsModelList);

        return new JsonResult("200", list);
    }catch (Exception e){
        return  new JsonResult("500",e.getMessage());
    }
}

}
