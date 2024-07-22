package org.example.JavaDemos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @desc: 数组知识学习，数组许多序列化对象的基础，java是以c/cpp为基础的
 * @author: yin hang
 * @date: 2024/7/18
 */
public class demo_7_18_01 {
    public static void main(String[] args) {
        /**
         * 数组是一种对象，引用数据类型，用new进行创建，new 是 Java 中的一个关键字，用来把类变成对象
         * 如果需要添加元素或者删除元素的话，需要把它转成 java.util.ArrayList
         * Java 8 新增了 Stream 流的概念，这就意味着我们也可以将数组转成 Stream 进行操作。
         */
        System.out.println("==============================");
        /**
         * 可变参数
         */

        System.out.println("==============================");
        /**
         * 数组转化为List
         * Arrays.asList 方法返回的 ArrayList 并不是 java.util.ArrayList，
         * 它其实是 Arrays 类的一个内部类
         */
        int[] anArray = new int[]{1,2,3,4,5};
        // 方法1：遍历添加，add()方法
        List<Integer> list1 = new ArrayList<>();
        for(int element : anArray){
            list1.add(element);
        }
        System.out.println(list1);
        //方法2：利用Arrays类
        List<Integer> list2 = Arrays.asList(1,2,3,4,5);
        System.out.println(list2);
        //方法3：java Stream
        List<Integer> list3 = Arrays.stream(anArray).boxed().collect(Collectors.toList());
        System.out.println(list3);
        System.out.println("======================================");

        /**
         * 数组排序与查找，主要使用的是Arrays这个工具类
         * 1.排序：数组中通常使用sort()方法实现排序，基本数据类型按照升序排列，实现了 Comparable 接口的对象按照 compareTo() 的排序
         * 2.查找：暴力方法就是遍历查找，在满足前提条件有序的情况下高效一点就是二分查找Arrays.binarySearch()
         */
        // 基本数据类型sort排序
        int[] array1 = new int[]{5,2,5,3,1};
        Arrays.sort(array1);//其底层是快速排序原理
        System.out.println(Arrays.toString(array1));
        // 自定义排序
        String[] strArray = new String[]{"A","B","E","D","C"};
        Arrays.sort(strArray,1,3, Comparator.comparing(String::toString).reversed());
        System.out.println(Arrays.asList(strArray));
        // 进行查找，无序就只能遍历查找，但是有序就直接二分查找，java也会在Array中提供方法binarySearch()
        int[] array3 = new int[]{1,2,3,4,5};
        int index = Arrays.binarySearch(array3, 4);
        System.out.println(index);

        System.out.println("==============================");

        /**
         * 数组复制，一般使用Arrays.arraycopy()方法，Arrays.copyOfRange(value, offset, offset+count);
         * 其底层调用的是System.arraycopy(),属于native方法，他是c/cpp实现，效率高，可以直接进行使用，
         * public static native void arraycopy(Object src,  int  srcPos,
         *                                     Object dest, int destPos,
         *                                     int length);
         * 题目：合并数组
         */
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{4,5,6};
        int[] mergedArray = new int[arr1.length + arr2.length];
        //合并arr1
        System.arraycopy(arr1, 0, mergedArray, 0, arr1.length);

        System.out.println(Arrays.toString(mergedArray));
        //合并arr2
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        System.out.println(Arrays.toString(mergedArray));

        System.out.println("==============================");
        /**
         * 数组越界，ArrayIndexOutOfBoundsException
         *
         */
        int[] arr3 = new int[]{1,2,3,4,5};
        try{
            System.out.println(arr3[5]);
        }catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("发生数组越界！");
        }

        System.out.println("==============================");
        /**
         * 二维数组,开发中用的不多，算法中多一点
         */

        System.out.println("==============================");
        /**
         * 优雅的打印输出数组，数组也是一个对象，但是不是一个单独的对象
         * 方法1：stream 流打印 Java 数组
         * 方法2：for 循环打印 Java 数组
         * 方法3：Arrays 工具类打印 Java 数组
         */
        // 无法直接打印数组，
        String [] cmowers = {"沉默","王二","一枚有趣的程序员"};
        // 结果为 [Ljava.lang.String;@6acbcfc0
        // 通过阅读源码得知println首先会对对象进行toString,再次阅读toString的源码可知
        System.out.println(cmowers);
        // 方法1：stream 流打印 Java 数组，一共有三种形式，大多数时候遍历可能不是为了输出
        // 这里不懂->的含义：他说形成Java lambda表达式的符号，与匿名类相关
        // 先学习如何打印数组
        Arrays.asList(cmowers).stream().forEach(s -> System.out.println(s));
        Stream.of(cmowers).forEach(System.out::println);
        Arrays.asList(cmowers).stream().forEach(System.out::println);

        System.out.println("==============================");
        /**
         * for循环打印数组，foreach也可以
         */
        for (int i = 0; i < cmowers.length; i++) {
            System.out.println(cmowers[i]);
        }

        for (String s: cmowers){
            System.out.println(s);
        }

        System.out.println("==============================");
        /**
         * 使用Arrays工具类进行数组打印
         * Arrays.toString() 可以将任意类型的数组转成字符串，包括基本类型数组和引用类型数组。
         * 该方法有多种重载形式。
         * 很优雅
         * 甚至可以用来打印二维数组：Arrays.deepToString()
         */
        System.out.println(Arrays.toString(cmowers));
        String[][] deepArray = new String[][]{{"1","2"},{"3"}};
        System.out.println(Arrays.deepToString(deepArray));
    }
}
