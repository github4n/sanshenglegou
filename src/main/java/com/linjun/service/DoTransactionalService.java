package com.linjun.service;

import com.linjun.model.*;

public interface DoTransactionalService {
    int buycreditGoods(Creditbyuser creditbyuser, CreditManger creditManger, Creditgoods creditgoods, CreditDetail creditDetail);
    int buyGood(Goods goods,Order order);
}
