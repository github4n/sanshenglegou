package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.model.Goods;
import com.linjun.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;


}
