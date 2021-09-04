package com.jt.service;

import com.jt.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(Integer id);


    List<User> selectTwo();

    User findUserById(Integer id);


    List<User> findname(User user);

    List<User> getNA(User user);

    List<User> getIds(Integer[] ids);

    List<User> getSA(User user);

    List<User> getUser(User user);


    void delById(Integer id);

    void del(User user);

    void saveUser(User user);

    void editUser(User user);

    void editUserByName(String namewhere, User user);


    /*vue练习的语句
    **/
    List<User> findAll();
}
