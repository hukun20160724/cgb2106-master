package com.jt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;
//标准写法
//知识点: 为什么需要添加无参构造???
//       利用反射机制实例化对象时,默认调用无参构造
@Data //get/set/toString/equals/hashcode
@NoArgsConstructor //无参构造
@AllArgsConstructor//全参构造
@Accessors(chain = true)
public class User implements Serializable {
    private Integer id;
    private String name;

    //链式加载的底层原理 返回User对象
   /* public User setId(Integer id){
        this.id = id;
        return this;    //代表当前对象!!!!!
    }

    public User setName(String name){
        this.name = name;
        return this;
    }*/
}
