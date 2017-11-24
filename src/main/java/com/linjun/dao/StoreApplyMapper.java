package com.linjun.dao;

import com.linjun.model.StoreApply;
import com.linjun.model.StoreApplyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreApplyMapper {
    long countByExample(StoreApplyCriteria example);

    int deleteByExample(StoreApplyCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(StoreApply record);

    int insertSelective(StoreApply record);

    List<StoreApply> selectByExample(StoreApplyCriteria example);

    StoreApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StoreApply record, @Param("example") StoreApplyCriteria example);

    int updateByExample(@Param("record") StoreApply record, @Param("example") StoreApplyCriteria example);

    int updateByPrimaryKeySelective(StoreApply record);

    int updateByPrimaryKey(StoreApply record);
    List<StoreApply> dimfind(String temp);
    List<StoreApply> dimfindandstatus(String temp,byte status);
}