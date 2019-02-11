package com.example.demo.Library.utils;

import com.example.demo.Library.utils.Interceptors.AuthInterceptor;
import com.example.demo.Library.utils.Interceptors.LogInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class Configure extends WebMvcConfigurationSupport {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LogInterceptor())
      .addPathPatterns("/api/**");
    // 登录状态检查的拦截器
    // 若未登录，则工作
    // 应当拦截所有需要登录状态的api请求
    // 用exclude链接所有不需要登录状态的api
    registry.addInterceptor(new AuthInterceptor())
      .addPathPatterns("/api/**")
      .excludePathPatterns("/api/member/login")
      .excludePathPatterns("/api/*");
    super.addInterceptors(registry);
  }
}