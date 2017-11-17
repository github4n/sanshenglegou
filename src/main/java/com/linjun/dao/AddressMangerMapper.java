package com.linjun.dao;

import com.linjun.model.AddressManger;
import com.linjun.model.AddressMangerCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressMangerMapper {
    long countByExample(AddressMangerCriteria example);

    int deleteByExample(AddressMangerCriteria example);

    int insert(AddressManger record);

    int insertSelective(AddressManger record);

    List<AddressManger> selectByExample(AddressMangerCriteria example);

    int updateByExampleSelective(@Param("record") AddressManger record, @Param("example") AddressMangerCriteria example);

    int updateByExample(@Param("record") AddressManger record, @Param("example") AddressMangerCriteria example);
}