package com.linjun;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.util.Properties;

@SpringBootApplication
@MapperScan("com.linjun.dao")
@EnableAutoConfiguration
@EnableCaching
@EnableTransactionManagement
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


}

