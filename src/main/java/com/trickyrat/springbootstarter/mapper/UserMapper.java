package com.trickyrat.springbootstarter.mapper;

import com.trickyrat.springbootstarter.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User row);

    int insertSelective(User row);

    User selectByPrimaryKey(Integer id);

    List<User> selectAllUsers();

    int updateByPrimaryKeySelective(User row);

    int updateByPrimaryKey(User row);
}