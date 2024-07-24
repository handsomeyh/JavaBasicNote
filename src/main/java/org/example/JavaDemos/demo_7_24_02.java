package org.example.JavaDemos;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @desc: 学习Java反射
 * @author: yin hang
 * @date: 2024/7/24
 */
public class demo_7_24_02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /**
         * 正射：正常创建对象，调用对象方法
         * 反射：只知道这个类的一些基本信息，将类描述出来,反射的成本是要比正射的高得多
         * 反射缺点：
         * 1.破坏封装：由于反射允许访问私有字段和私有方法，所以可能会破坏封装而导致安全问题。
         * 2.性能开销：由于反射涉及到动态解析，因此无法执行 Java 虚拟机优化，再加上反射的写法的确要复杂得多，
         * 所以性能要比“正射”差很多，在一些性能敏感的程序中应该避免使用反射。
         *
         * 反射主要的应用场景：
         * 1.开发通用框架：像 Spring，为了保持通用性，通过配置文件来加载不同的对象，调用不同的方法。
         * 2.动态代理：在面向切面编程中，需要拦截特定的方法，就会选择动态代理的方式，而动态代理的底层技术就是反射。
         * 3.注解：注解本身只是起到一个标记符的作用，它需要利用发射机制，根据标记符去执行特定的行为。
         */
        // 第一步，获取反射类的 Class 对象：
        Class c = Class.forName("org.example.JavaDemos.Writer");
        // 第二步，通过 Class 对象获取构造方法 Constructor 对象，以及要调用的方法的 Method 对象
        Method method1 = c.getMethod("setName", String.class);
        Method method2 = c.getMethod("getName");
        Constructor constructor = c.getConstructor();
        // 通过 Constructor 对象初始化反射类对象
        Object o = constructor.newInstance();
        // 通过 invoke() 方法执行
        method1.invoke(o,"舟舟亢亢");
        System.out.println(method2.invoke(o));
    }
}
