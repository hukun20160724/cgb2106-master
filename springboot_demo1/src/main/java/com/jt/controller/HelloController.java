package com.jt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //将该类交给Spring管理
//spring负责加载指定的配置文件
//如果注解中只有一个属性名称为value 则可以省略不写
//encoding 指定字符集编码格式
@PropertySource(value="classpath:/msg.properties",encoding="utf-8")
public class HelloController {

    /**
     * 规则:
     *    1. 当Spring容器启动时,会加载YML配置文件.
     *       会将内部的key-value结构 加载到spring维护的内存空间中
     *    2. @Value功能,从spring容器中根据key 动态赋值
     *    3. springel表达式 简称:spel
     *
     * 使用场景:
     *      如果代码中需要给成员变量赋值时,一般采用动态赋值的方式.
     */
    @Value("${msg.hello}")
    private String msg;
    @Value("${pro.msg}")
    private String proMsg;


    @RequestMapping("/hello")
    public String hello(){

        return msg+"||"+proMsg;
    }
}
