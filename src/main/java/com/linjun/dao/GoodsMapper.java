package com.linjun.dao;

import com.linjun.model.Goods;
import com.linjun.model.GoodsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    long countByExample(GoodsCriteria example);

    int deleteByExample(GoodsCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsCriteria example);

    Goods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsCriteria example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsCriteria example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    List<Goods> dimfindStr(String temp);
    List<Goods> dimfindStatus(Long temp,byte status);
    List<Goods> dimfindStrStatus(String temp,byte status);

}