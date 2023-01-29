package com.example.springtest.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Classname CasDemo
 * @Description https://note.losey.top/#/JUC/2_%E8%B0%88%E8%B0%88CAS/5_CAS%E5%BA%95%E5%B1%82%E5%8E%9F%E7%90%86/README
 * @Date 2022/2/26 13:08
 * @Created by white
 */
public class CasDemo {
    // 创建一个原子类
    private   static  AtomicInteger atomicInteger = new AtomicInteger(5);

    public static void main(String[] args) throws InterruptedException {
      Thread.sleep(Integer.MAX_VALUE);

        /**
         * 一个是期望值，一个是更新值，但期望值和原来的值相同时，才能够更改
         * 假设三秒前，我拿的是5，也就是expect为5，然后我需要更新成 2019
         */
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data: " + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data: " + atomicInteger.get());
    }
}
