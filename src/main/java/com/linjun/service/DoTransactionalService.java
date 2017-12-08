package com.linjun.service;

import com.linjun.model.CreditDetail;
import com.linjun.model.CreditManger;
import com.linjun.model.Creditbyuser;
import com.linjun.model.Creditgoods;

public interface DoTransactionalService {
    int buycreditGoods(Creditbyuser creditbyuser, CreditManger creditManger, Creditgoods creditgoods, CreditDetail creditDetail);
}
