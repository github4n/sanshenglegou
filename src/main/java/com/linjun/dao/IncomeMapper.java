package com.linjun.dao;

import com.linjun.model.Income;
import com.linjun.model.IncomeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncomeMapper {
    long countByExample(IncomeCriteria example);

    int deleteByExample(IncomeCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Income record);

    int insertSelective(Income record);

    List<Income> selectByExample(IncomeCriteria example);

    Income selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Income record, @Param("example") IncomeCriteria example);

    int updateByExample(@Param("record") Income record, @Param("example") IncomeCriteria example);

    int updateByPrimaryKeySelective(Income record);

    int updateByPrimaryKey(Income record);
    List<Income> dimfind(Long temp);
    List<Income> dimfindandstatus(Long temp,byte status);
    List<Income> dimfindStrStatus(String temp,byte status);
}