package org.example.JavaDemos.demo_7_24_01;

/**
 * @desc: 实际开发中，我们通常不在当前类中直接创建对象并使用它，而是放在使用对象的类中，
 * @author: yin hang
 * @date: 2024/7/24
 */
public class PersonTest {
    /**
     * 我们在本类中进行Person的使用
     */
    public static void main(String[] args) {
        Person person = new Person();
        // 因为 Person 对象没有初始化，因此输出了 String 的默认值 null，int 的默认值 0。
        // 最标准的字段初始化做法是使用构造方法进行初始化
        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(person.sex);
    }

}
