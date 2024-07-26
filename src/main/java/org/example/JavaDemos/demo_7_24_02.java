package org.example.JavaDemos;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @desc: 学习Java反射
 * @author: yin hang
 * @date: 2024/7/24
 */
public class demo_7_24_02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        /**
         * 正射：正常创建对象，调用对象方法
         * 反射：只知道这个类的一些基本信息，将类描述出来,反射的成本是要比正射的高得多
         * 反射缺点：
         * 1.破坏封装：由于反射允许访问私有字段和私有方法，所以可能会破坏封装而导致安全问题。
         * 2.性能开销：由于反射涉及到动态解析，因此无法执行 Java 虚拟机优化，再加上反射的写法的确要复杂得多，
         * 所以性能要比“正射”差很多，在一些性能敏感的程序中应该避免使用反射。
         *
         * 反射主要的应用场景：
         * 1.开发通用框架：像 Spring，为了保持通用性，通过配置文件来加载不同的对象，调用不同的方法。
         * 2.动态代理：在面向切面编程中，需要拦截特定的方法，就会选择动态代理的方式，而动态代理的底层技术就是反射。
         * 3.注解：注解本身只是起到一个标记符的作用，它需要利用发射机制，根据标记符去执行特定的行为。
         *
         * 简单总结：
         * 反射是 Java 中的一个强大特性，它允许在运行时检查和操作类、接口、字段和方法。
         * 反射是 Java 的核心组件，支持各种框架和库的实现，如 Spring、Hibernate等。
         * 使用反射，可以在运行时动态地创建对象、调用方法和访问字段，而无需在编译时了解这些对象的具体实现。
         * 反射的几个关键类:
         * Class：代表一个类或接口，包含了类的结构信息（如名称、构造函数、方法、字段等）。通过 Class 对象，可以获取类的元数据并操作类的实例。
         * Constructor：代表类的构造方法，用于创建类的实例。
         * Method：代表类的方法，可以通过它调用类的实例方法。
         * Field：代表类的字段，可以获取或修改字段的值。
         * Modifier：包含方法、字段和类的访问修饰符（如 public、private 等）。
         */
        // 正射写法
        Writer writer = new Writer();
        writer.setName("舟亢");
        System.out.println(writer.getName());

        // 反射写法
        // 第一步，获取反射类的 Class 对象：
        Class c = Class.forName("org.example.JavaDemos.Writer");
        // 第二步，通过 Class 对象获取构造方法 Constructor 对象，以及要调用的方法的 Method 对象
        Method method1 = c.getMethod("setName", String.class);
        Method method2 = c.getMethod("getName");
        Constructor constructor = c.getConstructor();
        // 通过 Constructor 对象初始化反射类对象
        Object o = constructor.newInstance();
        // 通过 invoke() 方法执行阅读invoke()的源码，知道invoke是通过MethodAccessor接口来完成
        method1.invoke(o,"舟舟亢亢");
        System.out.println(method2.invoke(o));
        System.out.println("===================================");

        /**
         * 第一步：获取反射中的类对象，三种方式
         */
        // 1.使用Class.forName()，参数为反射类的完全限定名。,使用getCanonicalName()返回基础类的规范名称
        Class c1 = Class.forName("java.lang.String");
        System.out.println(c1.getCanonicalName());
        // 2.类名 + .class，只适合在编译前就知道操作的 Class。
        Class c2 = String.class;
        System.out.println(c2.getCanonicalName());
        // 3.使用类对象的getClass方法
        String s = new String("呱");
        Class c3 = s.getClass();
        System.out.println(c3.getCanonicalName());

        System.out.println("===================================");
        /**
         * 第二步：通过反射创建对象的两种方式
         */
        // 1.使用Class对象的newInstance方法,新实例
        Class c4 = Writer.class;
        Writer writer1 = (Writer) c4.newInstance();
        // 2.使用Construct对象的newInstance方法
        Class c5 = Class.forName("org.example.JavaDemos.Writer");
        Constructor constructor1 = c5.getConstructor();
        Object object = constructor1.newInstance();

        System.out.println("===================================");
        /**
         * 第三步，获取构造方法，Class提供以下方法来获取Constructor对象：
         * getConstructor()：返回反射类的特定 public 构造方法，可以传递参数，参数为构造方法参数对应 Class 对象；缺省的时候返回默认构造方法。
         * getDeclaredConstructor()：返回反射类的特定构造方法，不限定于 public 的。
         * getConstructors()：返回类的所有 public 构造方法。
         * getDeclaredConstructors()：返回类的所有构造方法，不限定于 public 的。
          */
        // 1.使用getConstructor来返回默认构造方法
        Constructor constructor2 = c5.getConstructor();
        // 2.使用getDeclaredConstructors来返回类的所有构造方法
        Constructor[] constructors = String.class.getDeclaredConstructors();
        System.out.println("这是String的所有构造方法");
        for(Constructor constructor3 : constructors){
            System.out.println(constructor3);
        }

        System.out.println("===================================");
        /**
         * 第四步：获取字段，基本与构造方法类似，关键词为Field
         *
         */
        Field[] fields = String.class.getFields();
        System.out.println("这是String所有的关键字");
        for (Field f : fields){
            System.out.println(f);
        }
        // 由于name是private所以要使用Declared的方法
        Field field = Writer.class.getDeclaredField("name");
        System.out.println(field);

        System.out.println("===================================");
        /**
         * 第五步：获取方法，基本与构造方法类似，关键词为Method
         *
         */
        Method[] methods = System.class.getDeclaredMethods();
        System.out.println("这是System的所有方法");
        for (Method m : methods){
            System.out.println(m);
        }
    }
}
