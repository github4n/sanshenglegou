package com.linjun.service;

import com.linjun.model.Creditbyuser;

import java.util.List;

public interface CreditByUserService {
    Creditbyuser add(Creditbyuser creditbyuser);
    List<Creditbyuser> findbyuseri(long userid);

}
