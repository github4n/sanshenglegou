package com.linjun.service;

import com.linjun.model.Article;

import java.util.List;

public interface ArticleService {
    public  boolean add(Article article);
    public  int deleteByuserid(long id);
    public  int updateByuserid(long id,Article article);
    public List<Article> findAll();

}
