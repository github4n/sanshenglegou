package com.linjun.dao;

import com.linjun.model.User;
import com.linjun.model.UserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserCriteria example);

    int deleteByExample(UserCriteria example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserCriteria example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByExample(@Param("record") User record, @Param("example") UserCriteria example);
}