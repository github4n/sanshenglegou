package com.linjun.dao;

import com.linjun.model.AdvertsingPosing;
import com.linjun.model.AdvertsingPosingCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertsingPosingMapper {
    long countByExample(AdvertsingPosingCriteria example);

    int deleteByExample(AdvertsingPosingCriteria example);

    int insert(AdvertsingPosing record);

    int insertSelective(AdvertsingPosing record);

    List<AdvertsingPosing> selectByExample(AdvertsingPosingCriteria example);

    int updateByExampleSelective(@Param("record") AdvertsingPosing record, @Param("example") AdvertsingPosingCriteria example);

    int updateByExample(@Param("record") AdvertsingPosing record, @Param("example") AdvertsingPosingCriteria example);
}