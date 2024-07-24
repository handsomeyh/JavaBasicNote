package org.example.JavaDemos.demo_7_24_01;

/**
 * @desc: 学习Object的多线程调度
 * @author: yin hang
 * @date: 2024/7/24
 */
public class WaitNotifyDemo {
    /**
     * Object的多线程调度包含wait与notify方法
     * 每个对象都可以调用 Object 的 wait/notify 方法来实现等待/通知机制
     */
    public static void main(String[] args) {
        Object lock = new Object();
        //线程1
        new Thread(() -> {
            synchronized (lock){
                System.out.println("线程1：我要等待");
                try{
                    lock.wait();
                    // 可能发生线程被中断的异常
                }catch (InterruptedException e){
                    //打印此 throwable 文件及其对指定打印流的回溯。
                    e.printStackTrace();
                }
                System.out.println("线程1：我被唤醒了");
            }
        }).start();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("线程2：我要唤醒");
                lock.notify();
                System.out.println("线程2：我已经唤醒了");
            }
        }).start();
    }
}
