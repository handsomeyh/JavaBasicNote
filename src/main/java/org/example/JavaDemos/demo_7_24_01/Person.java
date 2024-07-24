package org.example.JavaDemos.demo_7_24_01;

import java.util.Objects;

/**
 * @desc: 进行简单的面向对象学习
 * @author: yin hang
 * @date: 2024/7/24
 */
public class Person {
    /**
     * 1.面向过程是流程化的，一步一步，上一步做完了，再做下一步。
     * 2.面向对象是模块化的，我做我的，你做你的，我需要你做的话，我就告诉你一声。
     * 我不需要知道你到底怎么做，只看功劳不看苦劳。
     * 现在简单定义一个Person类，类的三个组成：字段、方法、构造方法
     */
    // 字段，这三个字段称为成员变量
    public String name;
    public int age;
    public int sex;

    // 方法，表示 Person 这个对象可以做什么
    public void eat() {
    }

    public void sleep() {
    }

    public void dadoudou() {
    }

    //构造方法，public Person(){} 就是默认的构造方法，因为是空的构造方法（方法体中没有内容），所以可以缺省。
    public Person() {
    }

    // 最标准的初始化方式
    public Person(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /**
     * 万物皆是对象。Java的所有类都是Object的子类，都可以重写他的方法
     * Object类方法的学习，Object方法总共分成6大类：
     * 1.对象比较
     * 2.对象拷贝
     * 3.对象转字符串
     * 4.多线程调度
     * 5.反射
     * 6。垃圾回收
     * 实现：
     * 这项工作可以交给IDE，直接右键选择 Generate，然后选择 toString 方法，就会自动生成一个 toString 方法。
     * 也可以交给 Lombok，使用 @Data 注解，它会自动生成 toString 方法。
     */
    // 1，对象比较
    //使用Objects.hash()重写hashCode()方法
    @Override
    public int hashCode(){
        return Objects.hash(name,age);
    }

    // 比较两对象的值是否相等，可以自定义，也可以生成
    // 有趣的是在Object中equals方法仅仅只是由==实现
    @Override
    public boolean equals(Object o) {
        // 使用"=="进行严格的地址判断，地址相同那么肯定就相同
        if (this == o) return true;
        // 进行类型与内容方式判断相等
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && sex == person.sex && Objects.equals(name, person.name);
    }

    // 2.对象拷贝，默认实现只做浅拷贝，且类必须实现 Cloneable 接口。
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // 3.对象转字符串，默认实现返回类名@哈希码的十六进制表示，但通常会被重写以返回更有意义的信息。
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
