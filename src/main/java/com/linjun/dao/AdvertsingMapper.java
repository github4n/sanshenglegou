package com.linjun.dao;

import com.linjun.model.Advertsing;
import com.linjun.model.AdvertsingCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertsingMapper {
    long countByExample(AdvertsingCriteria example);

    int deleteByExample(AdvertsingCriteria example);

    int insert(Advertsing record);

    int insertSelective(Advertsing record);

    List<Advertsing> selectByExample(AdvertsingCriteria example);

    int updateByExampleSelective(@Param("record") Advertsing record, @Param("example") AdvertsingCriteria example);

    int updateByExample(@Param("record") Advertsing record, @Param("example") AdvertsingCriteria example);
}