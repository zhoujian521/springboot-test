package com.zjpower.springboot.config;

import com.zjpower.springboot.interceptor.AbcInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private AbcInterceptor abcInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] addPathPatterns = {
                "/lanjie/**"
        };
        String[] excludePathPatterns = {
                "/lanjie/randomAdd"
        };
        registry.addInterceptor(abcInterceptor).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
