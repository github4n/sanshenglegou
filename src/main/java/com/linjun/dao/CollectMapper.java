package com.linjun.dao;

import com.linjun.model.Collect;
import com.linjun.model.CollectCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectMapper {
    long countByExample(CollectCriteria example);

    int deleteByExample(CollectCriteria example);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectCriteria example);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectCriteria example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectCriteria example);
}