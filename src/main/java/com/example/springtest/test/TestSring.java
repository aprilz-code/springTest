package com.example.springtest.test;

/**
 * @Classname TestSring
 * @Description TODO
 * @Date 2022/3/6 19:08
 * @Created by white
 */
public class TestSring {
    public static void main(String[] args) {
        String s1 = "111";
        String s2 = "111";
        String a = new String("111");
        String b = new String("111");
        //s1,s2 和字面上的 test 都是指向 JVM 字符串常量池中的"111"对象，他们指向同一个对象。
        //String 重写了equals ，new String生成两个对象，a在栈里，“111”在堆里。
        System.out.println(s1== s2); // true
        System.out.println(a== b); // false
        System.out.println(a.equals(b)); //true


        String str1 = "abc";
        //栈中开辟一块空间存放引用 str1，str1 指向池中 String 常量"abc"
        String str2 = "def"; //栈中开辟一块空间存放引用 str2，str2 指向池中 String 常量"def"
         String str3 = str1 + str2;
        // /栈中开辟一块空间存放引用 str3
        // str1+str2 通过 StringBuilder 的最后一步 toString()方法返回一个新的 String 对象"abcdef"
        // 会在堆中开辟一块空间存放此对象，引用str3指向堆中的(str1+str2)所返回的新String对象。
         System.out.println(str3 == "abcdef");//false
        // 返回 false 因为 str3 指向堆中的"abcdef"对象，而"abcdef"是字符池中的对象，所以结果为 false。
        // JVM 对 String str="abc"对象放在常量池是在编译时做的，而 String str3=str1+str2 是在运行时才知道的，new 对象也是在运行时才做的。
    }
}
