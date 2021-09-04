package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin//跨域问题
@RequestMapping("/user")
@SuppressWarnings("all")
public class UserController {

    @Autowired//调用service，最好是调用接口，因为是面向接口编程，解耦
    private UserService userService;
    @RequestMapping("/getAll")
    public List<User> getAll() {
        List<User> all = userService.getAll();
        return all;
    }

    /*
     * findUserById?id=1
     * */
    @GetMapping("/findUserById")
    public User findUserById(Integer id) {
        return userService.findUserById(id);
    }

    /*
     *   * 规则: SpringMVC 可以利用对象的方式接收
     * 底层实现: 参数name="xxx" 拼接set形成setName,之后检查对象中
     * 是否有对应的setName(), 如果匹配该方法,则为对象赋值.
     * 注意事项: 参数名称最好以属性名称一致
     * 注意事项: 参数名称最好与属性名称一致
     *
     * URL地址: http://localhost:8090/findUserByNS?name=王昭君&sex=女
     * 参数：  name=xxx&sex=xx*/

    @GetMapping("/findUser")
    public List<User> find(User user) {
        return userService.findname(user);
    }

    //RestFul风格
    @RequestMapping("/getById/{id}")
    public User getById(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        return user;
    }

    @RequestMapping("/getByNA/{sex}/{age}")
    /*超过参数两个以及上，建议使用对象接手
    @PathVariable("sex") String sex,
    @PathVariable("age") Integer age)
    * */
    //使用对象接受
    public List<User> getByNA(User user) {
        List<User> user1 = userService.getNA(user);
        return user1;
    }

    //接受数/*
    // ids=1,2,3,4,5,6,7
    //http://localhost:82/user/getIds?ids=1,3,4,5
    @GetMapping("/getIds")
    public List<User> getByIds(Integer[] ids) {
        return userService.getIds(ids);
    }

    @RequestMapping("/getTwo")
    public List<User> getTwo() {
        List<User> selecTwo = userService.selectTwo();
        return selecTwo;
    }

}
