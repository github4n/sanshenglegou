package com.linjun.dao;

import com.linjun.model.CreditDetail;
import com.linjun.model.CreditDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditDetailMapper {
    long countByExample(CreditDetailCriteria example);

    int deleteByExample(CreditDetailCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(CreditDetail record);

    int insertSelective(CreditDetail record);

    List<CreditDetail> selectByExample(CreditDetailCriteria example);

    CreditDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CreditDetail record, @Param("example") CreditDetailCriteria example);

    int updateByExample(@Param("record") CreditDetail record, @Param("example") CreditDetailCriteria example);

    int updateByPrimaryKeySelective(CreditDetail record);

    int updateByPrimaryKey(CreditDetail record);
}