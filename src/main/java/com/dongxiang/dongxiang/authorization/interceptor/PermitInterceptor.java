package com.dongxiang.dongxiang.authorization.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义权限拦截器
 */
@Component
public class PermitInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) {
        // 获取发送请求的方式, 如get, post
        String method = request.getMethod();
        // 获取请求的URL
        String url = request.getRequestURI();
        // 获取请求体的数据流
//        String reader = request.getReader();
        // 获取客户端的名字
        String localName = request.getRemoteHost();
        // 获取客户端的IP地址
        String localIp = request.getRemoteAddr();
        // 获取请求中所有参数的名字
        // 获取请求的文件的路径
        return true;
    }
}
