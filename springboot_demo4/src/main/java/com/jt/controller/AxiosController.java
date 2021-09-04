package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/axios")
public class AxiosController {
    @Autowired//调用service，最好是调用接口，因为是面向接口编程，解耦
    private UserService userService;

    //RestFul风格
    //http://localhost:82/axios/getById/1
    @GetMapping("/getById/{id}")
    public User getById(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        return user;
    }

    /*超过参数两个以及上，建议使用对象接手
    @PathVariable("sex") String sex,
    @PathVariable("age") Integer age)
    * */
    //使用对象接受
    @CrossOrigin
    @GetMapping("/user/{sex}/{age}")
    public List<User> getUserSA(User user) {
        List<User> user1 = userService.getSA(user);
        return user1;
    }

    @GetMapping("/getuser")
    public List<User> getUser(User user) {
        List<User> user1 = userService.getUser(user);
        return user1;
    }

    //方式1，直接带参数 删除，
    //http://localhost:82/user/deleteById?id=232
    @DeleteMapping("/deleteById")
    public String deleteById(Integer id) {
        userService.delById(id);
        return "删除数据成功";

    }

    /*
    * let id = 233
	let url2 = "http://localhost:82/axios/delete/${id}"*/
    //方式2：模板字符串的写法
    @DeleteMapping("/delete")
    public String deleteByI(User user) {
        userService.del(user);
        return "删除成功";
    }

    /*新增
     * http://localhost:82/axios/saveUser
     * 返回值：更新成功
     * 难点：
     * json是一个特殊格式的字符串，
     * json和对象 互转
     * 对象转json：responsebody
     * json转对象:requestbody
     * */
    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "插入数据成功";
    }

    /*
    *
    * let url="http://localhost:82/axios/editUser"
    *           id:237,
				name:"小鬼当家",
				age:4,
				sex:"男"
				* 要特别注意，一定要 转requestbody
    * */
    @PutMapping("/editUser")
    public String editUser(@RequestBody User user) {
        userService.editUser(user);
        return "更新成功";
    }

    /*
    * 根据名字更改
           name是小鬼当家的改为黑贞
    如果有多个参数，并且重复，如何封装
    restful+对象
    let name="小鬼当家"
    let user2={
            name:"黑贞",
    age:188,
    sex:"女"
}
    模板字符串，必须使用以下引号
    let url2=`http://localhost:82/axios/editUserByName/${name}`
    * restful风格的时候，restful的名称不要和对象的属性名称重名，否则会覆盖
    */

    @PutMapping("/editUserByName/{namewhere}")
    public String editUserByName(@PathVariable String namewhere,@RequestBody User user) {
        userService.editUserByName(namewhere,user);
        return "修改成功22222222222";
    }
}
