package org.example.JavaDemos;
import lombok.Data;

/**
 * @desc: 进行反射的学习，demo
 * @author: yin hang
 * @date: 2024/7/24
 */

public class Writer {
    private String name;
    private int age;

    public Writer() {
    }

    public Writer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void privateMethod(){
        System.out.println("私有方法");
    }
}

