package com.linjun.dao;

import com.linjun.model.WithDrawApply;
import com.linjun.model.WithDrawApplyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WithDrawApplyMapper {
    long countByExample(WithDrawApplyCriteria example);

    int deleteByExample(WithDrawApplyCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(WithDrawApply record);

    int insertSelective(WithDrawApply record);

    List<WithDrawApply> selectByExample(WithDrawApplyCriteria example);

    WithDrawApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WithDrawApply record, @Param("example") WithDrawApplyCriteria example);

    int updateByExample(@Param("record") WithDrawApply record, @Param("example") WithDrawApplyCriteria example);

    int updateByPrimaryKeySelective(WithDrawApply record);

    int updateByPrimaryKey(WithDrawApply record);
    List<WithDrawApply> dimfind(String temp);
    List<WithDrawApply> dimfindandstatus(String temp,byte status);
}