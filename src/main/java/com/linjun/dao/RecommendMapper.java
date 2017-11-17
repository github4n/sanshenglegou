package com.linjun.dao;

import com.linjun.model.Recommend;
import com.linjun.model.RecommendCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendMapper {
    long countByExample(RecommendCriteria example);

    int deleteByExample(RecommendCriteria example);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    List<Recommend> selectByExample(RecommendCriteria example);

    int updateByExampleSelective(@Param("record") Recommend record, @Param("example") RecommendCriteria example);

    int updateByExample(@Param("record") Recommend record, @Param("example") RecommendCriteria example);
}