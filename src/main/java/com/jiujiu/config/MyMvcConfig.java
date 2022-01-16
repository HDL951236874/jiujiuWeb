package com.jiujiu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("welcome");
        registry.addViewController("/welcome.html").setViewName("welcome");
        //this line is used for test
        registry.addViewController("/test.html").setViewName("test");
        registry.addViewController("/index.html").setViewName("index");
    }

}
