package com.linjun.dao;

import com.linjun.model.GoodsType;
import com.linjun.model.GoodsTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsTypeMapper {
    long countByExample(GoodsTypeCriteria example);

    int deleteByExample(GoodsTypeCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    List<GoodsType> selectByExample(GoodsTypeCriteria example);

    GoodsType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsType record, @Param("example") GoodsTypeCriteria example);

    int updateByExample(@Param("record") GoodsType record, @Param("example") GoodsTypeCriteria example);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
}