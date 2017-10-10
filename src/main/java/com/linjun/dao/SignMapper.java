package com.linjun.dao;

import com.linjun.model.Sign;
import com.linjun.model.SignCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SignMapper {
    long countByExample(SignCriteria example);

    int deleteByExample(SignCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Sign record);

    int insertSelective(Sign record);

    List<Sign> selectByExample(SignCriteria example);

    Sign selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sign record, @Param("example") SignCriteria example);

    int updateByExample(@Param("record") Sign record, @Param("example") SignCriteria example);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);
}