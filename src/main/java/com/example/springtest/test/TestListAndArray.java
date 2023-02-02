package com.example.springtest.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname TestListAndArray
 * @Description list and array 互转
 * @Date 2023/2/2 12:03
 * @Created by aprilz
 */
public class TestListAndArray {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        //取出第三个元素
        String s = list.get(2);
        System.out.println(s);

        //这里是转成object数组
        Object[] obs = list.toArray();
        for (Object o1 : obs) {
            System.out.println("obs==" + o1);
        }
        //这里是转成String数组
        //String[] str = list.toArray(new String[list.size()]);
        String[] str = list.toArray(new String[0]);

        for (String s1 : str) {
            System.out.println("str==" + s1);
        }
        System.out.println(str.length);


        //array换list

        //方法一
        //返回的结果其实并不是真正的List
        //asList返回的结果类型实质上是`java.util.Arrays.ArrayList`，而不是我们的真正的java.util.Arrays
        //所以使用起来就有一些出入了
        //他也有set，get等方法，但是不具有add remove方法
        String[] strArr = {"4", "5", "6"};
        List<String> list2 = Arrays.asList(strArr);
        for (String s1 : list2) {
            System.out.println("array to java.util.Arrays.ArrayList ==" + s1);
        }


        //方法二
        //要使用util.ArrayList
        ArrayList<String> arrayList = new ArrayList(Arrays.asList(strArr));
        for (String s2 : arrayList) {
            System.out.println("array to util.ArrayList ==" + s2);
        }

        //方法三
        List list3 = new ArrayList(strArr.length);
        Collections.addAll(list3, strArr);

    }
}
