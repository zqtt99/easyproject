package com.manage.easyproject.config;

import com.manage.easyproject.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器配置类
 */
@Configuration
public class LoginConfiguration  extends WebMvcConfigurerAdapter{

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //上传的图片在D盘下的springbootUpload目录下，访问路径如：http://localhost:8787/work/upload/xxx.jpg
        //其中upload表示访问的前缀。"file:D:/springbootUpload/"是文件真实的存储路径
        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/springbootUpload/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/loginPageFore", "loginPageAdmin", "loginPageUser", "/upload");
        super.addInterceptors(registry);
    }
}
