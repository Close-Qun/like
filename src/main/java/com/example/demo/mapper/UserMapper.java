package com.example.demo.mapper;

import com.example.demo.model.User;
import jdk.nashorn.internal.parser.Token;
import org.apache.ibatis.annotations.*;

/**
 * @author 陈亦铖
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_Id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);
    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Integer id);
    @Select("select * from user where account_id=#{accountId}")
    User findByAccountId(@Param("accountId") String accountId);
    @Update("update user set name=#{name},token=#{token},gmt_modified=#{gmtModified}")
    void update(User user);
}

