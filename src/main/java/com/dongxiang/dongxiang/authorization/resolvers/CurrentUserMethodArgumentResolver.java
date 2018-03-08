package com.dongxiang.dongxiang.authorization.resolvers;

import com.dongxiang.dongxiang.Constants;
import com.dongxiang.dongxiang.authorization.annotation.CurrentUser;
import com.dongxiang.dongxiang.domain.UserManageEntity;
import com.dongxiang.dongxiang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        // 如果参数是User并且有CurrentUser注解则支持
        if (methodParameter.getParameterType().isAssignableFrom(UserManageEntity.class)
                && methodParameter.hasParameterAnnotation(CurrentUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        // 取出鉴别权限时存入的登录用户ID
        Long currentID = (Long) nativeWebRequest.getAttribute(Constants.CURRENT_USER_ID, RequestAttributes.SCOPE_REQUEST);
        if (currentID != null) {
            // 从数据库中查询并且返回
            return userRepository.findOne(currentID);
        }
        throw new MissingServletRequestPartException(Constants.CURRENT_USER_ID);
    }
}
