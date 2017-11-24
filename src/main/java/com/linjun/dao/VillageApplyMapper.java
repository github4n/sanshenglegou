package com.linjun.dao;

import com.linjun.model.VillageApply;
import com.linjun.model.VillageApplyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VillageApplyMapper {
    long countByExample(VillageApplyCriteria example);

    int deleteByExample(VillageApplyCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(VillageApply record);

    int insertSelective(VillageApply record);

    List<VillageApply> selectByExample(VillageApplyCriteria example);

    VillageApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VillageApply record, @Param("example") VillageApplyCriteria example);

    int updateByExample(@Param("record") VillageApply record, @Param("example") VillageApplyCriteria example);

    int updateByPrimaryKeySelective(VillageApply record);

    int updateByPrimaryKey(VillageApply record);
    List<VillageApply> dimfind(String temp);
    List<VillageApply> dimfindandstatus(String temp,byte status);
}