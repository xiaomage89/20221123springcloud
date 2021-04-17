package com.cn.dao;

import org.apache.ibatis.annotations.Select;

public interface OrderMapper {

    @Select("select order")
    String getSelect(Integer id);

}
