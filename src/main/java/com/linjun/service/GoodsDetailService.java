package com.linjun.service;

import com.linjun.model.GoodsDetail;

public interface GoodsDetailService {
  GoodsDetail add(GoodsDetail goodsDetail);
   boolean delete(long id);
   GoodsDetail findByID(long id);

}
