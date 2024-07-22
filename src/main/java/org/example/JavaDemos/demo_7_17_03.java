package org.example.JavaDemos;

/**
 * @desc: 用于学习java运算符，主要侧重于之前自己不太注意的比如位运算等运算符
 * @author: yin hang
 * @date: 2024/7/17
 */
public class demo_7_17_03 {
    public static void main(String[] args) {
        System.out.println("=======================================");
        /**
         * 1.算术运算符太过常见不做赘述，需要注意的数据类型对于计算结果的影响
         * 研究特殊案例：浮点数除0，与整数除0的情况
         */
        // Infinity无穷大
        System.out.println(10.0 / 0.0);
        // NaN不是一个数字
        System.out.println(0.0 / 0.0);
        //整数除0抛出异常,因此整数除法要做分母的判断
        try{
            System.out.println(10/0);
        }catch (ArithmeticException arithmeticException){
            System.out.println("整数除法，分母为0");
        }

        System.out.println("=======================================");
        /**
         * 2.关系运算符，很简单
         */

        /**
         * 3.位运算符，有点难，与二进制相关，有利于与提升计算效率
         * 在学习位运算符之前，需要先学习一下二进制，
         * 因为位运算符操作的不是整型数值（int、long、short、char、byte）本身，而是整型数值对应的二进制。
         * &与  |或  ^异或 ~按位取反 <<左移 >>右移  >>>按位右移补零,左右移动的是
         * 对于编程高手来说，为了提高程序的性能，会在一些地方使用位运算。比如说，HashMap 在计算哈希值的时候
         */
        int a=60,b=13;
        System.out.println(Integer.toBinaryString(a));//111100
        System.out.println(Integer.toBinaryString(b));//001101
        int c = a & b;
        // 001100 12
        System.out.println("a & b：" + c + "，二进制是：" + Integer.toBinaryString(c));

        // 111101 61
        c = a | b;
        System.out.println("a | b：" + c + "，二进制是：" + Integer.toBinaryString(c));
        // 001110 49
        c = a ^ b;
        System.out.println("a ^ b：" + c + "，二进制是：" + Integer.toBinaryString(c));
        // 11111111111111111111111111000011,他是32位一起来 -61
        c = ~a;
        System.out.println("~a：" + c + "，二进制是：" + Integer.toBinaryString(c));
        // 11110000，没有超出32位，不会省略高位 240
        c = a << 2;
        System.out.println("a << 2：" + c + "，二进制是：" + Integer.toBinaryString(c));
        // 1111 15
        c = a >> 2;
        System.out.println("a >> 2：" + c + "，二进制是：" + Integer.toBinaryString(c));
        // 001111 15
        c = a >>> 2;
        System.out.println("a >>> 2：" + c + "，二进制是：" + Integer.toBinaryString(c));

        System.out.println("=======================================");
        /**
         * 4.逻辑运算符，有5个，感觉面试有几率会考
         * 逻辑与运算符（&&）：多个条件中只要有一个为 false 结果就为 false，也就是说如果第一个为false就不会检查第二个
         * 逻辑或运算符（||）：多个条件只要有一个为 true 结果就为 true，如果第一个是true就不会检查第二个
         * 逻辑非运算符（!）：用来反转条件的结果，如果条件为 true，则逻辑非运算符将得到 false。
         * 单逻辑与运算符（&）：很少用，因为不管第一个条件为 true 还是 false，依然会检查第二个。
         * 单逻辑或运算符（|）：也会检查第二个条件。
         * 也就是说，& 和 | 性能不如 && 和 ||
         */

        System.out.println("=======================================");

        /**
         * 5.赋值运算符=，把操作符右侧的值赋值给左侧的变量
         *  1.= 右侧的算术表达式默认为 int 类型，所以如果是范围很小的short，进行赋值要注意强制转换
         *  2.边界问题，比如两个int相乘超出int范围，要用范围更大的double去接，但最好还是全都变成double
         *  主要是别产生精度问题
         */
        short x = 10;
        short y = 10;
        // 必须进行强制转换
        x = (short) (x + y);
        System.out.println(x);

        System.out.println("=======================================");

        /**
         * 6.三元运算符，也很简单,简化判断把吧；
         */
        int m = 7;
        int n = 6;
        int min = m>n?n:m;
        System.out.println("min="+min );




    }

}
