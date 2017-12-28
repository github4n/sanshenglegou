package com.linjun.service;

import com.linjun.model.*;
import com.linjun.pojo.PayOrder;

public interface DoTransactionalService {
    int buycreditGoods(Creditbyuser creditbyuser, CreditManger creditManger, Creditgoods creditgoods, CreditDetail creditDetail,Creditorder creditorder);
    PayOrder buyGood(Goods goods, Order order);
    int Complete(Order order,CreditManger creditManger,CreditDetail creditDetail);
}
