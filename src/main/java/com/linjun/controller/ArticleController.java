package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.model.Article;
import com.linjun.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @PostMapping(value = "/add")
    public JsonResult add(@RequestParam(value = "title",required = false)String title,
                          @RequestParam(value = "content",required = false)String content){
        try{
            Article article=new Article();
            article.setContent(content);
            article.setTitle(title);
            article.setLooksum((long)0);
            return  new JsonResult("200",article);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
    }
    @PutMapping(value = "/update")
    public  JsonResult update(@RequestParam(value = "id",required = false)long id,
                              @RequestParam(value = "title",required = false)String title,
                              @RequestParam(value = "content",required = false)String content){
        try{
            Article article=new Article();
            article.setTitle(title);
            article.setContent(content);
            articleService.updateByuserid(id,article);
            return  new JsonResult("200",article);
        }catch (Exception e){
            return new JsonResult("500",e.getMessage());
        }
    }
   @DeleteMapping(value = "/delete/{id}")
    public  JsonResult delete(@PathVariable long id){
        try{
            articleService.deleteByuserid(id);
            return  new JsonResult("200","删除成功");
        }
        catch (Exception e){
            return new JsonResult("500",e.getMessage());
        }
   }
   @GetMapping(value = "/findAll")
    public  JsonResult findAll(){
       List<Article> list=articleService.findAll();
     return new JsonResult("200","成功",list);
   }

}
