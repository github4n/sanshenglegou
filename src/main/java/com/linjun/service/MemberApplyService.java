package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.MemberApply;

import java.util.List;

public interface MemberApplyService {
    PageBean<MemberApply> findAll(int currentpage,int pagesize);
    Long countMapply();


}
