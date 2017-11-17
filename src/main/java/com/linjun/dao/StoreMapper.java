package com.linjun.dao;

import com.linjun.model.Store;
import com.linjun.model.StoreCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreMapper {
    long countByExample(StoreCriteria example);

    int deleteByExample(StoreCriteria example);

    int insert(Store record);

    int insertSelective(Store record);

    List<Store> selectByExample(StoreCriteria example);

    int updateByExampleSelective(@Param("record") Store record, @Param("example") StoreCriteria example);

    int updateByExample(@Param("record") Store record, @Param("example") StoreCriteria example);
}