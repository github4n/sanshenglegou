package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.entity.PageBean;
import com.linjun.model.Goods;
import com.linjun.pojo.GoodsModel;
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
//食品保健
    @GetMapping(value = "/food/{page}")
    public JsonResult getfish(@PathVariable int page){
        try {
            PageBean<Goods> goodsList = goodsService.findByID(3, page, 30);
            List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
            for (Goods list : goodsList.getList()) {
                GoodsModel goodsModel = new GoodsModel();
                goodsModel.setId(list.getId());
                goodsModel.setGoodsName(list.getGoodsname());
                goodsModel.setImageaddress(goodsImageService.findimage(list.getId()));
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
//    美容护理
@GetMapping(value = "/nurse/{page}")
public JsonResult getnurse(@PathVariable int page){
        try {
            PageBean<Goods> goodsList = goodsService.findByID(4, page, 30);
            List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
            for (Goods list : goodsList.getList()) {
                GoodsModel goodsModel = new GoodsModel();
                goodsModel.setId(list.getId());
                goodsModel.setGoodsName(list.getGoodsname());
                goodsModel.setImageaddress(goodsImageService.findimage(list.getId()));
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
//    手机数码
@GetMapping(value = "/phone/{page}")
public JsonResult getPhone(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(5, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findimage(list.getId()));
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
//    装修建材
@GetMapping(value = "/finish/{page}")
public JsonResult getFinish(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(6, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findimage(list.getId()));
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
//    男女服饰
@GetMapping(value = "/cloth/{page}")
public JsonResult getCloth(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(7, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findimage(list.getId()));
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
//    鞋帽箱包
@GetMapping(value = "/shoe/{page}")
public JsonResult getShoe(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(8, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findimage(list.getId()));
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
//    饰品摆件
@GetMapping(value = "/accessories/{page}")
public JsonResult getAccessories(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(9, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findimage(list.getId()));
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
//    珠宝首饰
@GetMapping(value = "/jewlry/{page}")
public JsonResult getJewlry(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(10, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findimage(list.getId()));
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
//    日用刚需
@GetMapping(value = "/wash/{page}")
public JsonResult getWash(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(11, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findimage(list.getId()));
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
//    母婴童装
@GetMapping(value = "/bady/{page}")
public JsonResult getBady(@PathVariable int page){
    try {
        PageBean<Goods> goodsList = goodsService.findByID(12, page, 30);
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Goods list : goodsList.getList()) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setId(list.getId());
            goodsModel.setGoodsName(list.getGoodsname());
            goodsModel.setImageaddress(goodsImageService.findimage(list.getId()));
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
