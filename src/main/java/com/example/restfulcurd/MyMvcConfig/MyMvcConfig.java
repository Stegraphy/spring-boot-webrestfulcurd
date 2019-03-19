package com.example.restfulcurd.MyMvcConfig;

import com.example.restfulcurd.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

/*    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyMvcConfig());
    }*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //静态资源，*.css,*.js
        //Spring-Boot已经做好了静态资源映射
      /* registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/static/asserts/**","/index.html","/","/user/login");*/
        //排除静态资源文件路径/static/asserts/**，不然页面没有渲染效果
    }
    // 所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

        };
        return webMvcConfigurer;
    }
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
