package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/vue")
public class VueController {

    @Autowired
    private UserService userService;

    /**
     * 这是一个查询所有的api，显示在页面上，不需要传入任何参数
     * url：http://localhost:82/vue/findAll
     * @return
     */
    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    /**
     * 这是插入数据的api，我们传入的参数是user对象，@RequestBody 是将json对象转成json数据格式
     *  url：http://localhost:82/vue/addUser
     * @param user
     * @return "插入数据成功"
     */

    @PostMapping("/addUser")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "插入数据成功";
    }

    /**
     * 更新数据的api，我们传入的参数是user对象，@RequestBody 是将json对象转成json数据格式
     * 更新：http://localhost:82/vue/updateUser
     * @param user
     * @return "更新成功"
     */

    @PutMapping("/updateUser")
    public String editUser(@RequestBody User user) {
        userService.editUser(user);
        return "更新成功";
    }

    /**
     * 删除数据的api，是根据我们的id进行查询的额，id是前端传过来的
     *  http://localhost:82/vue/deleteUser?id=" + id
     * @param id
     */

    @DeleteMapping("/deleteUser")
    public void deleteUser(Integer id){
            userService.delById(id);
    }

}
