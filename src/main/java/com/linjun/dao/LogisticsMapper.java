package com.linjun.dao;

import com.linjun.model.Logistics;
import com.linjun.model.LogisticsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogisticsMapper {
    long countByExample(LogisticsCriteria example);

    int deleteByExample(LogisticsCriteria example);

    int insert(Logistics record);

    int insertSelective(Logistics record);

    List<Logistics> selectByExample(LogisticsCriteria example);

    int updateByExampleSelective(@Param("record") Logistics record, @Param("example") LogisticsCriteria example);

    int updateByExample(@Param("record") Logistics record, @Param("example") LogisticsCriteria example);
}