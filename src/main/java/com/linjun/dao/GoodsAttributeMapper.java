package com.linjun.dao;

import com.linjun.model.GoodsAttribute;
import com.linjun.model.GoodsAttributeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsAttributeMapper {
    long countByExample(GoodsAttributeCriteria example);

    int deleteByExample(GoodsAttributeCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsAttribute record);

    int insertSelective(GoodsAttribute record);

    List<GoodsAttribute> selectByExample(GoodsAttributeCriteria example);

    GoodsAttribute selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsAttribute record, @Param("example") GoodsAttributeCriteria example);

    int updateByExample(@Param("record") GoodsAttribute record, @Param("example") GoodsAttributeCriteria example);

    int updateByPrimaryKeySelective(GoodsAttribute record);

    int updateByPrimaryKey(GoodsAttribute record);
}