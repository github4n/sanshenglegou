package com.linjun.dao;

import com.linjun.model.Banner;
import com.linjun.model.BannerCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BannerMapper {
    long countByExample(BannerCriteria example);

    int deleteByExample(BannerCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Banner record);

    int insertSelective(Banner record);

    List<Banner> selectByExample(BannerCriteria example);

    Banner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerCriteria example);

    int updateByExample(@Param("record") Banner record, @Param("example") BannerCriteria example);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
}