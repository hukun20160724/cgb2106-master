package com.jt.confgi;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: July
 * @Description:
 * @Date Created in 2021-09-04 15:22
 * @Modified By:
 */
@Configuration
public class MybatisPlusConfig {
    //intercepter:拦截器,mp在进行分页操作时，会被该拦截器拦截
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MARIADB));
        return interceptor;
    }
}

