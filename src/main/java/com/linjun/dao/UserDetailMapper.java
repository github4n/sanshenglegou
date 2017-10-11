package com.linjun.dao;

import com.linjun.model.UserDetail;
import com.linjun.model.UserDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDetailMapper {
    long countByExample(UserDetailCriteria example);

    int deleteByExample(UserDetailCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    List<UserDetail> selectByExample(UserDetailCriteria example);

    UserDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserDetail record, @Param("example") UserDetailCriteria example);

    int updateByExample(@Param("record") UserDetail record, @Param("example") UserDetailCriteria example);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);
}