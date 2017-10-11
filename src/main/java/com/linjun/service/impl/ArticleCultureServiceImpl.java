package com.linjun.service.impl;

import com.linjun.dao.ArticleCultureMapper;
import com.linjun.model.ArticleCulture;
import com.linjun.model.ArticleCultureCriteria;
import com.linjun.service.ArticleCultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleCultureServiceImpl implements ArticleCultureService {
    @Autowired
    ArticleCultureMapper articleCultureMapper;
    public boolean add(ArticleCulture articleCulture) {
        return articleCultureMapper.insertSelective(articleCulture)>0;
    }

    public int deleteByid(long id) {
        return articleCultureMapper.deleteByPrimaryKey(id);
    }

    public int updateByid(long id,ArticleCulture articleCulture) {
        ArticleCultureCriteria articleCultureCriteria=new ArticleCultureCriteria();
        ArticleCultureCriteria.Criteria criteria=articleCultureCriteria.createCriteria();
        criteria.andIdEqualTo(id);
        return articleCultureMapper.updateByExampleSelective(articleCulture,articleCultureCriteria);
    }

    public List<ArticleCulture> findAll() {
        ArticleCultureCriteria articleCultureCriteria=new ArticleCultureCriteria();
        ArticleCultureCriteria.Criteria criteria=articleCultureCriteria.createCriteria();
        return articleCultureMapper.selectByExample(articleCultureCriteria);
    }

    public List<ArticleCulture> findbyid(long id) {
        ArticleCultureCriteria articleCultureCriteria=new ArticleCultureCriteria();
        ArticleCultureCriteria.Criteria criteria=articleCultureCriteria.createCriteria();
        criteria.andIdEqualTo(id);
        return articleCultureMapper.selectByExample(articleCultureCriteria);
    }
}
