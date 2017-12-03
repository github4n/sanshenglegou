package com.linjun.dao;

import com.linjun.model.Creditgoods;
import com.linjun.model.CreditgoodsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditgoodsMapper {
    long countByExample(CreditgoodsCriteria example);

    int deleteByExample(CreditgoodsCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Creditgoods record);

    int insertSelective(Creditgoods record);

    List<Creditgoods> selectByExample(CreditgoodsCriteria example);

    Creditgoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Creditgoods record, @Param("example") CreditgoodsCriteria example);

    int updateByExample(@Param("record") Creditgoods record, @Param("example") CreditgoodsCriteria example);

    int updateByPrimaryKeySelective(Creditgoods record);

    int updateByPrimaryKey(Creditgoods record);
}