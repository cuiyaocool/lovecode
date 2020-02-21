package com.example.lovecode.Utils;

import com.example.lovecode.annotation.NeedSetValue;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * @author cuiyaocy
 */
@Component
public class BeanUtils implements ApplicationContextAware {

    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = this.applicationContext == null ? applicationContext : this.applicationContext;
    }


    public void setVlueForCollection(Collection collection) throws NoSuchFieldException, NoSuchMethodException {
        //获取class
        Class<?> clazz = collection.iterator().next().getClass();

        //通过class去获取属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            NeedSetValue annotation = field.getAnnotation(NeedSetValue.class);
            if (annotation == null) {
                continue;
            }
            //设置可见性
            field.setAccessible(true);
            if (applicationContext == null) {
                System.out.println("null");
            }
            Object bean = applicationContext.getBean(annotation.benaclass());
            System.out.println("bean is " + bean.toString());
            System.out.println(clazz.getDeclaredField(annotation.param()));
            Method method = bean.getClass().getMethod(annotation.method(), clazz.getDeclaredField(annotation.param()).getType());
            System.out.println("method " + method.toString());
            Field param = clazz.getDeclaredField(annotation.param());
            param.setAccessible(true);

            for (Object obj : collection) {
                try {
                    Object value = param.get(obj);
                    if (value == null) {
                        continue;
                    }

                    try {
                        Object res = method.invoke(bean, value);
                        System.out.println("res " + res.toString());
                        Field targeField = res.getClass().getDeclaredField(annotation.targetFild());
                        targeField.setAccessible(true);
                        Object targetValue = targeField.get(res);
                        field.set(obj, targetValue);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
