package com.linjun.dao;

import com.linjun.model.Coupan;
import com.linjun.model.CoupanCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoupanMapper {
    long countByExample(CoupanCriteria example);

    int deleteByExample(CoupanCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Coupan record);

    int insertSelective(Coupan record);

    List<Coupan> selectByExample(CoupanCriteria example);

    Coupan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Coupan record, @Param("example") CoupanCriteria example);

    int updateByExample(@Param("record") Coupan record, @Param("example") CoupanCriteria example);

    int updateByPrimaryKeySelective(Coupan record);

    int updateByPrimaryKey(Coupan record);
}