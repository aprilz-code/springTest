package com.example.springtest.test;

/**
 * @Classname TestVar
 * @Description 测试成员变量和局部变量
 * @Date 2023/2/4 15:22
 * @Created by aprilz
 */
public class TestVar {
    private static int i;
    private  static  Integer i1;

    public static void main(String[] args) {
        System.out.println(i);// 0
        System.out.println(i1);// null


        // 创建对象：类名 对象名称 = new 类名();
        Tiger dbh = new Tiger();
        System.out.println(dbh.name);  // null
        System.out.println(dbh.age);  // 0
        System.out.println(dbh.weight); // 0.0
        System.out.println(dbh.sex); // 显示没有但是底层编号是0（需要强制转型为int则为0）
        System.out.println(dbh.handsome); // false

        dbh.jump();

         int i3;
         Integer i4;
//        System.out.println(i3); // 未初始化变量
//        System.out.println(i4);// 未初始化变量
    }

}




class Tiger{
    String name ;  // 数据类型 变量名称！ 属性
    int age ;
    double weight;
    char sex ;
    boolean handsome ; // 漂亮吗？true  false。

    public void jump(){ // 方法 行为
        System.out.println("🐅跳的很高！！");
    }
}
