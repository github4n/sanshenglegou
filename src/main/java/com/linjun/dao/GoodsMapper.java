package com.linjun.dao;

import com.linjun.model.Goods;
import com.linjun.model.GoodsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    long countByExample(GoodsCriteria example);

    int deleteByExample(GoodsCriteria example);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsCriteria example);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsCriteria example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsCriteria example);
}