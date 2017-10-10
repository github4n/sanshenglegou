package com.linjun.dao;

import com.linjun.model.CreditManger;
import com.linjun.model.CreditMangerCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditMangerMapper {
    long countByExample(CreditMangerCriteria example);

    int deleteByExample(CreditMangerCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(CreditManger record);

    int insertSelective(CreditManger record);

    List<CreditManger> selectByExample(CreditMangerCriteria example);

    CreditManger selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CreditManger record, @Param("example") CreditMangerCriteria example);

    int updateByExample(@Param("record") CreditManger record, @Param("example") CreditMangerCriteria example);

    int updateByPrimaryKeySelective(CreditManger record);

    int updateByPrimaryKey(CreditManger record);
}