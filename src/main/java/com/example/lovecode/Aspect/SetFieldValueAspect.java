package com.example.lovecode.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author cuiyaocy
 */
@Component
@Aspect
public class SetFieldValueAspect {

    @Around("@annotation(com.example.lovecode.annotation.SetFieldValue)")
    public Object doSetValue(ProceedingJoinPoint pj) throws Throwable {
        Object obj = pj.proceed();
        return Arrays.asList("lll","ddd");
    }

}
