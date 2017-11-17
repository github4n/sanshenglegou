package com.linjun.service;

import com.linjun.model.GoodsDetail;

import java.util.List;

public interface GoodsDetailService {
  GoodsDetail add(GoodsDetail goodsDetail);
   boolean delete(long id);
   GoodsDetail findByID(long id);

}
