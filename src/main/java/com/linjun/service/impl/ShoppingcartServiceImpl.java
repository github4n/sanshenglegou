package com.linjun.service.impl;

import com.linjun.dao.ShoppingCartMapper;
import com.linjun.model.ShoppingCart;
import com.linjun.model.ShoppingCartCriteria;
import com.linjun.service.ShoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShoppingcartServiceImpl implements ShoppingcartService {
    @Autowired
    ShoppingCartMapper shoppingCartMapper;
    public boolean add(ShoppingCart shoppingCart) {
        return shoppingCartMapper.insertSelective(shoppingCart)>0;
    }

    public int deletebygoodsid(long goodsID) {
        ShoppingCartCriteria shoppingCartCriteria=new ShoppingCartCriteria();
        ShoppingCartCriteria.Criteria criteria=shoppingCartCriteria.createCriteria();
        criteria.andGoodsidEqualTo(goodsID);

        return shoppingCartMapper.deleteByExample(shoppingCartCriteria);
    }

    public List<ShoppingCart> findAll() {

        ShoppingCartCriteria shoppingCartCriteria=new ShoppingCartCriteria();
        ShoppingCartCriteria.Criteria criteria=shoppingCartCriteria.createCriteria();
        return shoppingCartMapper.selectByExample(shoppingCartCriteria);
    }

    public List<ShoppingCart> findBygooid(long id) {
        ShoppingCartCriteria shoppingCartCriteria=new ShoppingCartCriteria();
        ShoppingCartCriteria.Criteria criteria=shoppingCartCriteria.createCriteria();
        criteria.andIdEqualTo(id);
        return shoppingCartMapper.selectByExample(shoppingCartCriteria);
    }

    public int updatebyGoodsId(long id, ShoppingCart shoppingCart) {
        ShoppingCartCriteria shoppingCartCriteria=new ShoppingCartCriteria();
        ShoppingCartCriteria.Criteria criteria=shoppingCartCriteria.createCriteria();
        criteria.andIdEqualTo(id);
        return shoppingCartMapper.updateByExampleSelective(shoppingCart,shoppingCartCriteria);
    }
}
