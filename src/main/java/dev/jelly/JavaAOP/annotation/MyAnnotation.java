package dev.jelly.JavaAOP.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 本项目中的自定义注解
 */
//将把注释记录在类文件中，在运行时 VM 将保留注释，因此可以反射性地读
@Retention(RetentionPolicy.RUNTIME)
//限制使用类型
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface MyAnnotation {
    public String value() default "用户Jelly";

    public String property() default "无";
}
