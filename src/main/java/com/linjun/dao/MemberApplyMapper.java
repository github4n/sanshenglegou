package com.linjun.dao;

import com.linjun.model.MemberApply;
import com.linjun.model.MemberApplyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberApplyMapper {
    long countByExample(MemberApplyCriteria example);

    int deleteByExample(MemberApplyCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberApply record);

    int insertSelective(MemberApply record);

    List<MemberApply> selectByExample(MemberApplyCriteria example);

    MemberApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberApply record, @Param("example") MemberApplyCriteria example);

    int updateByExample(@Param("record") MemberApply record, @Param("example") MemberApplyCriteria example);

    int updateByPrimaryKeySelective(MemberApply record);

    int updateByPrimaryKey(MemberApply record);
    List<MemberApply> dimfind(String temp);
    List<MemberApply> dimfindandstatus(String temp,byte status);
}