package com.linjun.dao;

import com.linjun.model.Article;
import com.linjun.model.ArticleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    long countByExample(ArticleCriteria example);

    int deleteByExample(ArticleCriteria example);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleCriteria example);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleCriteria example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleCriteria example);
}