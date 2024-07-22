package org.example.JavaDemos;

import java.util.Arrays;

/**
 * @desc: 进行字符串String的深入学习
 * @author: yin hang
 * @date: 2024/7/21
 */
public class demo_7_21_01 {
    public static void main(String[] args) {
        /**
         * 阅读String源码：
         * “第一，String 类是 final 的，意味着它不能被子类继承。这些知识我们讲面向对象编程的时候都会讲到，三妹你不用担心。”
         * “第二，String 类实现了 Serializable 接口，意味着它可以序列化（后面同样会讲，戳链接可跳转）。”
         * “第三，String 类实现了 Comparable 接口，意味着最好不要用‘==’来比较两个字符串是否相等，而应该用 compareTo() 方法去比较。”
         * 因为 == 是用来比较两个对象的地址
         * 第四，String 和 StringBuffer、StringBuilder 一样，都实现了 CharSequence 接口，所以它们仨属于近亲。由于 String 是不可变的，
         * 所以遇到字符串拼接的时候就可以考虑一下 String 的另外两个好兄弟，StringBuffer 和 StringBuilder，它俩是可变的。
         */


        /**
         * 第五，String底层在JDK9之后优化成了byte数组，稍微了解下
         */

        /**
         * String的hashCode方法
         * 第六，每一个字符串都会有一个 hash 值，这个哈希值在很大概率是不会重复的，因此 String 很适合来作为 HashMap（后面会细讲）的键值。
         * 哈希码的计算方法：31 倍哈希法
         * 源码中： h = 31 * h + val[i]; // 使用 31 作为乘法因子
         * H(s) = (s[0] * 31^(n-1)) + (s[1] * 31^(n-2)) + ... + (s[n-1] * 31^0)
         * 其中s为字符串，n为字符串长度
         * 模拟String的hashCode方法如下
         */
        String text = "舟舟亢亢";
        int textHashCode = computeHashCode(text);
        System.out.println("通过我们自己的方法获得的HashCode:"+textHashCode);
        System.out.println("调用String提供的方法得到的HashCode:"+text.hashCode());

        System.out.println("=======================================");
        /**
         * String类的substring方法，作用：截取字符串，阅读源码，并且文档注释写的很清楚
         * 使用示例如下
         */
        String str1 = "HelloWorld";
        // 得到Hello
        String substr1 = str1.substring(0,5);
        System.out.println(substr1);
        //得到World
        String substr2 = str1.substring(5);
        System.out.println(substr2);
        // 处理字符串中的空格和分隔符
        String str2 = "  hello world  ";
        // str.trim()方法
        String trim_str = str2.trim();
        // "\s"正则表达式中代替空格等符号，\s匹配任何空白字符，包括空格、制表符、换页符等等, 等价于[ \f\n\r\t\v]
        //String[] words = trim_str.split("\\s");
        String[] words = str2.trim().split("\\s");
        System.out.println(Arrays.toString(words));
        // 处理字符串中的数字与符号
        String str3 = "   111-222-333-444  ";
        String[] nums = str3.trim().split("-");
        System.out.println(nums[3].substring(2));

        System.out.println("=======================================");
        /**
         * String中的indexOf方法
         * 查找字符数组 target 在字符数组 source 中第一次出现的位置。
         * sourceOffset 和 sourceCount 参数指定 source 数组中要搜索的范围，
         * targetOffset 和 targetCount 参数指定 target 数组中要搜索的范围，
         * fromIndex 参数指定开始搜索的位置。
         * 如果找到了 target 数组，则返回它在 source 数组中的位置索引（从0开始），
         * 否则返回-1。
         */
        // 用法1：查找子字符串的位置
        String str4 = "Hello,World";
        System.out.println(str4.indexOf("World"));
        System.out.println(str4.indexOf('o'));
        System.out.println(str4.indexOf("l",3));

        /**
         * String中其他常用的方法
         * 比如说 length() 用于返回字符串长度。
         * 比如说 isEmpty() 用于判断字符串是否为空。
         * 比如说 charAt() 用于返回指定索引处的字符。
         * 比如说 valueOf() 用于将其他类型的数据转换为字符串。
         */
        // valueOf 方法的背后其实调用的是包装器类的 toString 方法，
        // 比如说整数转为字符串调用的是 Integer 类的 toString 方法。
        // 查源码也可以知道这件事
        System.out.println(String.valueOf(1234));

        System.out.println("=======================================");
        /**
         * String的不可变性，其不可变性主要表现在两个方面：
         * String 类被 final 关键字修饰，所以它不会有子类，这就意味着没有子类可以重写它的方法，改变它的行为。
         * String 类的数据存储在 char[] 数组中，而这个数组也被 final 关键字修饰了，这就表示 String 对象是没法被修改的，只要初始化一次，值就确定了。
         * 为什么这样设计：
         * 1.可以保证 String 对象的安全性，避免被篡改，毕竟像密码这种隐私信息一般就是用字符串存储的
         * 2.保证哈希值不会频繁变更。毕竟要经常作为哈希表的键值，经常变更的话，哈希表的性能就会很差劲。
         * 3.可以实现字符串常量池，Java 会将相同内容的字符串存储在字符串常量池中。这样，具有相同内容的字符串变量可以指向同一个 String 对象，节省内存空间。
         */

        System.out.println("=======================================");
        /**
         * 字符串常量池
         */
        // 这段代码创建了2个对象：“二哥”这个字符串对象（在堆中）  and  s（在栈中）
        // 使用 new 关键字创建一个字符串对象时，Java 虚拟机会先在字符串常量池中查找有没有‘二哥’这个字符串对象，
        // 如果有，就不会在字符串常量池中创建‘二哥’这个对象了，直接在堆中创建一个‘二哥’的字符串对象，然后将堆中这个‘二哥’的对象地址返回赋值给变量 s
        // 在 Java 中，栈上存储的是基本数据类型的变量和对象的引用，而对象本身则存储在堆上。
        String s1 = new String("二哥");
        // 这种创建方法最多就创建1次对象
        String s2 = "周康";

        System.out.println("=======================================");
        /**
         * String
         */

    }


    public static int computeHashCode(String text){
        int h = 0;
        for (int i = 0; i < text.length(); i++) {
            // 无法直接访问text中的value属性，要获得其中的字母只能使用方法charAt。
            h = h*31 + text.charAt(i);
        }
        return h;
    }
}
