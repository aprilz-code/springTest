package com.example.springtest.test.juc.condition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname MsgService
 * @Description 消息接受类
 * @Date 2022/2/27 22:16
 * @Created by white
 */

public class MsgService {

    private static volatile MsgService msgService ;

    private MsgService(){};

    private static volatile LinkedList<String> msglink ;
    private static volatile Lock lock ;
    public static volatile Condition empty ;

    public static MsgService getInstance(){
        if(msgService == null){
            synchronized (MsgService.class){
                if(msgService ==null){
                    msgService = new MsgService();
                    msglink= new LinkedList<String>();
                    lock= new ReentrantLock(true);
                    empty = lock.newCondition();
                }

            }
        }
        return  msgService;
    }



    public static void main(String[] args) {
        MsgService instance = MsgService.getInstance();
        instance.startServer();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     //   instance.onReceiveMsg("hello");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第二个消息");
        instance.onReceiveMsg("hello2");
    }
    private void startServer() {
        HandThread t = new MsgService.HandThread();
        t.start();
    }
    public static void onReceiveMsg(String message) {
        System.out.println(msgService.hashCode());
        System.out.println("lock:" +lock.hashCode());
        System.out.println("msglink:" +msglink.hashCode());
        System.out.println("empty:" +empty.hashCode());
        lock.lock();
        msglink.add(message);
       //empty.signal();
        empty.signalAll();
        lock.unlock();
    }

      public static class HandThread extends Thread {
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (msglink.size() == 0) {
                        System.out.println("暂无主动通知消息");
                        empty.await();
                    }
                    System.out.println("msglink:" + msglink.size());
                    String msg = msglink.removeFirst();
                    System.out.println(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
