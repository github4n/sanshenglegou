package com.linjun.dao;

import com.linjun.model.Collect;
import com.linjun.model.CollectCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectMapper {
    long countByExample(CollectCriteria example);

    int deleteByExample(CollectCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectCriteria example);

    Collect selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectCriteria example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectCriteria example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}