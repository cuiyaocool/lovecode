package com.example.demo.interceptor;

import com.example.demo.annotation.ApiIdempotent;
import com.example.demo.exception.ApiException;
import com.example.demo.service.token.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class Interceptor implements HandlerInterceptor {

    @Autowired
    @Qualifier("tokenServiceImpl")
    private TokenServiceImpl tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ApiException{
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        ApiIdempotent methodAnnotation = method.getAnnotation(ApiIdempotent.class);
        if (methodAnnotation != null) {
            try {
                // 幂等性校验, 校验通过则放行, 校验失败则抛出异常, 并通过统一异常处理返回友好提示
                check(request);
            } catch (ApiException e) {
                throw e;

            }

        }

        return true;
    }

    private void check(HttpServletRequest request) throws ApiException {
        tokenService.checkToken(request.getHeader("token"));
    }
}
