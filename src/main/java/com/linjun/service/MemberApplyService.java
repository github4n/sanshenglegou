package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.MemberApply;

import java.util.List;

public interface MemberApplyService {
    PageBean<MemberApply> findAll(int currentpage,int pagesize);
    Long countMapply();
    MemberApply update(MemberApply memberApply);
    int delete(long id);
    PageBean<MemberApply> findByStatus(byte status,int currentpage,int pagesize);
    Long countByStatus(byte status);
    PageBean<MemberApply> findBy(String condition,int currentpage,int pagesize);
}
