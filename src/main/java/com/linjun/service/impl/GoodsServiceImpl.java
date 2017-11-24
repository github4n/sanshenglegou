package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.domain.PeopleException;
import com.linjun.dao.GoodsMapper;
import com.linjun.entity.PageBean;
import com.linjun.model.Goods;
import com.linjun.model.GoodsCriteria;
import com.linjun.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;


    public boolean delete(long id) {
        int result=goodsMapper.deleteByPrimaryKey(id);
        if (result>0){
            return true;
        }else {
            return false;
        }

    }



    public Goods findByid(long ID) {

        return goodsMapper.selectByPrimaryKey(ID);
    }

    @Override
    public Goods addGoods(Goods goods) {
        long result=goodsMapper.insertSelective(goods);
        if (result>0){
            return  goodsMapper.selectByPrimaryKey(result);
        }else {
            throw new PeopleException("添加商品失败");
        }
    }


    @Override
    public PageBean<Goods> findByID(long id,int cuurrentPage, int pagesize) {
        PageHelper.startPage(cuurrentPage,pagesize);
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        goodsCriteria.createCriteria().andIsstartEqualTo((byte)1);
        goodsCriteria.createCriteria().andTypeidEqualTo(id);
        List<Goods> list=goodsMapper.selectByExample(goodsCriteria);
          long total=countInType(id);
        int pages,sise;
        if (total%cuurrentPage==0){
            pages= (int) (total/cuurrentPage);
        }else {
            pages= (int) (total/cuurrentPage)+1;
        }
        if (pages*pagesize==total){
            sise=cuurrentPage*pagesize;
        }else {
            if (cuurrentPage<pages){
                sise=cuurrentPage*pagesize;
            }else {
                sise= (int) total;
            }
        }
        PageBean<Goods> goodslist=new PageBean<Goods>(total,cuurrentPage,pagesize,pages,sise,list);

        return goodslist;
    }

    @Override
    public long countGoods() {
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        return goodsMapper.countByExample(goodsCriteria);
    }

    @Override
    public long countInStore(long storeId) {
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        goodsCriteria.createCriteria().andStoreidEqualTo(storeId);
        return goodsMapper.countByExample(goodsCriteria);
    }

    @Override
    public long countInType(long typeID) {
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        GoodsCriteria.Criteria criteria=goodsCriteria.createCriteria();
        criteria.andTypeidEqualTo(typeID);
        criteria.andIsstartEqualTo((byte) 1);
        return goodsMapper.countByExample(goodsCriteria);
    }

    @Override
    public PageBean<Goods> findBySID(long storeId, int cuurrentPage, int pagesize) {

           PageHelper.startPage(cuurrentPage,pagesize);
           GoodsCriteria goodsCriteria=new GoodsCriteria();
           goodsCriteria.createCriteria().andStoreidEqualTo(storeId);
           List<Goods> list=goodsMapper.selectByExample(goodsCriteria);
           long total=countInStore(storeId);
           int pages,sise;
           if (total%cuurrentPage==0){
               pages= (int) (total/cuurrentPage);
           }else {
               pages= (int) (total/cuurrentPage)+1;
           }
           if (pages*pagesize==total){
               sise=cuurrentPage*pagesize;
           }else {
               if (cuurrentPage<pages){
                   sise=cuurrentPage*pagesize;
               }else {
                   sise= (int) total;
               }
           }
           PageBean<Goods> lists=new PageBean<Goods>(total,cuurrentPage,pagesize,pages,sise,list);
           return lists;

    }

    @Override
    public PageBean<Goods> goodsAll(int cuurrentPage, int pagessize) {
        PageHelper.startPage(cuurrentPage,pagessize);
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        List<Goods> list=goodsMapper.selectByExample(goodsCriteria);
        if (list!=null&&list.size()>0){
            long total=countGoods();
            int pages,sise;
            if (total%cuurrentPage==0){
                pages= (int) (total/cuurrentPage);
            }else {
                pages= (int) (total/cuurrentPage)+1;
            }
            if (pages*pagessize==total){
                sise=cuurrentPage*pagessize;
            }else {
                if (cuurrentPage<pages){
                    sise=cuurrentPage*pagessize;
                }else {
                    sise= (int) total;
                }
            }
            PageBean<Goods> goodslist=new PageBean<Goods>(total,cuurrentPage,pagessize,pages,sise,list);
            return goodslist;
        }else {
            throw new PeopleException("获取数据失败");
        }

    }

    @Override
    public Goods updateGoods(Goods goods) {
        int result= goodsMapper.updateByPrimaryKeySelective(goods);
        if (result>0){
            return goodsMapper.selectByPrimaryKey(goods.getId());
        }else {
            throw new PeopleException("更新失败");
        }
    }

    @Override
    public PageBean<Goods> findBy(byte status, int cuurrentPage, int pagessize) {

        PageHelper.startPage(cuurrentPage,pagessize);
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        GoodsCriteria.Criteria criteria=goodsCriteria.createCriteria();
        criteria.andIsstartEqualTo(status);
        List<Goods> list=goodsMapper.selectByExample(goodsCriteria);
        if (list!=null&&list.size()>0){
            long total=countGoods();
            int pages,sise;
            if (total%cuurrentPage==0){
                pages= (int) (total/cuurrentPage);
            }else {
                pages= (int) (total/cuurrentPage)+1;
            }
            if (pages*pagessize==total){
                sise=cuurrentPage*pagessize;
            }else {
                if (cuurrentPage<pages){
                    sise=cuurrentPage*pagessize;
                }else {
                    sise= (int) total;
                }
            }
            PageBean<Goods> goodslist=new PageBean<Goods>(total,cuurrentPage,pagessize,pages,sise,list);
            return goodslist;
        }else {
            throw new PeopleException("获取数据失败");
        }

    }

    @Override
    public PageBean<Goods> search(Object condition, int cuurrentPage, int pagessize) {
        PageHelper.startPage(cuurrentPage,pagessize);
        List<Goods> list=new ArrayList<Goods>();
        if (condition instanceof  String){
            list=goodsMapper.dimfindStr('%'+(String)condition+'%');
        }else  if (condition instanceof  Long){
            GoodsCriteria goodsCriteria=new GoodsCriteria();
            GoodsCriteria.Criteria criteria=goodsCriteria.createCriteria();
            criteria.andIdEqualTo('%'+(Long)condition+'%');
            list=goodsMapper.selectByExample(goodsCriteria);
        }
        if (list!=null&&list.size()>0){
            long total=countGoods();
            int pages,sise;
            if (total%cuurrentPage==0){
                pages= (int) (total/cuurrentPage);
            }else {
                pages= (int) (total/cuurrentPage)+1;
            }
            if (pages*pagessize==total){
                sise=cuurrentPage*pagessize;
            }else {
                if (cuurrentPage<pages){
                    sise=cuurrentPage*pagessize;
                }else {
                    sise= (int) total;
                }
            }
            PageBean<Goods> goodslist=new PageBean<Goods>(total,cuurrentPage,pagessize,pages,sise,list);
            return goodslist;
        }else {
            throw new PeopleException("获取数据失败");
        }
    }

    @Override
    public PageBean<Goods> searchByStatus(Object condition, byte status, int cuurrentPage, int pagessize) {
        PageHelper.startPage(cuurrentPage,pagessize);
        List<Goods> list=new ArrayList<Goods>();
        if (condition instanceof  String){
            list=goodsMapper.dimfindStrStatus('%'+(String)condition+'%',status);
        }else  if (condition instanceof  Long){
            list=goodsMapper.dimfindStatus('%'+(Long)condition+'%',status);
        }
        if (list!=null&&list.size()>0){
            long total=countGoods();
            int pages,sise;
            if (total%cuurrentPage==0){
                pages= (int) (total/cuurrentPage);
            }else {
                pages= (int) (total/cuurrentPage)+1;
            }
            if (pages*pagessize==total){
                sise=cuurrentPage*pagessize;
            }else {
                if (cuurrentPage<pages){
                    sise=cuurrentPage*pagessize;
                }else {
                    sise= (int) total;
                }
            }
            PageBean<Goods> goodslist=new PageBean<Goods>(total,cuurrentPage,pagessize,pages,sise,list);
            return goodslist;
        }else {
            throw new PeopleException("获取数据失败");
        }
    }


}
