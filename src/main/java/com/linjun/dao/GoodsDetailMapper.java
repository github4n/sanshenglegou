package com.linjun.dao;

import com.linjun.model.GoodsDetail;
import com.linjun.model.GoodsDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsDetailMapper {
    long countByExample(GoodsDetailCriteria example);

    int deleteByExample(GoodsDetailCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsDetail record);

    int insertSelective(GoodsDetail record);

    List<GoodsDetail> selectByExample(GoodsDetailCriteria example);

    GoodsDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsDetail record, @Param("example") GoodsDetailCriteria example);

    int updateByExample(@Param("record") GoodsDetail record, @Param("example") GoodsDetailCriteria example);

    int updateByPrimaryKeySelective(GoodsDetail record);

    int updateByPrimaryKey(GoodsDetail record);
}