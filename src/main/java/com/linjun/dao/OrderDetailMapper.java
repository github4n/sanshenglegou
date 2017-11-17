package com.linjun.dao;

import com.linjun.model.OrderDetail;
import com.linjun.model.OrderDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailMapper {
    long countByExample(OrderDetailCriteria example);

    int deleteByExample(OrderDetailCriteria example);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailCriteria example);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailCriteria example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailCriteria example);
}