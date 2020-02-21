package com.example.lovecode.Aspect;

import com.example.lovecode.Utils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author cuiyaocy
 */
@Component
@Aspect
public class SetFieldValueAspect {

    @Autowired
    private BeanUtils beanUtils;

    @Around("@annotation(com.example.lovecode.annotation.SetFieldValue)")
    public Object doSetValue(ProceedingJoinPoint pj) throws Throwable {
        Object obj = pj.proceed();
        System.out.println(String.format("返回的带注解的结果是：%s", obj));
        if (obj instanceof Collection) {
            beanUtils.setVlueForCollection((Collection) obj);
        }
        return obj;
    }

}
