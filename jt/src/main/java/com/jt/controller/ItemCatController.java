package com.jt.controller;

import com.jt.pojo.ItemCat;

import com.jt.service.ItemCatService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: July
 * @Description:
 * @Date Created in 2021-09-08 18:33
 * @Modified By:
 */
@RequestMapping("/itemCat")
@CrossOrigin
@RestController
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    /**
     * 请求路径: /itemCat/findItemCatList/{level}
     * 请求类型: get
     * 请求参数: level
     */
    @GetMapping("/findItemCatList/{level}")
    public SysResult findItemCatList(@PathVariable Integer level) {
        List<ItemCat> itemCatList = itemCatService.findItemCatList(level);
        return SysResult.success(itemCatList);

    }
}
