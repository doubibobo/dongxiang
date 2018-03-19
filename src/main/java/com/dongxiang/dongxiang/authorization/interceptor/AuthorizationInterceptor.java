package com.dongxiang.dongxiang.authorization.interceptor;

import com.dongxiang.dongxiang.Constants;
import com.dongxiang.dongxiang.authorization.annotation.Authorization;
import com.dongxiang.dongxiang.token.TokenManager;
import com.dongxiang.dongxiang.token.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 登录识别拦截器, 判断用户的登录信息
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenManager manager;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法可以直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        // 从header中获取token
        String authorization = request.getHeader(Constants.AUTHORIZATION);
        // 验证token
        TokenModel model = manager.getToken(authorization);
        if (manager.checkToken(model)) {
            // 如果token验证成功, 将token对应的用户id存放在Request中,便于之后注入
            request.setAttribute(Constants.CURRENT_USER_ID, model.getUserId());
            return true;
        }
        // 如果验证token失败, 并且方法注明了Authorization, 返回401错误--未授权
        if (method.getAnnotation(Authorization.class) != null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
