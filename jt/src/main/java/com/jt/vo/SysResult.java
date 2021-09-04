package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: July
 * @Description:这一个对象主要负责前端与后端项目的数据交互，几乎所有的后台服务器的返回值都是他的对象
 * @Date Created in 2021-09-04 10:05
 * @Modified By:
 */
//所有的注解，都加上
@Data
@Accessors
@NoArgsConstructor
@AllArgsConstructor
public class SysResult {

    private Integer status;//200,业务成功。201，业务失败
    private String msg;//服务器的提示信息
    private Object data;//封装后台的返回值

    //定义不同的方法，来接受我们额返回
    //fail,执行失败的时候返回的数据
    public static SysResult fail() {
        return new SysResult(201, "业务执行失败了，哈哈哈哈哈", null);
    }

    //执行成功的时候，不返回后台的数据的时候
    public static SysResult success() {
        return new SysResult(200, "业务执行成功，哦耶！！！！", null);
    }

    //需要返回后的数据data
    public static SysResult success(Object data) {
        return new SysResult(200, "业务执行成功，哦耶！！！！", data);
    }

    //后台有返回的数据，以及服务器的提示信息的时候
    public static SysResult success(String msg, Object data) {
        return new SysResult(200, msg, data);
    }
}
