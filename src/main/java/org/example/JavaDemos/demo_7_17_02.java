package org.example.JavaDemos;

/**
 * java基本数据类型类型的缓存池刨析
 * new Intager 会创建新的对象；而Intager会使用调用缓存池中的对象，对此调用都是同一个对象
 */
public class demo_7_17_02 {
    public static void main(String[] args) {
        /**
         * 很明显，x,y是两个完全不同的对象，地址不同，仅仅是其中的值相同而已
         */
        Integer x = new Integer(20);
        Integer y = new Integer(20);
        System.out.println(x == y);

        /**
         * 由于z k都是取缓存池中的值，因此相同，我们可以阅读valueof方法的源码
         * public static Integer valueOf(int i) {
         *         if (i >= IntegerCache.low && i <= IntegerCache.high)
         *             return IntegerCache.cache[i + (-IntegerCache.low)];
         *         return new Integer(i);
         *     }
         *
         * 进而我们阅读IntegerCaahe的源码
         */
        Integer z = Integer.valueOf(20);
        Integer k = Integer.valueOf(20);
        System.out.println(z == k);

        /**
         * 这里为假的原因是300已经超出缓存池的范围，因此会创建新的对象
         *
         */
        Integer m = Integer.valueOf(300);
        Integer p = Integer.valueOf(300);
        System.out.println(m == p);
    }
}
