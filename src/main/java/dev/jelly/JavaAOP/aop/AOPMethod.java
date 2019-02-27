package dev.jelly.JavaAOP.aop;

import java.lang.reflect.Method;

public interface AOPMethod {
    /**
     * 对象方法执行前的方法
     * @param proxy
     * @param method 方法
     * @param args 参数
     */
    void before(Object proxy, Method method, Object[] args);

    /**
     * 对象方法执行后的方法
     * @param proxy
     * @param method
     * @param args
     */
    void after(Object proxy, Method method, Object[] args);
}