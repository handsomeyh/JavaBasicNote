package org.example.JavaDemos.demo_7_26_01;

import lombok.Data;

/**
 * @desc: 使用自己编写的
 * @author: yin hang
 * @date: 2024/7/26
 */
@Data
public class Person {
    private int age;

    // 使用自己编写的注解对name进行显示的注解
    @JsonField(value = "舟舟亢亢")
    private String name;

    @JsonField
    private String bookName;

}
