package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.ArticleMapper;
import com.linjun.model.Article;
import com.linjun.model.ArticleCriteria;
import com.linjun.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    public boolean add(Article article) {
        return articleMapper.insertSelective(article)>0;
    }

    public int deleteByuserid(long id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    public int updateByuserid(long id, Article article) {
//        ArticleCriteria articleCriteria=new ArticleCriteria();
//        ArticleCriteria.Criteria criteria=articleCriteria.createCriteria();
//        criteria.andIdEqualTo(id);
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    public List<Article> findAll() {

        ArticleCriteria articleCriteria=new ArticleCriteria();
        return articleMapper.selectByExample(articleCriteria);
    }

    @Override
    public Article update(Article article) {
        int result=articleMapper.updateByPrimaryKeySelective(article);
        if (result>0){
            return findByID(article.getId());
        }else {
            throw  new PeopleException("更新失败");
        }
    }

    @Override
    public Article addArticle(Article article) {
        int result=articleMapper.insertSelective(article);

        if (result>0){
            Article article1=articleMapper.selectByPrimaryKey((long) result);
           System.out.println(article1.toString());
            System.out.println(article.toString());
            return article1;
        }else {
            throw  new PeopleException("增加文章失败");
        }
    }

    @Override
    public Article findByID(long id) {
        return articleMapper.selectByPrimaryKey(id);
    }
}
