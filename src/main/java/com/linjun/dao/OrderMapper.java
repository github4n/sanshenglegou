package com.linjun.dao;

import com.linjun.model.Order;
import com.linjun.model.OrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    long countByExample(OrderCriteria example);

    int deleteByExample(OrderCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderCriteria example);

    Order selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderCriteria example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderCriteria example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}