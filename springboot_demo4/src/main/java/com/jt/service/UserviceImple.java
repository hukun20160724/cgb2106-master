package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserviceImple implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> findname(User user) {
        return userMapper.selectList(new QueryWrapper<>(user));
    }

    @Override
    public List<User> getNA(User user) {
        List<User> users = userMapper.selectList(
                new QueryWrapper<User>().eq("sex", user.getSex())
                        .le("age", user.getAge()));
        return users;
    }

    //ids
    @Override
    public List<User> getIds(Integer[] ids) {
        //数组转成list
        List<Integer> integers = Arrays.asList(ids);
        List<User> id = userMapper.selectBatchIds(integers);
        return id;
    }

    //浏览器获取女性 18岁
    @Override
    public List<User> getSA(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        QueryWrapper<User> gu = queryWrapper.eq("sex", user.getSex())
                .gt("age", user.getAge());
        return userMapper.selectList(gu);
    }
    //王昭君 啥的
    @Override
    public List<User> getUser(User user) {
        return userMapper.selectList(new QueryWrapper<>(user).eq("name",user.getName())
                .eq("sex",user.getSex()).eq("age",user.getAge()));
    }

    @Override
    public void delById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void del(User user) {
        userMapper.deleteById(user.getId());
    }
//saveUser
    @Override
    public void saveUser(User user) {
        userMapper.insert(user);
    }
//更新数据
    @Override
    public void editUser(User user) {
        userMapper.updateById(user);
    }
// 根据名称更改
    @Override
    public void editUserByName(String namewhere, User user) {
        userMapper.update(user,new QueryWrapper<>(user).eq("name",namewhere));
    }


    @Override
    public User getById(Integer id) {
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public List<User> selectTwo() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("sex", "女").le("age", 18);
        List<User> users = userMapper.selectList(userQueryWrapper);
        return users;

    }

    /*vue练习的方法*/
    @Override
    public List<User> findAll() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

}
