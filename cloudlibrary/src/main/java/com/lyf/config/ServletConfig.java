package com.lyf.config;

import com.lyf.interceptor.ResourcesInterceptor;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ResourcesInterceptor())
                                        .addPathPatterns("/**")
                                        .excludePathPatterns("/css/**", "/js/**", "/img/**");
    }

    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/admin/", ".jsp");
    }
}
