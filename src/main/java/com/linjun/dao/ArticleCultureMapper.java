package com.linjun.dao;

import com.linjun.model.ArticleCulture;
import com.linjun.model.ArticleCultureCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleCultureMapper {
    long countByExample(ArticleCultureCriteria example);

    int deleteByExample(ArticleCultureCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleCulture record);

    int insertSelective(ArticleCulture record);

    List<ArticleCulture> selectByExample(ArticleCultureCriteria example);

    ArticleCulture selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleCulture record, @Param("example") ArticleCultureCriteria example);

    int updateByExample(@Param("record") ArticleCulture record, @Param("example") ArticleCultureCriteria example);

    int updateByPrimaryKeySelective(ArticleCulture record);

    int updateByPrimaryKey(ArticleCulture record);
}