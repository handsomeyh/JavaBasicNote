package org.example.JavaDemos;

import java.io.FileFilter;
import java.nio.file.PathMatcher;

/**
 * @desc: 进行Java中匿名类、lambda、->的学习
 * @author: yin hang
 * @date: 2024/7/21
 */
public class lambda_demo {
    public static void main(String[] args) {
        /**
         * Lambda 表达式描述了一个代码块（或者叫匿名方法），核心是：做方法参数
         * 可以将其作为参数传递给构造方法或者普通方法以便后续执行
         * 以创建线程为例，创建线程常用的方法需要用到匿名类，因此可以使用lambda表达式
         */
        // 匿名类的方式
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是线程1号！");
            }
        });
        /**
         * lambda语法：( parameter-list ) -> { expression-or-statements }
         * () 中的 parameter-list 是以逗号分隔的参数。你可以指定参数的类型，也可以不指定（编译器会根据上下文进行推断）。Java 11 后，还可以使用 var 关键字作为参数类型，有点 JavaScript 的味道。
         * -> 相当于 Lambda 的标识符，就好像见到圣旨就见到了皇上。
         * {} 中的 expression-or-statements 为 Lambda 的主体，可以是一行语句，也可以多行。
         */
        Thread thread2 = new Thread(()-> System.out.println("我是线程2号！"));

        thread1.start();
        thread2.start();

        // lambda作用广泛
        // 1.为变量赋值
        Runnable runnable1 = () -> {
            System.out.println("我正在使用lamdba为Runnable变量赋值");
        };
        runnable1.run();
        // 2.作为return返回结果

        // 3.作为数组元素
        final PathMatcher matchers[] =
                {
                        (path) -> path.toString().endsWith("txt"),
                        (path) -> path.toString().endsWith("java")
                };
        // 4.作为普通方法或者构造方法的参数

    }
    // 2.作为return返回结果
    static FileFilter getFilter(String ext)
    {
        return (pathname) -> pathname.toString().endsWith(ext);
    }

}
