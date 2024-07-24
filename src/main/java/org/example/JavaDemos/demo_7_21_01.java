package org.example.JavaDemos;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @desc: 进行字符串String的深入学习
 * @author: yin hang
 * @date: 2024/7/21
 */
public class demo_7_21_01 {
    // 拆分字符串的新选择, 使用static的预编译功能提升效率
    // 存在.
    private static Pattern sp1 = Pattern.compile("\\.");
    // 不仅仅存在. 还要不仅要把字符串按照英文标点的方式拆成两部分，并且英文逗点的前后要有内容。
    public static Pattern sp2 = Pattern.compile("(.+)\\.(.+)");

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
         * String.intern()方法，理解字符串常量池，几个要点如下：
         * 第一，使用双引号声明的字符串对象会保存在字符串常量池中。
         * 第二，使用 new 关键字创建的字符串对象会先从字符串常量池中找，如果没找到就创建一个，然后再在堆中创建字符串对象；如果找到了，就直接在堆中创建字符串对象。
         * 第三，针对没有使用双引号声明的字符串对象来说，可以调用 intern() 方法来完成
         * 注意，字符串常量池是堆内存中的一部分，其中类似“123”这种双引号的字符串常量值先回常量池中进行创建存储
         * 使用new String也会在堆内池外进行“123”的字符对象创建，但是明显二者地址不同
         * intern属于native方法有着较高的效率，并且可以让确保所有具有相同内容的字符串共享相同的内存空间
         */
        // 情况1：结果为false
        String s3 = new String("叮当");
        // 取得在常量池的“叮当”对象
        String s4 = s3.intern();
        // 地址不同
        System.out.println(s3 == s4);

        // 情况2：结果为true
        // 当编译器遇见+时：new StringBuilder().append("二哥").append("三妹").toString();
        String s5 = new String("红红") + new String("火火");
        // 如果堆内存在“红红火火”的对象，那会intern执行时常量池的对象会直接引用堆中的对象
        String s6 = s5.intern();
        System.out.println(s5 == s6);

        System.out.println("=======================================");
        /**
         * 如何判断字符串相等，这个问题也可以引申为 .equals() 和 ‘==’ 操作符有什么区别。
         * “==”操作符用于比较两个对象的地址是否相等。
         * .equals() 方法用于比较两个对象的内容是否相等。
         * Object类的equals()方法用==实现的，但是很多类重写了该方法，使其变得没有那么严格
         *
         * 其他方法：
         * 1. Objects.equals() 这个静态方法的优势在于不需要在调用之前判空。
         * 2. .contentEquals() 的优势在于可以将字符串与任何的字符序列
         * （StringBuffer、StringBuilder、String、CharSequence）进行比较。
         */
        String alita = new String("小哥");
        String luolita = new String("小哥");
        // false
        System.out.println(alita == luolita);
        // true
        System.out.println(alita.equals(luolita));
        // 使用Objects.equals()进行比较,可以查看底层源码，他同时由==与equals实现
        System.out.println(Objects.equals(alita, luolita));
        // 优势在于同步使用，StringBuffer用起来很智能，但是单纯对于String来讲就过于复杂
        System.out.println(alita.contentEquals(luolita));

        System.out.println("=======================================");
        /**
         * 如何进行字符串的拼接，如何进行最优雅的String拼接
         * 拼接字符串最好使用的方法：StringBuilder的append()方法
         * 其他方法：
         * String.concat()
         * String.join()
         * 实际工作中也用工具类：StringUtils.join
         */
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1").append("2");
        System.out.println(stringBuilder.toString()+"长度为"+stringBuilder.length());

        System.out.println("=======================================");
        /**
         * 如何进行字符串的拆分，详解Java的split方法,
         * 但是分隔符种类很多，如何以一概之：使用正则表达式
         * split()方法的参数属于是正则表达式
         * 其他方法：
         * Pattern的quote()方法
         *
         */
        // 正常的使用情况
        String cm = "西站,东站,南站,北站";
        if (cm.contains(",")){
            String[] Stas1 = cm.split(",");
            System.out.println(Arrays.toString(Stas1));
        } else {
            throw new IllegalArgumentException("当前字段没有逗号");
        }

        // 特殊符号无法直接使用，结果报错IllegalArgumentException，需要使用正则表达式\\.
        String sm = "西站.东站.南站.北站";
        if (sm.contains(".")){
            String[] Stas2 = sm.split("\\.");
            System.out.println(Arrays.toString(Stas2));
        } else {
            throw new IllegalArgumentException("当前字段没有英文句号");
        }

        // 使用Pattern.quote()方法,split的源码中return Pattern.compile(regex).split(this, limit);
        String xm = "西站.东站.南站.北站";
        if (xm.contains(".")){
            String[] Stas3 = xm.split(Pattern.quote("."));
            System.out.println(Arrays.toString(Stas3));
        } else {
            throw new IllegalArgumentException("当前字段没有英文句号");
        }

        // 进行更高效率的拆分,相当于用sp提前设分隔符（使用正则方式进行设置）
        String[] Sta4 = sp1.split("西站.东站.南站.北站");
        System.out.println(Arrays.toString(Sta4));

        // 还可以使用 Pattern 配合 Matcher 类进行字符串拆分，这样做的好处是可以对要拆分的字符串进行一些严格的限制
        checkString("沉默王二.一枚有趣的程序员");
        checkString("沉默王二.");
        checkString(".一枚有趣的程序员");

    }


    /**
     * 计算字符串的HashCode,自定义方式
     * @param text
     * @return 输入字符串的HashCode值
     */
    public static int computeHashCode(String text){
        int h = 0;
        for (int i = 0; i < text.length(); i++) {
            // 无法直接访问text中的value属性，要获得其中的字母只能使用方法charAt。
            h = h*31 + text.charAt(i);
        }
        return h;
    }

    /**
     * 使用Matcher进行更加严格的拆分
     * @param srt
     */
    public static void checkString(String str) {
        Matcher matcher = sp2.matcher(str);
        if (matcher.matches()){
            System.out.println(matcher.group(1)+matcher.group(2));
        } else {
            System.out.println("不匹配");
        }
    }
}
