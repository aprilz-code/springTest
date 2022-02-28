package com.example.springtest.test.juc.condition;

/**
 * @Classname ThreadA
 * @Description TODO
 * @Date 2022/2/28 9:41
 * @Created by white
 */
public class ThreadA extends Thread{

    private MyService service;

    public ThreadA(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.awaitA();//调用MyService里的awaitA()方法
    }
}
