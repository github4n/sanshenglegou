package com.linjun.dao;

import com.linjun.model.Store;
import com.linjun.model.StoreCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreMapper {
    long countByExample(StoreCriteria example);

    int deleteByExample(StoreCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Store record);

    int insertSelective(Store record);

    List<Store> selectByExample(StoreCriteria example);

    Store selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Store record, @Param("example") StoreCriteria example);

    int updateByExample(@Param("record") Store record, @Param("example") StoreCriteria example);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}