package org.example.JavaDemos.demo_7_26_01;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @desc: JsonSerializer序列化类
 * @author: yin hang
 * @date: 2024/7/26
 */
public class JsonSerializer {
    /**
     *
     */
    public static String serializa(Object object) throws IllegalAccessException{
        Class<?> objectClass = object.getClass();
        Map<String,String> jsonElements = new HashMap<>();
         for (Field field : objectClass.getDeclaredFields()){
             field.setAccessible(true);
             // isisAnnotationPresent判断字段是否装饰了 JsonField 注解，
             if (field.isAnnotationPresent(JsonField.class)){
                 // 如果是的话，调用 getSerializedKey() 方法，以及获取该对象上由此字段表示的值，并放入 jsonElements 中。
                 jsonElements.put(getSerializedKey(field), (String)field.get(object));
             }
         }
         return toJsonString(jsonElements);
    }


    // 方法用来获取字段上注解的值，如果注解的值是空的，则返回字段名。
    private static String getSerializedKey(Field field) {
        String annotationValue = field.getAnnotation(JsonField.class).value();
        if (annotationValue.isEmpty()) {
            return field.getName();
        } else {
            return annotationValue;
        }
    }

    // 3）toJsonString() 方法借助 Stream 流的方式返回格式化后的 JSON 字符串。
    // Stream 流你还没有接触过，不过没关系，后面我再给你讲。
    private static String toJsonString(Map<String, String> jsonMap) {
        String elementsString = jsonMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + elementsString + "}";
    }

}
