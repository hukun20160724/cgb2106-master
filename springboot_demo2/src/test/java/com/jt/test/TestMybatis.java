package com.jt.test;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMybatis {

    @Autowired
    private UserMapper userMapper; //必须有对象!!!!

    @Test
    public void test01() {
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
    }

    @Test
    public void test02() {
        int i = userMapper.addAll(new User().setName("飞天小西瓜").setAge(20).setSex("女"));
        if (i == 1) {
            System.out.println("插入数据成功");
        }
    }

    @Test
    public void test003() {
        int upda = userMapper.upda("阿富汗", "塔利班");
        if (upda == 1) {
            System.out.println("更新成功");
        }
    }

    @Test
    public void test004() {
        int name = userMapper.dele("塔利班");
        if (name == 1) {
            System.out.println("删除成功");
        }
    }

    @Test
    public void test005() {
        List<User> xiao = userMapper.findXiao("飞天小西瓜", "女");
        for (User user : xiao) {
            System.out.println(user);
        }
    }

    @Test
    public void test006() {
        List<User> xiao = userMapper.findFemale("女", 18);
        for (User user : xiao) {
            System.out.println(user);
        }
    }

    @Test
    public void test007() {
        List<User> xiao = userMapper.findJun("%君%");
        for (User user : xiao) {
            System.out.println(user);
        }
    }
    @Test
    public void test008() {
        List<User> xiao = userMapper.findNv("女");
        for (User user : xiao) {
            System.out.println(user);
        }
    }
}
