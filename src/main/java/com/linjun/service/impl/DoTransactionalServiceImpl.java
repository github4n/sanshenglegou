package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.*;
import com.linjun.model.*;
import com.linjun.service.DoTransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DoTransactionalServiceImpl implements DoTransactionalService {
  @Autowired
    CreditDetailMapper creditDetailMapper;
  @Autowired
    CreditMangerMapper creditMangerMapper;
  @Autowired
    CreditbyuserMapper creditbyuserMapper;
  @Autowired
    CreditgoodsMapper creditgoodsMapper;
 @Autowired
    GoodsMapper goodsMapper;
 @Autowired
 OrderMapper orderMapper;
 @Autowired
 CreditorderMapper creditorderMapper;

    @Override
    public int buycreditGoods(Creditbyuser creditbyuser, CreditManger creditManger, Creditgoods creditgoods, CreditDetail creditDetail,Creditorder creditorder) {
        int result=creditMangerMapper.updateByPrimaryKeySelective(creditManger);
        long result1=creditbyuserMapper.insertSelective(creditbyuser);
        int result2=creditDetailMapper.updateByPrimaryKeySelective(creditDetail);
        int result3=creditgoodsMapper.updateByPrimaryKeySelective(creditgoods);
        int result4=creditorderMapper.insertSelective(creditorder);
       if(result>0){
           if (result1>0){
               if (result2>0){
                   if (result3>0){
                       if (result4>0){
                           return 1;
                       }else {
                           throw  new PeopleException("失败");
                       }
                   }else {
                       throw new PeopleException("失败");
                   }
               }else {
                   throw new PeopleException("失败");
               }
           }else {
               throw new PeopleException("失败");
           }
       }else {
           throw new PeopleException("失败");
       }

    }

    @Override
    public int buyGood(Goods goods, Order order) {
        int result=goodsMapper.updateByPrimaryKeySelective(goods);
        int result1=orderMapper.insertSelective(order);
        if (result>0){
            if (result1>0){
                return 1;
            }else {
                throw  new PeopleException("失败");
            }
        }else {
            throw new PeopleException("失败");
        }

    }
}
