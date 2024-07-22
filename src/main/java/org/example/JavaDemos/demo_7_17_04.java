package org.example.JavaDemos;

/**
 * @desc: 学习java的流程控制if-else,switch,for...，都是可以理解为完成任务的流程
 * @author: yin hang
 * @date: 2024/7/17
 */
public class demo_7_17_04 {
    public static void main(String[] args) {
        System.out.println("========================================");
        /**
         *1. 分支判断 if else 基础，但是用的太多
         * if (){
         *
         *         } else if () {
         *
         *         }
         *
         * switch(var){
         *             case v1: ;break;
         *
         *         }
         */

        System.out.println("========================================");
        /**
         * 2. 循环结构 for,主要就是遍历数据
         *   1.for
         *   2.for-each：or-each 循环通常用于遍历数组和集合，它的使用规则比普通的 for 循环还要简单，
         *   不需要初始变量，不需要条件，不需要下标来自增或者自减。
         *   3.无限for:for(;;){}
         */
        //普通用法
        for (int i = 0; i < 5; i++) {
            System.out.println("沉默王三好美啊");
        }

        // 之前不怎么了解的foreach的用法，
        String[] strs = {"123","456"};
        for(String str: strs){
            System.out.println(str);
        }

        System.out.println("========================================");
        /**
         * 题目1：给定一个 32 位有符号整数，将整数中的数字进行反转。
         * 输入: 123
         * 输出: 321
         * 输入: -123
         * 输出: -321
         * 考察：int 的基本数据类型、取余和除法运算符，以及 if 和 while 语句的使用
         */
        int x = 123,y=-321;
        System.out.println(reverse(x));
        System.out.println(reverse(y));

        System.out.println("========================================");
        /**
         * 题目2：实现一个 parseInt 方法，使其能将字符串转换成整数
         * 输入: "42"
         * 输出: 42
         * 输入: "   -42"
         * 输出: -42
         * 输入: "4193 with words"
         * 输出: 4193
         * 输入: "91283472332"
         * 输出: 2147483647
         * 方法：
         */
        String str1 = "42";
        String str2 = "   -42";
        String str3 = "4193 with words";
        String str4 = "91283472332";
        System.out.println(parseInt(str1));
        System.out.println(parseInt(str2));
        System.out.println(parseInt(str3));
        System.out.println(parseInt(str4));
    }

    /**
     * 解答问题1
     * @param x
     * @return 反转结果
     */
    public static int reverse(int x){
        int res = 0, z;
        while(x!=0){
            int pop = x%10;
            x /= 10;
            //溢出判断：如果 rev > Integer.MAX_VALUE/10 或 rev < Integer.MIN_VALUE/10，则会溢出
            //保证最后得到结果的值不会溢出，res = res*10+pop得到结果不溢出
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) return 0;

            res = res*10+pop;
        }
        return res;
    }


    /**
     * 实现字符串转换为数字int，溢出判断
     * @param input
     * @return
     */
    public static int parseInt(String input){
        int res = 0, index = 0, sign = 1;
        // 去空格
        while (index<input.length() && input.charAt(index) == ' ') index++;
        // 检查正负号
        if (index<input.length() && (input.charAt(index)=='+'||input.charAt(index)=='-')){
            sign = input.charAt(index)=='+'?1:-1;
            index++;
        }
        //开始转换数字
        while (index<input.length()){
            int num = input.charAt(index) - '0';
            if (num<0 || num>9) break;
            //溢出判断
            if (res > Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10 && num > Integer.MAX_VALUE%10)){
                return sign == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res*10 + num;
            index++;
        }
        return res * sign;
    }

}
