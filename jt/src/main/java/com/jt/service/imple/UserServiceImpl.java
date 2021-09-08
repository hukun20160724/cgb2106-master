package com.jt.service.imple;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
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
     * @param user
     * @return
     */
    @Override
    public String login(User user) {
        //获取我们的输入明文密码
        String password = user.getPassword();
        //进行加密处理
        String md5 = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(md5);
        System.out.println(md5);
        //查询数据库
        User user1 = userMapper.selectOne(new QueryWrapper<>(user));
        if (user1 == null) {
            return null;
        }
        //查询不为空，则证明登录成功
        //使用UUId，生成一个token
        String token = UUID.randomUUID().toString().replace("-", "");
        return token;

    }

    /*利用mp得方式分页*/
    @Override
    public PageResult getUserList(PageResult pageResult) {
        //第一部分 实现数据的封装!!!
        int pageNum = pageResult.getPageNum();  //获取页面
        int pageSize = pageResult.getPageSize();//获取条件
        //参数1: page分页对象
        Page<User> page = new Page(pageNum,pageSize);
        //参数2: 分页的查询条件  username模糊查询
        //问题:  如果用户没有传递query  like关键字  拼接参数
        //动态拼接: 传参拼接like  condition:true 拼接like条件
        //         false 不拼接 like关键字
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //判断用户是否传参  如果传参 返回true   反之 返回false
        boolean flag = StringUtils.hasLength(pageResult.getQuery());
        queryWrapper.like(flag,"username",pageResult.getQuery());

        //规则: page2个参数 根据分页查询返回 total/分页后的记录 4个参数
        page = userMapper.selectPage(page,queryWrapper);
        //根据分页对象,获取想要的结果
        List<User> userList = page.getRecords();
        long total = page.getTotal();
        pageResult.setTotal(total).setRows(userList);
        return pageResult;
    }

    @Override
    public void updateStatus(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void addUser(User user) {
        String password = user.getPassword();
        //加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(password)
                .setStatus(true)
                .setCreated(new Date())
                .setUpdated(user.getCreated());
        userMapper.insert(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateById(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
    }


}
