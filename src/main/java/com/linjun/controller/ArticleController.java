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
//添加文章
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
//    更新文章
    @PutMapping(value = "/update")
    public  JsonResult update(
            @RequestBody Article article
    ){
        try{
             articleService.update(article);
            return  new JsonResult("200",article);
        }catch (Exception e){
            return new JsonResult("500",e.getMessage());
        }
    }
//    删除文章
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
//   获得所有文章
   @GetMapping(value = "/findAll")
    public  JsonResult findAll(){
       List<Article> list=articleService.findAll();
     return new JsonResult("200","成功",list);
   }

}
