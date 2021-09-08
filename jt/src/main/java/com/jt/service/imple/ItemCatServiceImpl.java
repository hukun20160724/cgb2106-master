package com.jt.service.imple;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatMapper;
import com.jt.pojo.ItemCat;
import com.jt.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: July
 * @Description:
 * @Date Created in 2021-09-08 18:35
 * @Modified By:
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public List<ItemCat> findItemCatList(Integer level) {
        /**
         * 我们要开始查询的时候，应该知道我们数据库的数据是分为三级的
         * 一级就是我们的爷爷，爷爷是没有父亲的，所以他的父id就是0
         * 一个爷爷有很多个爸爸，所以在查出所有的爸爸之后，需要遍历，根据爷爷的id，来查询爷爷的儿子们
         * 一个儿子会有很多个孙子，那么我们，同样的方法，我们可以查询每一个儿子，在每一集查询完成之后，对数据进行一个封装
         * 最后输出爷爷和他的儿子孙子们
         */
        QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", 0);
        List<ItemCat> grandFathers = itemCatMapper.selectList(queryWrapper);
        //遍历爷爷
        for (ItemCat grandFather : grandFathers) {
            queryWrapper.clear();
            queryWrapper.eq("parent_id", grandFather.getId());
            //查询出儿子
            List<ItemCat> sons = itemCatMapper.selectList(queryWrapper);
            for (ItemCat son : sons) {
                queryWrapper.clear();
                queryWrapper.eq("parent_id", son.getId());
                //查出孙子
                List<ItemCat> gradnSons = itemCatMapper.selectList(queryWrapper);
                son.setChildren(gradnSons);
            }
            grandFather.setChildren(sons);
        }
        return grandFathers;
    }
}
