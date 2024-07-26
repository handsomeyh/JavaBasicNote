package org.example.JavaDemos.demo_7_26_01;

/**
 * @desc: 学习注解的编写，了解注解的原理
 * @author: yin hang
 * @date: 2024/7/26
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解的实现要关注两个点：生命周期+注解类型
 * 1.生命周期：注解的生命周期有 3 种策略，定义在 RetentionPolicy 枚举中
 * 1）SOURCE：在源文件中有效，被编译器丢弃。
 * 2）CLASS：在编译器生成的字节码文件中有效，但在运行时会被处理类文件的 JVM 丢弃。
 * 3）RUNTIME：在运行时有效。这也是注解生命周期中最常用的一种策略，它允许程序通过反射的方式访问注解，并根据注解的定义执行相应的代码。
 * 2.注解类型
 * 1）TYPE：用于类、接口、注解、枚举
 * 2）FIELD：用于字段（类的成员变量），或者枚举常量
 * 3）METHOD：用于方法
 * 4）PARAMETER：用于普通方法或者构造方法的参数
 * 5）CONSTRUCTOR：用于构造方法
 * 6）LOCAL_VARIABLE：用于变量
 * 7）ANNOTATION_TYPE：用于注解
 * 8）PACKAGE：用于包
 * 9）TYPE_PARAMETER：用于泛型参数
 * 10）TYPE_USE：用于声明语句、泛型或者强制转换语句中的类型
 * 11）MODULE：用于模块
 */

/**
 * 现在我们编写运行时有效，作用于字段的注解
 * 1）JsonField 注解的生命周期是 RUNTIME，也就是运行时有效。
 * 2）JsonField 注解装饰的目标是 FIELD，也就是针对字段的。
 * 3）创建注解需要用到 @interface 关键字。
 * 4）JsonField 注解有一个参数，名字为 value，类型为 String，默认值为一个空字符串。
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JsonField {
    // value 允许注解的使用者提供一个无需指定名字的参数。
    public String value() default "";
}
