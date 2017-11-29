package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.service.GoodsDetailService;
import com.linjun.service.GoodsImageService;
import com.linjun.service.GoodsService;
import com.qiniu.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsImageService goodsImageService;
    @Autowired
    GoodsDetailService goodsDetailService;





}
