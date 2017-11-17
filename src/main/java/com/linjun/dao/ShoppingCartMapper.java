package com.linjun.dao;

import com.linjun.model.ShoppingCart;
import com.linjun.model.ShoppingCartCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShoppingCartMapper {
    long countByExample(ShoppingCartCriteria example);

    int deleteByExample(ShoppingCartCriteria example);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    List<ShoppingCart> selectByExample(ShoppingCartCriteria example);

    int updateByExampleSelective(@Param("record") ShoppingCart record, @Param("example") ShoppingCartCriteria example);

    int updateByExample(@Param("record") ShoppingCart record, @Param("example") ShoppingCartCriteria example);
}