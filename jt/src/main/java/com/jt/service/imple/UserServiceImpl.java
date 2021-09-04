package com.jt.service.imple;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    /**
     *
     * @param user
     * @return
     */
    @Override
    public String login(User user) {
        //获取我们的输入明文密码
        String password=user.getPassword();
        //进行加密处理
        String md5= DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(md5);
        System.out.println(md5);
        //查询数据库
        User user1 = userMapper.selectOne(new QueryWrapper<>(user));
        if (user1==null){
            return null;
        }
        //查询不为空，则证明登录成功
        //使用UUId，生成一个token
        String token= UUID.randomUUID().toString().replace("-","");
        return  token;

    }

}
