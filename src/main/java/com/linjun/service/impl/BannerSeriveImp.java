package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.JsonResult;
import com.linjun.common.domain.PeopleException;
import com.linjun.dao.BannerMapper;
import com.linjun.entity.PageBean;
import com.linjun.model.Banner;
import com.linjun.model.BannerCriteria;
import com.linjun.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerSeriveImp implements BannerService {
    @Autowired
    BannerMapper bannerMapper;
    @Override
    public Banner adds(Banner banner) {
        long result= bannerMapper.insertSelective(banner);
        if (result>0){
            return  bannerMapper.selectByPrimaryKey(result);
        }else {
         throw new PeopleException("添加失败");
        }
    }

    @Override
    public Banner update(Banner banner) {
        int result=bannerMapper.updateByPrimaryKeySelective(banner);
        if (result>0){
            return bannerMapper.selectByPrimaryKey(banner.getId());
        }else {
            throw  new PeopleException("更新失败");
        }
    }

    @Override
    public PageBean<Banner> findAll(int currentpage,int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        PageHelper.startPage(currentpage,pagesize);
        BannerCriteria bannerCriteria=new BannerCriteria();
        List<Banner> list=bannerMapper.selectByExample(bannerCriteria);
        long total=countbanner();
        int pages,sise;
        if (total%currentpage==0){
            pages = (int) (total/currentpage);
        }else {
            pages= (int) (total/currentpage)+1;
        }
        if (pages*pagesize==total){
            sise=currentpage*pagesize;
        }else {
            if (currentpage<pages){
                sise=currentpage*pagesize;
            }else {
                sise= (int) total;
            }
        }
        PageBean<Banner> lists=new PageBean<Banner>(total,currentpage,pagesize,pages,sise,list);
        return lists;
    }

    @Override
    public Long countbanner() {
        BannerCriteria bannerCriteria=new BannerCriteria();

        return bannerMapper.countByExample(bannerCriteria);
    }

    @Override
    public int deletebanner(long id) {
        int result=bannerMapper.deleteByPrimaryKey(id);
        if (result>0){
            return  result;
        }else {
            throw new PeopleException("删除失败");
        }

    }

    @Override
    public Banner add(Banner banner) {
        int result=bannerMapper.insertSelective(banner);
        if (result>0){
            return bannerMapper.selectByPrimaryKey(banner.getId());
        }else {
            throw new PeopleException("添加失败");
        }
    }

    @Override
    public List<Banner> getbanner(byte type) {
        BannerCriteria bannerCriteria=new BannerCriteria();
        BannerCriteria.Criteria criteria=bannerCriteria.createCriteria();
        criteria.andTypeEqualTo(type);
        List<Banner> list=bannerMapper.selectByExample(bannerCriteria);
        if (list!=null&&list.size()>0){
            return list;
        }else {
            throw   new PeopleException("获取失败");
        }
    }
}
