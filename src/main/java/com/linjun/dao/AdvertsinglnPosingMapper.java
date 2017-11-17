package com.linjun.dao;

import com.linjun.model.AdvertsinglnPosing;
import com.linjun.model.AdvertsinglnPosingCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertsinglnPosingMapper {
    long countByExample(AdvertsinglnPosingCriteria example);

    int deleteByExample(AdvertsinglnPosingCriteria example);

    int insert(AdvertsinglnPosing record);

    int insertSelective(AdvertsinglnPosing record);

    List<AdvertsinglnPosing> selectByExample(AdvertsinglnPosingCriteria example);

    int updateByExampleSelective(@Param("record") AdvertsinglnPosing record, @Param("example") AdvertsinglnPosingCriteria example);

    int updateByExample(@Param("record") AdvertsinglnPosing record, @Param("example") AdvertsinglnPosingCriteria example);
}