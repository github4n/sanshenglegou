package com.linjun.dao;

import com.linjun.model.Offline;
import com.linjun.model.OfflineCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfflineMapper {
    long countByExample(OfflineCriteria example);

    int deleteByExample(OfflineCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Offline record);

    int insertSelective(Offline record);

    List<Offline> selectByExample(OfflineCriteria example);

    Offline selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Offline record, @Param("example") OfflineCriteria example);

    int updateByExample(@Param("record") Offline record, @Param("example") OfflineCriteria example);

    int updateByPrimaryKeySelective(Offline record);

    int updateByPrimaryKey(Offline record);
}