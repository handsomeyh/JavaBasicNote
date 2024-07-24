package org.example.JavaDemos.demo_7_24_01;

/**
 * @desc: 学习Synchronized关键字，梦回操作系统
 * @author: yin hang
 * @date: 2024/7/24
 */

/**
 * synchronized 关键字最主要有以下 3 种应用方式：
 * 1.同步方法，为当前对象（this）加锁，进入同步代码前要获得当前对象的锁；
 * 2.同步静态方法，为当前类加锁（锁的是 Class 对象），进入同步代码前要获得当前类的锁；
 * 3.同步代码块，指定加锁对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁。
 * 本类中学习：synchronized同步方法
 * 通过在方法声明中加入 synchronized 关键字，可以保证在任意时刻，只有一个线程能执行该方法。
 */
//Runnable接口旨在为希望在活动时执行代码的对象提供通用协议。
public class AccountingSync implements Runnable{
    // 共享资源

    public static void main(String[] args) {

    }

    @Override
    public void run() {

    }
}

