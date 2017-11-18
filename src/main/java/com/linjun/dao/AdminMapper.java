package com.linjun.dao;

import com.linjun.model.Admin;
import com.linjun.model.AdminCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    long countByExample(AdminCriteria example);

    int deleteByExample(AdminCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminCriteria example);

    Admin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminCriteria example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminCriteria example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}