package com.example.springtest.test;

/**
 * @Classname TransferValueDemo
 * @Description TODO
 * @Date 2022/2/26 14:03
 * @Created by white
 */

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 值传递和引用传递
 *  @author: mx
 * @create: 2020-03-14-18:25
 */
class Person {
    private Integer id;
    private String personName;

    public Person(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
public class TransferValueDemo {

    public void changeValue1(int age) {
        age = 30;
    }

    public void changeValue2(Person person) {
        person.setPersonName("XXXX");
    }
    public void changeValue3(String str) {
        str = "XXX";
    }

    public static void main(String[] args) {
        TransferValueDemo test = new TransferValueDemo();

        // 定义基本数据类型
        int age = 20;
        test.changeValue1(age);
        System.out.println("age ----" + age);

        // 实例化person类
        Person person = new Person("abc");
        test.changeValue2(person);
        System.out.println("personName-----" + person.getPersonName());
        new ReentrantReadWriteLock();
        // String
        String str = "abc";
        test.changeValue3(str);
        System.out.println("string-----" + str);

    }
}

