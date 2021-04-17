package com.cn.dao;

import org.apache.ibatis.annotations.Select;


public interface UserMapper {

    @Select("select user")
    String getSelect(Integer id);

}
