package com.linjun.dao;

import com.linjun.model.GoodsBand;
import com.linjun.model.GoodsBandCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsBandMapper {
    long countByExample(GoodsBandCriteria example);

    int deleteByExample(GoodsBandCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsBand record);

    int insertSelective(GoodsBand record);

    List<GoodsBand> selectByExample(GoodsBandCriteria example);

    GoodsBand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsBand record, @Param("example") GoodsBandCriteria example);

    int updateByExample(@Param("record") GoodsBand record, @Param("example") GoodsBandCriteria example);

    int updateByPrimaryKeySelective(GoodsBand record);

    int updateByPrimaryKey(GoodsBand record);
}