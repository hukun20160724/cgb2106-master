package com.jt.config;

import com.jt.pojo.Dog;
import com.jt.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//作用: 将自己需要的对象交给Spring容器管理
@Configuration  //标识这是一个配置类
public class UserConfig {

    /**
     * 知识点:1.Spring内部维护一个Map集合
     *       2. Map集合 key/value 分别是谁???
     *       3.IOC管理的对象的方式   1.@Controller等注解 2.@bean
     *
     * 1.注解组合:  @Configuration +  @Bean
     * 2.什么是bean: 被spring管理的对象就是bean
     * 3.@Bean注解的作用
     *      将方法的返回值对象交给Spring管理
     * 4.Spring如何管理对象?
     *   数据结构: Map集合   Map<K,V>
     *   key:   对象的ID
     *   value: 实例化之后的对象
     * demo1: Spring如何管理对象
     *      key: 方法的名称
     *      value: 方法的返回值   Map<user,new User()>
     *
     * demo2:
     *      @Controller
     *      HelloController{}
     *      key: helloController   首字母小写
     *      value: spring通过反射创建的HelloController对象
     * @return
     */
    @Bean
    public User user(){

        return new User(101,"好好学习");
    }

    @Bean
    public Dog dog(){

        return new Dog("啸天", "中华田园犬");
    }
}
