package com.example.springtest.intf.impl;

import com.example.springtest.intf.Star;

public class CaiXuHun implements Star{

    @Override
    public String sing() {
        System.out.println("鸡你太美");
        return "sing over";
    }

    @Override
    public String dance() {
        System.out.println("叉叉");
        return "dance over";
    }
}
