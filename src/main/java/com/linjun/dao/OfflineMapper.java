package com.linjun.dao;

import com.linjun.model.Offline;
import com.linjun.model.OfflineCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfflineMapper {
    long countByExample(OfflineCriteria example);

    int deleteByExample(OfflineCriteria example);

    int insert(Offline record);

    int insertSelective(Offline record);

    List<Offline> selectByExample(OfflineCriteria example);

    int updateByExampleSelective(@Param("record") Offline record, @Param("example") OfflineCriteria example);

    int updateByExample(@Param("record") Offline record, @Param("example") OfflineCriteria example);
}