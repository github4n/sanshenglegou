package com.linjun.dao;

import com.linjun.model.Evaluate;
import com.linjun.model.EvaluateCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvaluateMapper {
    long countByExample(EvaluateCriteria example);

    int deleteByExample(EvaluateCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    List<Evaluate> selectByExample(EvaluateCriteria example);

    Evaluate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Evaluate record, @Param("example") EvaluateCriteria example);

    int updateByExample(@Param("record") Evaluate record, @Param("example") EvaluateCriteria example);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);
}