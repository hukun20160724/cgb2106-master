package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.PageResult;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public List<User> hello(){
        return userService.findAll();
    }
//这个是登录的代码，请求，然后就是，因为登录需要判断令牌是否生成，所以相对来说比较麻烦一点点
    @PostMapping("/login")
    public SysResult login(@RequestBody User user){
        //在E登录成功之后，返回一个token令牌
        String token=userService.login(user);
        if (token==null || token.length()==0 ){
            return SysResult.fail();
        }
        //否则就返回登录成功
        return  SysResult.success(token);
    }
    /**
     * 业务说明: 实现用户列表的分页查询
     * URL地址: http://localhost:8091/user/list?query=查询关键字&pageNum=1&pageSize=10
     * 参数: pageResult接收
     * 返回值: SysResult对象(pageResult)
     */
    @GetMapping("/list")
    public SysResult getUserList(PageResult pageResult) {//3
        pageResult = userService.getUserList(pageResult);
        return SysResult.success(pageResult);//5
    }
    /**
     * 业务说明: 修改状态信息
     * URL:  /user/status/{id}/{status}
     * 参数:  id/status
     * 返回值: SysResult
     */
    @PutMapping("/status/{id}/{status}")
    public SysResult updateStauts(User user){
        userService.updateStatus(user);
        return SysResult.success();
    }
    /**
     * 请求路径 /user/addUser
     * 请求类型 POST
     * 请求参数: 整个form表单数据
     */


    @PostMapping("/addUser")
    public SysResult addUser(@RequestBody User user){
        userService.addUser(user);
        return SysResult.success();
    }

    /**
     * 修改用户信息
     * 请求路径: /user/{id}
     * 请求类型: GET
     * 返回值: SysResult对象
     * 1、第一步，需要查找用户
     */
    @GetMapping("/{id}")
    public SysResult getUser(@PathVariable Integer id){
        User user=userService.getUserById(id);
        //这一个返回指的是 我们的数据回显在form里面
        return SysResult.success(user);
    }
    /**
     * 请求路径: /user/updateUser
     * 请求类型: PUT
     * 请求参数: User对象结构
     * 返回值: SysResult对象
     */
    @PutMapping("/updateUser")
    public SysResult updateUser(@RequestBody User user){
        userService.updateUser(user);
        //这一个返回指的是 我们的数据回显在form里面
        return SysResult.success();
    }

    /**
     * 请求路径: /user/{id}
     * 请求类型: delete
     * 请求参数:
     * 返回值: SysResult对象
     */

    @DeleteMapping("/{id}")
    public SysResult deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        //这一个返回指的是 我们的数据回显在form里面
        return SysResult.success();
    }
}
