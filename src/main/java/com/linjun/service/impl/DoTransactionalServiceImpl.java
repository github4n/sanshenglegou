package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.*;
import com.linjun.model.*;
import com.linjun.pojo.PayOrder;
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
    public PayOrder buyGood(Goods goods, Order order) {
        int result=goodsMapper.updateByPrimaryKeySelective(goods);
        int result1=orderMapper.insertSelective(order);
        if (result>0){
            if (result1>0){
              PayOrder payOrder=new PayOrder();
               payOrder.setOrderid(result1);
               payOrder.setOrdername(order.getGoodsname());
               payOrder.setPrivce(order.getPricesum());
                return payOrder;
            }else {
                throw  new PeopleException("失败");
            }
        }else {
            throw new PeopleException("失败");
        }

    }

    @Override
    public int Complete(Order order, CreditManger creditManger, CreditDetail creditDetail) {
       int result=orderMapper.updateByPrimaryKeySelective(order);
       CreditManger isexit=creditMangerMapper.selectByPrimaryKey(creditManger.getUserid());
       int result2=creditDetailMapper.insertSelective(creditDetail);
       if (result>0){
         if (isexit==null){
             long result3=creditMangerMapper.insertSelective(creditManger);
             if (result3>0){
              CreditDetail creditDetail1=creditDetailMapper.selectByPrimaryKey(result3);
               if (creditDetail1!=null){
                   int result4=creditDetailMapper.updateByPrimaryKeySelective(creditDetail);
                   if (result4>0){
                       return 1;
                   }else {
                       throw new PeopleException("失败");
                   }
               }else {
                   int result4=creditDetailMapper.insertSelective(creditDetail);
                   if (result4>0){
                       return 1;
                   }else {
                       throw new PeopleException("失败");
                   }
               }


             }else {
                 throw  new PeopleException("失败");
             }


         }else {
            long result3=creditMangerMapper.updateByPrimaryKeySelective(creditManger);
            if (result3>0){


                CreditDetail creditDetail1=creditDetailMapper.selectByPrimaryKey(result3);
                if (creditDetail1!=null){
                    int result4=creditDetailMapper.updateByPrimaryKeySelective(creditDetail);
                    if (result4>0){
                        return 1;
                    }else {
                        throw new PeopleException("失败");
                    }
                }else {
                    int result4=creditDetailMapper.insertSelective(creditDetail);
                    if (result4>0){
                        return 1;
                    }else {
                        throw new PeopleException("失败");
                    }
                }

            }else {
                throw  new PeopleException("失败");
            }


         }


       }else {
           throw new PeopleException("失败");
       }

    }
}
