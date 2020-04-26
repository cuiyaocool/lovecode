package com.example.lovecode.Aspect;

import com.example.lovecode.jdbc.mybatis.Entity.UserEntity;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

    @Pointcut("@annotation(com.example.lovecode.annotation.TestAnnotation)")
    public void pointcut() {}

    @Before("pointcut()")
    public void before() {
        System.out.println("切面之前");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("切面之后");
    }

    public static void main(String[] args) {
        TestAspect testAspect = new TestAspect();
        UserEntity userEntity = new UserEntity();
        userEntity.setName("name");
        System.out.println(userEntity.getName());
    }


}
