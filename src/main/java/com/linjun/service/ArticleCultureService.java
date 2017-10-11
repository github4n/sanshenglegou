package com.linjun.service;

import com.linjun.model.ArticleCulture;

import java.util.List;

public interface ArticleCultureService {
    public  boolean add(ArticleCulture articleCulture);
    public  int deleteByid(long id);
    public  int updateByid(long id,ArticleCulture articleCulture);
    public List<ArticleCulture> findAll();
    public  List<ArticleCulture> findbyid(long id );
}
