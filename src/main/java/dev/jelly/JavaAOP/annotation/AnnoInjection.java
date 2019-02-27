package dev.jelly.JavaAOP.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 自定义注解的注入实现
 */
public class AnnoInjection {
    public static Object getBean(Object obj) {
        //获取对象所属类的所有属性
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            //获取属性上的注解
            MyAnnotation myAnnotation = field.getAnnotation(MyAnnotation.class);
            if (myAnnotation != null) {
                System.out.println("为" + field.getName() + "属性注入" + myAnnotation.value());
                //为属性注入自定义注解中的值
                try {
                    obj.getClass().getMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1),
                            String.class).invoke(obj, myAnnotation.value());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //获取对象所属类的所有方法(注入思路同上)
        Method[] declaredMethods = obj.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            if (myAnnotation != null) {
                System.out.println("为" + method.getName() + "方法注入" + myAnnotation.property() + "属性");
                try {
                    method.invoke(obj, myAnnotation.property());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }
}
