package com.linjun.dao;

import com.linjun.model.OrderDetail;
import com.linjun.model.OrderDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailMapper {
    long countByExample(OrderDetailCriteria example);

    int deleteByExample(OrderDetailCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailCriteria example);

    OrderDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailCriteria example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailCriteria example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}