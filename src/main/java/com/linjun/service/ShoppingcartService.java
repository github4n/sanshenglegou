package com.linjun.service;

import com.linjun.model.ShoppingCart;

import java.util.List;

public interface ShoppingcartService {
    public  ShoppingCart add(ShoppingCart shoppingCart);
    public  int deletebygoodsid(long goodsID,long userid);
    public List<ShoppingCart> findAll();
    public  List<ShoppingCart> findBygooid(long id);
    public  int updatebyGoodsId(long id,ShoppingCart shoppingCart);
    public  List<ShoppingCart> findByuserid(long userid);
    ShoppingCart addCart(ShoppingCart shoppingCart);
    int deleteByid(ShoppingCart shoppingCart);
    int deleteByList(List<ShoppingCart> shoppingCart);
    boolean isExit(ShoppingCart shoppingCart);
}
