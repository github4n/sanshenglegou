package com.linjun.dao;

import com.linjun.model.AdvertsingPosing;
import com.linjun.model.AdvertsingPosingCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertsingPosingMapper {
    long countByExample(AdvertsingPosingCriteria example);

    int deleteByExample(AdvertsingPosingCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(AdvertsingPosing record);

    int insertSelective(AdvertsingPosing record);

    List<AdvertsingPosing> selectByExample(AdvertsingPosingCriteria example);

    AdvertsingPosing selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdvertsingPosing record, @Param("example") AdvertsingPosingCriteria example);

    int updateByExample(@Param("record") AdvertsingPosing record, @Param("example") AdvertsingPosingCriteria example);

    int updateByPrimaryKeySelective(AdvertsingPosing record);

    int updateByPrimaryKey(AdvertsingPosing record);
}