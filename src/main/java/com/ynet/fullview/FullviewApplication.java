package com.ynet.fullview;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.ynet.fullview.dao")
@Slf4j
public class FullviewApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FullviewApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(FullviewApplication.class, args);
//        log.info("测试日志打印：{},{}","功能","路径");
    }

}

