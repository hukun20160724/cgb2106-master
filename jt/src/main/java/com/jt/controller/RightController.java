package com.jt.controller;

import com.jt.pojo.Rights;
import com.jt.service.RightsService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: July
 * @Description:
 * @Date Created in 2021-09-04 11:28
 * @Modified By:
 */
@RestController
@CrossOrigin
@RequestMapping("/rights")
public class RightController {

    @Autowired
    private RightsService rightsService;

    /**
     * 请求路径 /rights/getRightsList
     * 请求类型 GET
     * 请求参数 无
     * 响应数据 SysResult对象
     */
    @GetMapping("/getRightsList")
    public SysResult getRightList() {
        List<Rights> list = rightsService.getRightList();
        return SysResult.success(list);
    }
}
