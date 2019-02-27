package dev.jelly.JavaAOP.pojo.impl;

import dev.jelly.JavaAOP.annotation.MyAnnotation;
import dev.jelly.JavaAOP.pojo.UserInterface;

public class User implements UserInterface {

    @MyAnnotation(value = "张三")
    private String name;

    private String sex;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @MyAnnotation(property = "男")
    @Override
    public void setSex(String Sex) {
        this.sex = sex;
    }

    @Override
    public String getSex() {
        return this.sex;
    }

    @Override
    public void say() {
        System.out.print(this.getName() + "  " + this.getSex());
    }
}
