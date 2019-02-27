package dev.jelly.JavaAOP;

import dev.jelly.JavaAOP.aop.AOPMethod;
import dev.jelly.JavaAOP.pojo.UserFactory;
import dev.jelly.JavaAOP.pojo.UserInterface;
import dev.jelly.JavaAOP.pojo.impl.User;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        UserInterface user = UserFactory.getUser(User.class, new AOPMethod() {
            @Override
            public void before(Object proxy, Method method, Object[] args) {
                if(method.getName().equals("getSex")){
                    System.out.println("成功拦截" + method.getName() + "方法启动");
                }
            }

            @Override
            public void after(Object proxy, Method method, Object[] args) {
                if(method.getName().equals("getSex")){
                    System.out.println("成功拦截" + method.getName() + "方法结束");
                }
            }
        });
        user.say();
        String name = "用户名" + user.getName();
        System.out.println(name);
        user.setName("张三");
        name = "用户名:" + user.getName();
        System.out.println(name);
        user.getSex();
    }
}
