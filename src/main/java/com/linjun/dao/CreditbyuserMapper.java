package com.linjun.dao;

import com.linjun.model.Creditbyuser;
import com.linjun.model.CreditbyuserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditbyuserMapper {
    long countByExample(CreditbyuserCriteria example);

    int deleteByExample(CreditbyuserCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Creditbyuser record);

    int insertSelective(Creditbyuser record);

    List<Creditbyuser> selectByExample(CreditbyuserCriteria example);

    Creditbyuser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Creditbyuser record, @Param("example") CreditbyuserCriteria example);

    int updateByExample(@Param("record") Creditbyuser record, @Param("example") CreditbyuserCriteria example);

    int updateByPrimaryKeySelective(Creditbyuser record);

    int updateByPrimaryKey(Creditbyuser record);
}