package com.linjun.dao;

import com.linjun.model.Suggest;
import com.linjun.model.SuggestCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuggestMapper {
    long countByExample(SuggestCriteria example);

    int deleteByExample(SuggestCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Suggest record);

    int insertSelective(Suggest record);

    List<Suggest> selectByExample(SuggestCriteria example);

    Suggest selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Suggest record, @Param("example") SuggestCriteria example);

    int updateByExample(@Param("record") Suggest record, @Param("example") SuggestCriteria example);

    int updateByPrimaryKeySelective(Suggest record);

    int updateByPrimaryKey(Suggest record);
}