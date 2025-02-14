package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> findAll();
}