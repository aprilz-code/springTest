package com.example.springtest.test.juc.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname MyService
 * @Description 封装的业务方法类
 * @Date 2022/2/28 9:38
 * @Created by white
 */
public class MyService {

    private Lock lock = new ReentrantLock();

    public Condition conditionA = lock.newCondition();//创建conditionA对象
    public Condition conditionB = lock.newCondition();//创建conditionB对象

    public void awaitA(){
        try{
            lock.lock();//事前加lock，保证线程同步，相当于Synchronized作用
            System.out.println("begin awaitA:"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
            conditionA.await();//进入等待，需要被通知才能继续运行下面代码，绑定conditionA对象
            System.out.println(" end awaitA:"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();//最后不忘unlock()
        }
    }


    public void awaitB(){
        try{
            lock.lock();
            System.out.println("begin awaitB:"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
            conditionB.await();//进入等待，需要被通知才能继续运行下面代码，绑定conditionB对象
            System.out.println(" end awaitB:"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }


    public void signalAll_A(){

        try{
            lock.lock();
            System.out.println(" signalAll_A:"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
            conditionA.signalAll();//选择性地通知唤醒所有绑定conditionA的对象
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }

    public void signalAll_B(){

        try{
            lock.lock();
            System.out.println(" signalAll_B:"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
            conditionB.signalAll();//选择性地通知唤醒所有绑定conditionA的对象
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }


}
