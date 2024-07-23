package org.example.JavaDemos;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @desc: 学习StringBuilder和StringBuffer两兄弟
 * @author: yin hang
 * @date: 2024/7/22
 */
public class demo_7_23_01 {
    public static void main(String[] args) {
        /**
         * 二者出现的原因：
         * 由于字符串是不可变的，所以当遇到字符串拼接（尤其是使用+号操作符）的时候，就需要考量性能的问题，
         * 你不能毫无顾虑地生产太多 String 对象，对珍贵的内存造成不必要的压力。
         * StringBuffer主要考虑多线程，避免多线程冲突：
         * 由于 StringBuffer 操作字符串的方法加了 synchronized 关键字进行了同步，主要是考虑到多线程环境下的安全问题，
         * 所以如果在非多线程环境下，执行效率就会比较低，因为加了没必要的锁
         * StringBuilder主要考虑单线程，单线程环境下的效率要高得多，如果要在多线程的环境下使用就要使用ThreadLocal
         * 二者在类名与synchronized上基本一样
         *
         * 通过题目来进行了解：
         * 题目1：整数反转：
         * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
         * 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。
         * 假设环境不允许存储 64 位整数（有符号或无符号）。
         * 输入：x = 123
         * 输出：321
         *
         * 输入：x = -123
         * 输出：-321
         *
         * 输入：x = 120
         * 输出：21
         *
         * 输入：x = 0
         * 输出：0
         */
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(reverseInt(x));

        /**
         * 题目2：Z 字形变换
         * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
         * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
         * P   A   H   N
         * A P L S I I G
         * Y   I   R
         * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
         * 输入：s = "PAYPALISHIRING", numRows = 4
         * 输出："PINALSIGYAHRPI"
         * 4 P     I    N
         * 3 A   L S  I G
         * 2 Y A   H R
         * 1 P     I
         */


    }

    /**
     * 反转数字
     * @param x 输入整数
     * @return
     * 其中用到：
     * String-->int:Integer.parseInt(reversed)
     * int-->String:StringBuilder().append(Math.abs(x)).reverse().toString()
     */
    public static int reverseInt(int x){
        int res, sign = 1;
        if (x<0){
            sign = -1;
        }
        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            res = Integer.parseInt(reversed)*sign;
        }catch (NumberFormatException e){
            System.out.println("反转后的数字越界");
            return 0;
        }
        return res;
    }

    /**
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows){
        String res = " ";
        return res;
    }
}
