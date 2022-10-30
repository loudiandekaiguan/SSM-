package com.lyf.dao;

import com.lyf.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;

public interface UserDao {
    @Results(
        value = {
            @Result(id = true, column = "user_id", property = "id"),
            @Result(column = "user_name", property = "name"),
            @Result(column = "user_password", property = "password"),
            @Result(column = "user_email", property = "email"),
            @Result(column = "user_role", property = "role"),
            @Result(column = "user_status", property = "status")
        }
    )
    @Select("select * from user where user_email = #{email} and user_password = #{password} and user_status != '1'")
    User login(User user);
}
