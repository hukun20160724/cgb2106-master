package com.jt.test;

import com.jt.pojo.Dog;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 原理说明:
 *  1.当测试类执行时,会根据SpringBoot的配置,动态启动Spring容器.
 *  2.当spring容器启动时,会加载所有的注解和配置类,最终将所有的对象
 *  交给Spring容器管理  Map集合
 *  3.@SpringBootTest 通过这个注解,可以动态的从spring容器中
 *  获取对象
 *
 */
@SpringBootTest
public class TestSpring {

    /**
     * 对象的注入方式:
     *      1.构造注入
     *      2.set注入
     *
     * Set注入方式:
     *      1. 根据类型注入 (默认规则)
     *      2. 根据名称注入   @Autowired
     *                      @Qualifier("user")
     */
    @Autowired
    //@Qualifier(value="user")
    private User user;

    //知识点: Spring容器中一般都是单实现
    @Autowired
    private Dog dog;

    //编辑测试代码,测试对象是否可以正确获取
    @Test
    public void testUser(){
        System.out.println(user.toString());
    }

    @Test
    public void testDog(){
        System.out.println(dog);
    }

    @Test
    public void testTx(){
        //模拟测试方法的报错
        int a = 1/0;
    }
}
