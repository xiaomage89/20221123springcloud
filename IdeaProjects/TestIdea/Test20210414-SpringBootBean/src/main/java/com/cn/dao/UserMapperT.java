package com.cn.dao;

import org.apache.ibatis.annotations.Select;

public interface UserMapperT {

    @Select("select user2")
    String getSelect(Integer id);

}
