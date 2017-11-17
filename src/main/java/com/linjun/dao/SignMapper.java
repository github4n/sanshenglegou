package com.linjun.dao;

import com.linjun.model.Sign;
import com.linjun.model.SignCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SignMapper {
    long countByExample(SignCriteria example);

    int deleteByExample(SignCriteria example);

    int insert(Sign record);

    int insertSelective(Sign record);

    List<Sign> selectByExample(SignCriteria example);

    int updateByExampleSelective(@Param("record") Sign record, @Param("example") SignCriteria example);

    int updateByExample(@Param("record") Sign record, @Param("example") SignCriteria example);
}