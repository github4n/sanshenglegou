package com.linjun.dao;

import com.linjun.model.Recommend;
import com.linjun.model.RecommendCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendMapper {
    long countByExample(RecommendCriteria example);

    int deleteByExample(RecommendCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    List<Recommend> selectByExample(RecommendCriteria example);

    Recommend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Recommend record, @Param("example") RecommendCriteria example);

    int updateByExample(@Param("record") Recommend record, @Param("example") RecommendCriteria example);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);
}