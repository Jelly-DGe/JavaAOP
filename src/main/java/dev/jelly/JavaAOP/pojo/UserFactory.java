package dev.jelly.JavaAOP.pojo;

import dev.jelly.JavaAOP.annotation.AnnoInjection;
import dev.jelly.JavaAOP.aop.AOPMethod;
import dev.jelly.JavaAOP.core.AOPHandle;

import java.lang.reflect.Proxy;

public class UserFactory {

    /**
     * 生成代理对象
     *
     * @param obj
     * @param method
     * @return
     */
    private static Object getUserBase(Object obj, AOPMethod method) {
        //获取代理对象
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new AOPHandle(AnnoInjection.getBean(obj), method));
    }

    public static <T> T getUser(Object obj, AOPMethod method) {
        return (T) getUserBase(obj, method);
    }

    public static <T> T getUser(String className, AOPMethod method) {
        Object obj = null;
        try {
            obj = getUserBase(Class.forName(className).newInstance(), method);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) obj;
    }

    public static <T> T getUser(Class<?> clz, AOPMethod method) {
        Object obj = null;
        try {
            obj = getUserBase(clz.newInstance(), method);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) obj;
    }
}
