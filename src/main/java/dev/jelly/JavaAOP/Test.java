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

        //say方法测试数据是否注入
        user.say();
        //测试getSex方法前后是否打印切入的方法
        System.out.println(user.getSex());
    }
}
