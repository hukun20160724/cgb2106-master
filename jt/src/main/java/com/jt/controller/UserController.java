package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
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
}
