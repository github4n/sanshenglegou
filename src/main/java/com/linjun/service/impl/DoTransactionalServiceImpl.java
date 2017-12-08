package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.CreditDetailMapper;
import com.linjun.dao.CreditMangerMapper;
import com.linjun.dao.CreditbyuserMapper;
import com.linjun.dao.CreditgoodsMapper;
import com.linjun.model.CreditDetail;
import com.linjun.model.CreditManger;
import com.linjun.model.Creditbyuser;
import com.linjun.model.Creditgoods;
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



    @Override
    public int buycreditGoods(Creditbyuser creditbyuser, CreditManger creditManger, Creditgoods creditgoods, CreditDetail creditDetail) {
        int result=creditMangerMapper.updateByPrimaryKeySelective(creditManger);
        long result1=creditbyuserMapper.insertSelective(creditbyuser);
        int result2=creditDetailMapper.updateByPrimaryKeySelective(creditDetail);
        int result3=creditgoodsMapper.updateByPrimaryKeySelective(creditgoods);
       if(result>0){
           if (result1>0){
               if (result2>0){
                   if (result3>0){
                       return 1;
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
}
