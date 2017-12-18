package com.linjun.dao;

import com.linjun.model.Creditorder;
import com.linjun.model.CreditorderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditorderMapper {
    long countByExample(CreditorderCriteria example);

    int deleteByExample(CreditorderCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Creditorder record);

    int insertSelective(Creditorder record);

    List<Creditorder> selectByExample(CreditorderCriteria example);

    Creditorder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Creditorder record, @Param("example") CreditorderCriteria example);

    int updateByExample(@Param("record") Creditorder record, @Param("example") CreditorderCriteria example);

    int updateByPrimaryKeySelective(Creditorder record);

    int updateByPrimaryKey(Creditorder record);
}