package com.linjun.dao;

import com.linjun.model.SiglnDetail;
import com.linjun.model.SiglnDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SiglnDetailMapper {
    long countByExample(SiglnDetailCriteria example);

    int deleteByExample(SiglnDetailCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SiglnDetail record);

    int insertSelective(SiglnDetail record);

    List<SiglnDetail> selectByExample(SiglnDetailCriteria example);

    SiglnDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SiglnDetail record, @Param("example") SiglnDetailCriteria example);

    int updateByExample(@Param("record") SiglnDetail record, @Param("example") SiglnDetailCriteria example);

    int updateByPrimaryKeySelective(SiglnDetail record);

    int updateByPrimaryKey(SiglnDetail record);
}