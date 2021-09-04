package com.jt.mapper;

import com.jt.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//@Mapper //将该接口交给Spring管理,spring创建对象
public interface UserMapper {

    //查询所有的user用户
    List<User> findAll();
    /*以mybatis的方式，对数据库进行操作*/
    //入库
    int addAll(User user);
    //更新
    int upda(@Param("nameold") String nameold, @Param("namenew") String namenew);
    //删除操作
    int dele(String name);
    //查询：小乔，且为女
    List<User> findXiao(@Param("name") String name,@Param("sex") String sex);
    //查询年龄小于18，性别为女的
    List<User> findFemale(@Param("sex") String sex,@Param("age") int age);
    //查询名称包含 君 字的数据
    List<User> findJun(@Param("name") String name);
    //查询 性别为女，按照年龄倒叙排列
    List<User> findNv(@Param("sex") String sex);
}
