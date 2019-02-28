package dev.jelly.JavaAOP.core;

import dev.jelly.JavaAOP.aop.AOPMethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现InvocationHandler接口,以实现对实例的代理
 */
public class AOPHandle implements InvocationHandler {
    private AOPMethod method;
    private Object obj;

    /**
     * @param method
     * @param obj
     */
    public AOPHandle(Object obj, AOPMethod method) {
        this.obj = obj;
        this.method = method;
    }

    /**
     * 自动调用java的动态代理机制(面向接口)
     *
     * @param proxy  被代理对象
     * @param method 被调用方法
     * @param args   方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        this.method.before(proxy, method, args);
        result = method.invoke(obj, args);
        this.method.after(proxy, method, args);
        //返回处理后的对象
        return result;
    }
}
