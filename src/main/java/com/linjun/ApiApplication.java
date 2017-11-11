package com.linjun;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.util.Properties;

@SpringBootApplication
@MapperScan("com.linjun.dao")
@EnableAutoConfiguration
@EnableCaching

public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
    @Bean
     public PageHelper pageHelper(){
               PageHelper pageHelper = new PageHelper();
                Properties properties = new Properties();
               properties.setProperty("offsetAsPageNum","true");
                properties.setProperty("rowBoundsWithCount","true");
                 properties.setProperty("reasonable","true");
                 properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
                pageHelper.setProperties(properties);
                 return pageHelper;
             }
//    @Bean(name = "multipartResolver")
//    public MultipartResolver multipartResolver()
//    {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        // resolver.setDefaultEncoding("UTF-8");
//        // resolver.setResolveLazily(true);// resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
//        // resolver.setMaxInMemorySize(40960);
//        resolver.setMaxUploadSize(10 * 1024 * 1024);// 上传文件大小 5M 5*1024*1024
//        return resolver;
//    }

}

