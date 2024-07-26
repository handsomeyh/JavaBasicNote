package org.example.JavaDemos;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @desc: 进行Write的反射测试
 * @author: yin hang
 * @date: 2024/7/26
 */
public class ReflectionDemo{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 首先获取类对象
        Class<?> writerClass = Class.forName("org.example.JavaDemos.Writer");
        // 输出类名
        System.out.println(writerClass.getClass());

        // 获得构造函数
        Constructor constructor = writerClass.getConstructor(String.class, int.class);

        // 获取并使用构造函数创建实例
        Object object = constructor.newInstance("舟舟亢亢",100);

        // 获取并调用getName方法
        Method getNameMethod = writerClass.getMethod("getName");
        System.out.println(getNameMethod.invoke(object));

        // 获取并调用setAge方法
        Method setAgeMethod = writerClass.getMethod("setAge", int.class);
        setAgeMethod.invoke(object,18);

        // 获取并访问age字段
        Field ageField = writerClass.getDeclaredField("age");
        // 访问私有的方法,注意，在访问私有方法和字段时，我们需要调用 setAccessible(true) 方法来允许访问。
        ageField.setAccessible(true);
        int age = ageField.getInt(object);
        System.out.println("年纪" + age);

        // 获取并调用私有方法
        Method privateMethod = writerClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(object);
    }
}
