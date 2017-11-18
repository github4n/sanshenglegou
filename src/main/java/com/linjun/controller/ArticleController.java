package com.linjun.controller;

import com.linjun.common.JsonResult;
import com.linjun.model.Article;
import com.linjun.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.UUID;

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
           Article li= articleService.addArticle(article);
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
           Article article1=  articleService.update(article);
            return  new JsonResult("200",article1);
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
   @PostMapping(value = "/adds" ,consumes = "application/json")

   public JsonResult adds(@RequestBody Article article){
       try{
           Article article1=new Article();
           article1.setContent(article.getContent());
           article1.setTitle(article.getTitle());
           Article li= articleService.addArticle(article1);
           return  new JsonResult("200",article);
       }catch (Exception e){
           return  new JsonResult("500",e.getMessage());
       }
   }
  @PostMapping(value = "/updataimage",produces = "application/json;charset=utf-8")
  @ResponseBody
    public JsonResult updataimage(@RequestParam(value = "file") MultipartFile files[]){

      String filePath="/Users/linjun/deaProjects/image/";

//      }
      for (int i = 0; i < files.length; i++) {
          String fileName = files[i].getOriginalFilename();
          String stuffxName = fileName.substring(fileName.lastIndexOf("."));
          fileName = UUID.randomUUID() + stuffxName;
          fileName = System.currentTimeMillis() + fileName;
          File dest = new File(filePath + fileName);
          if (!dest.getParentFile().exists()) {
              dest.getParentFile().mkdirs();
          }
          try {
              files[i].transferTo(dest);
          } catch (IOException e) {

          }

      }

     return new JsonResult("200","dasfsd");
  }
    @RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file")MultipartFile file){
        if(!file.isEmpty()){
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            }catch(FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败,"+e.getMessage();
            }catch (IOException e) {
                e.printStackTrace();
                return "上传失败,"+e.getMessage();
            }

            return "上传成功";

        }else{

            return "上传失败，因为文件是空的.";

        }
    }
      @GetMapping(value = "/find")
    public  JsonResult findByID(
            @RequestParam(value = "id")long id
      ){
        try{
            Article article=articleService.findByID(id);

            return  new JsonResult("200",article);
        }catch (Exception e){
            return  new JsonResult("500",e.getMessage());
        }
      }



}
