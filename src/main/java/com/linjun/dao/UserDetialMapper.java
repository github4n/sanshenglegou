package com.linjun.dao;

import com.linjun.model.UserDetial;
import com.linjun.model.UserDetialCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetialMapper {
    long countByExample(UserDetialCriteria example);

    int deleteByExample(UserDetialCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(UserDetial record);

    int insertSelective(UserDetial record);

    List<UserDetial> selectByExample(UserDetialCriteria example);

    UserDetial selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserDetial record, @Param("example") UserDetialCriteria example);

    int updateByExample(@Param("record") UserDetial record, @Param("example") UserDetialCriteria example);

    int updateByPrimaryKeySelective(UserDetial record);

    int updateByPrimaryKey(UserDetial record);
}