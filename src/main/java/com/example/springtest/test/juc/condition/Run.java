package com.example.springtest.test.juc.condition;

/**
 * @Classname Run
 * @Description TODO
 * @Date 2022/2/28 9:43
 * @Created by white
 */
public class Run {

    public static void main(String[] args) {

        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.setName("线程A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("线程B");
        b.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        service.signalAll_A();//通知唤醒绑定ConditionA的线程，使其代码继续执行
    }

}
