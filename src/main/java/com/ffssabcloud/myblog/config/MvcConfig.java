package com.ffssabcloud.myblog.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ffssabcloud.myblog.interceptor.BaseInterceptor;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{
    
    @Resource
    private BaseInterceptor baseInterceptor;
    
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor);
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login_error").setViewName("auth/login_error");
        registry.addViewController("/login_success").setViewName("auth/login_success");
    }

}
