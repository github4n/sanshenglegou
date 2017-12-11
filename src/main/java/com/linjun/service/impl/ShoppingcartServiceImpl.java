package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
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
    public ShoppingCart add(ShoppingCart shoppingCart) {

        if (!isExit(shoppingCart)){
            long result=shoppingCartMapper.insertSelective(shoppingCart);
            if (result>0){
                return shoppingCartMapper.selectByPrimaryKey(result);
            }else {
                throw new PeopleException("添加失败");
            }
        }else {
            throw  new PeopleException("已经存在购物车");
        }

    }

    public int deletebygoodsid(long goodsID,long userid) {
        ShoppingCartCriteria shoppingCartCriteria=new ShoppingCartCriteria();
        ShoppingCartCriteria.Criteria criteria=shoppingCartCriteria.createCriteria();
        criteria.andGoodsidEqualTo(goodsID);
        criteria.andUseridEqualTo(userid);
        int result=shoppingCartMapper.deleteByExample(shoppingCartCriteria);
        if (result>0){
            return result;
        }else {
            throw new PeopleException("删除失败");
        }
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

    public List<ShoppingCart> findByuserid(long userid) {

        ShoppingCartCriteria shoppingCartCriteria=new ShoppingCartCriteria();
        ShoppingCartCriteria.Criteria criteria=shoppingCartCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<ShoppingCart>list= shoppingCartMapper.selectByExample(shoppingCartCriteria);
        if (list!=null&&list.size()>0){
            return list;
        }else {
            throw new PeopleException("查询失败");
        }
    }

    @Override
    public ShoppingCart addCart(ShoppingCart shoppingCart) {
        int result=shoppingCartMapper.insertSelective(shoppingCart);
        if (result>0){
            return  shoppingCartMapper.selectByPrimaryKey((long) result);
        }else {
            throw new PeopleException("加入购物车失败");
        }


    }

    @Override
    public int deleteByid(ShoppingCart shoppingCart) {
        int result=shoppingCartMapper.deleteByPrimaryKey(shoppingCart.getId());
        if (result>0){
            return result;
        }else {
            throw new PeopleException("删除失败");
        }
    }

    @Override
    public int deleteByList(List<ShoppingCart> shoppingCart) {
        int temp=0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            int result=shoppingCartMapper.deleteByPrimaryKey(shoppingCart.get(i).getId());
            if (result>0){
                temp+=1;
            }else {

            }
        }
        if (temp==shoppingCart.size()){
            return  shoppingCart.size();
        }else {
            throw  new PeopleException("批量删除失败");
        }

    }

    @Override
    public boolean isExit(ShoppingCart shoppingCart) {
           ShoppingCartCriteria shoppingCartCriteria=new ShoppingCartCriteria();
        ShoppingCartCriteria.Criteria criteria=shoppingCartCriteria.createCriteria();
        criteria.andUseridEqualTo(shoppingCart.getUserid());
        criteria.andGoodsidEqualTo(shoppingCart.getGoodsid());
        List<ShoppingCart> list=shoppingCartMapper.selectByExample(shoppingCartCriteria);
        if (list!=null&&list.size()>0) {
            return  true;
        }else {
            return  false;
        }
    }

}
