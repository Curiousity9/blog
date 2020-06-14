package com.example.blog.lrm.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiangwenhao
 * create 2020/5/16
 */
@Configuration//配置类
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( new LoginInterceptor())
                .addPathPatterns("/admin/**")//忽视的
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");//排除忽视网页


    }
}
