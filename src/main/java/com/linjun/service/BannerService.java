package com.linjun.service;

import com.linjun.entity.PageBean;
import com.linjun.model.Banner;

import java.util.List;

public interface BannerService {
    Banner adds(Banner banner);
    Banner update(Banner banner);
    PageBean<Banner> findAll(int currentpage,int pagesize);
 Long countbanner();
  int deletebanner(long id);
  Banner add(Banner banner);
  List<Banner> getbanner(byte type);
}
