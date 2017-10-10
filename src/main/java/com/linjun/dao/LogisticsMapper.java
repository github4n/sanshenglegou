package com.linjun.dao;

import com.linjun.model.Logistics;
import com.linjun.model.LogisticsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticsMapper {
    long countByExample(LogisticsCriteria example);

    int deleteByExample(LogisticsCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Logistics record);

    int insertSelective(Logistics record);

    List<Logistics> selectByExample(LogisticsCriteria example);

    Logistics selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Logistics record, @Param("example") LogisticsCriteria example);

    int updateByExample(@Param("record") Logistics record, @Param("example") LogisticsCriteria example);

    int updateByPrimaryKeySelective(Logistics record);

    int updateByPrimaryKey(Logistics record);
}