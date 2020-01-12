package com.ynet.fullview.configurer;

import com.ynet.fullview.interceptor.LoginInterceptor;
import com.ynet.fullview.util.IDUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        List<String> excludePath = new ArrayList<String>();
//        excludePath.add("/user/signin.do");
//        excludePath.add("/user/signup.do");
//        excludePath.add("/admin/signin.do");
//        excludePath.add("/css/*");
//        excludePath.add("/fonts/*");
//        excludePath.add("/js/*");
//        excludePath.add("/index.html");
//        excludePath.add("/tree.png");
//
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*").excludePathPatterns(excludePath);

    }

}

