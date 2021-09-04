package com.jt.service.imple;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.RightsMapper;
import com.jt.pojo.Rights;
import com.jt.service.RightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: July
 * @Description:
 * @Date Created in 2021-09-04 11:29
 * @Modified By:
 */
@Service
public class RightsServiceImpl implements RightsService {
    @Autowired
    private RightsMapper rightsMapper;

    
    //获取左侧菜单栏
    @Override
    public List<Rights> getRightList() {
        //查询一级列表的信息
        List<Rights> listOne=rightsMapper.selectList(new QueryWrapper<Rights>().eq("parent_id",0));
        //遍历一级信息，查询二级
        for (Rights rights : listOne) {
            //父id是listone集合里面的id的就是二级信息
            List<Rights> listTwo=rightsMapper.selectList(new QueryWrapper<Rights>().eq("parent_id",rights.getId()));
            //把数据封装
            rights.setChildren(listTwo);
        }
        return listOne;
    }
}
