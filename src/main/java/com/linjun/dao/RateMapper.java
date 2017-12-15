package com.linjun.dao;

import com.linjun.model.Rate;
import com.linjun.model.RateCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RateMapper {
    long countByExample(RateCriteria example);

    int deleteByExample(RateCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Rate record);

    int insertSelective(Rate record);

    List<Rate> selectByExample(RateCriteria example);

    Rate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Rate record, @Param("example") RateCriteria example);

    int updateByExample(@Param("record") Rate record, @Param("example") RateCriteria example);

    int updateByPrimaryKeySelective(Rate record);

    int updateByPrimaryKey(Rate record);
}