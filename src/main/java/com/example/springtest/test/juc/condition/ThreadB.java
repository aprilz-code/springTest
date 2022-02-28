package com.example.springtest.test.juc.condition;

/**
 * @Classname ThreadB
 * @Description TODO
 * @Date 2022/2/28 9:42
 * @Created by white
 */
public class ThreadB extends Thread{

    private MyService service;

    public ThreadB(MyService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.awaitB();//调用MyService里的awaitB()方法
    }
}
