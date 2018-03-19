package com.dongxiang.dongxiang;

import com.dongxiang.dongxiang.authorization.interceptor.PermitInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 进行登录配置
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter{

    /**
     * 拦截器配置, 添加一个自定义的拦截器
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermitInterceptor()).addPathPatterns("/**");
    }
}
