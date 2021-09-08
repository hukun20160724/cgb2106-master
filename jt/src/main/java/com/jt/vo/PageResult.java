package com.jt.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: July
 * @Description: 这是有页面展示数据的页面
 * @Date Created in 2021-09-04 15:10
 * @Modified By:
 */
@Data
@Accessors(chain = true)
public class PageResult implements Serializable {
    private String query;
    private Integer pageNum;
    private Integer pageSize;
    private Long total;
    private Object rows;

}
