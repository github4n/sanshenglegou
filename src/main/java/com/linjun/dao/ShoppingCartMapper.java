package com.linjun.dao;

import com.linjun.model.ShoppingCart;
import com.linjun.model.ShoppingCartCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShoppingCartMapper {
    long countByExample(ShoppingCartCriteria example);

    int deleteByExample(ShoppingCartCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    List<ShoppingCart> selectByExample(ShoppingCartCriteria example);

    ShoppingCart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingCart record, @Param("example") ShoppingCartCriteria example);

    int updateByExample(@Param("record") ShoppingCart record, @Param("example") ShoppingCartCriteria example);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
}