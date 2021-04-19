package com.example.demo.mapper;

import com.example.demo.model.User;
import jdk.nashorn.internal.parser.Token;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 陈亦铖
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_Id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
    @Select("select * from user where token=#{token}")
    User findByToken(String token);
}
