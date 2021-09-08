package com.jt.service;

import com.jt.pojo.ItemCat;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: July
 * @Description:
 * @Date Created in 2021-09-08 18:34
 * @Modified By:
 */

public interface ItemCatService {
    List<ItemCat> findItemCatList(Integer level);
}
