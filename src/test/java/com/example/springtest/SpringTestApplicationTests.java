package com.example.springtest;

import com.example.springtest.intf.Star;
import com.example.springtest.intf.impl.CaiXuHun;
import com.example.springtest.proxy.CglibProxy;
import com.example.springtest.proxy.StarProxy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringTestApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("1");
    }

    @Test
    void testJDKProxy(){
        Star cxk = new CaiXuHun();
        StarProxy proxy = new StarProxy();
        proxy.setTarget(cxk);
        Object obj = proxy.CreatProxyObj();
        //获取到代理对象
        Star star = (Star)obj;
        star.sing();
    }

    //jdk代理效率高于CGLIB代理
    //不同于jdk动态代理，jdk动态代理要求对象必须实现接口（三个参数的第二个参数 ---CreatProxyObj中的target.getClass().getInterfaces()），cglib对此没有要求。
    //JDK动态代理只能对实现了接口的类生成代理，而不能针对类。
    //CGLIB是针对类实现代理
    @Test
    void testCglibProxy() {
        CglibProxy proxy = new CglibProxy();
        // Object obj = proxy.CreatProxyedObj(Star.class);
        Object obj = proxy.CreatProxyedObj(CaiXuHun.class);
        //获取到代理对象
        Star star = (Star) obj;
        star.sing();
    }

}
