package com.linjun.dao;

import com.linjun.model.Outcome;
import com.linjun.model.OutcomeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutcomeMapper {
    long countByExample(OutcomeCriteria example);

    int deleteByExample(OutcomeCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Outcome record);

    int insertSelective(Outcome record);

    List<Outcome> selectByExample(OutcomeCriteria example);

    Outcome selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Outcome record, @Param("example") OutcomeCriteria example);

    int updateByExample(@Param("record") Outcome record, @Param("example") OutcomeCriteria example);

    int updateByPrimaryKeySelective(Outcome record);

    int updateByPrimaryKey(Outcome record);
}