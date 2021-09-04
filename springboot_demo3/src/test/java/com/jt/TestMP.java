package com.jt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@SuppressWarnings("all")
public class TestMP {

    @Autowired
    private UserMapper userMapper;

    /**
     * 完成数据的入库操作
     * 新增user数据(name="阿富汗",age=40,sex="厉害")
     * Sql: insert into demo_user value(xx,xx,xx,xx)
     * 思考: MP实现入库流程!!!
     */
    @Test
    public void test01() {
        User user = new User();
        user.setName("阿富汗").setAge(40).setSex("厉害");
        //以对象的方式操作数据!!!
        userMapper.insert(user);
        System.out.println("入库操作成功!!!!");
    }

    @Test
    public void test02() {
        User user1 = userMapper.selectById(3);
        System.out.println(user1);
    }

    //查询小乔
    @Test
    public void test03() {
        QueryWrapper queryWrapper = new QueryWrapper(new User().setName("小乔").setSex("女"));

        List list = userMapper.selectList(queryWrapper);
        for (Object o : list) {
            System.out.println(o);
        }
    }

    ///查询年龄小于18，性别为女的
    @Test
    public void test04() {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("sex", "女").le("age", 18);
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }

    }

    //查询名称包含 君 字的数据
    @Test
    public void test005() {
        QueryWrapper<User> like = new QueryWrapper<User>().like("name", "君");
        List<User> users = userMapper.selectList(like);
        for (User user : users) {
            System.out.println(user);
        }
    }
    //查询 性别为女，按照年龄倒叙排列

    @Test
    public void test06() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>().eq("sex", "女").
                orderByDesc("age");
        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    //名字和sex不为空的查询
    @Test
    public void test07() {
        //这个意思是，在名字不为空的情况下查询名字为貂蝉的人
        String name = "貂蝉";
        int age = 18;
        boolean nameflag = name == null ? false : true;
        boolean ageflag = age == 0 ? false : true;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>().eq(nameflag, "name", name)
                .eq(ageflag, "age", age);
        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    //批量查询
    @Test
    public void test08() {
        QueryWrapper<User> id = new QueryWrapper<User>().in("id", 1, 3, 5, 7, 9, 13, 16, 45);
        List<User> users = userMapper.selectList(id);
        for (User user : users) {
            System.out.println(user);
        }
    }

    //231的name 改成
    @Test
    public void test09() {
        int i = userMapper.updateById(new User().setId(231).setName("车臣"));
        if (i == 1) {
            User user = userMapper.selectById(231);
            if (user.getName().equals("车臣")) {
                System.out.println("修改成功啦");
                System.out.println(user);
            }
        }
    }

    @Test
    public void test10() {
        //讲名字为阿富汗的列改为名字为塔利班，sex为911
        int update = userMapper.update(new User().setName("塔利班").setSex("911"),
                                        new QueryWrapper<User>().eq("name", "阿富汗"));
        if (update == 1) {
            System.out.println("更新成功");
        }
    }
    @Test
    public void test11() {
        //讲名字为阿富汗的列改为名字为塔利班，sex为911
        int update = userMapper.update(new User().setName("塔利班").setSex("911"),
                new QueryWrapper<User>().eq("name", "阿富汗"));
        if (update == 1) {
            System.out.println("更新成功");
        }
    }
}
