package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.domain.PeopleException;
import com.linjun.config.QiNiuconfig;
import com.linjun.dao.StoreMapper;
import com.linjun.entity.PageBean;
import com.linjun.model.Store;
import com.linjun.model.StoreCriteria;
import com.linjun.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreMapper storeMapper;
    public boolean add(Store store) {
        return storeMapper.insertSelective(store)>0;
    }

    public int deletebyid(long id) {
        return storeMapper.deleteByPrimaryKey(id);
    }

    public int updatebyid(long id, Store store) {
        StoreCriteria storeCriteria=new StoreCriteria();
        StoreCriteria.Criteria criteria=storeCriteria.createCriteria();
        criteria.andIdEqualTo(id);
        return storeMapper.updateByExampleSelective(store,storeCriteria);
    }

    public List<Store> findAll() {
        StoreCriteria storeCriteria=new StoreCriteria();
        StoreCriteria.Criteria criteria=storeCriteria.createCriteria();
        return storeMapper.selectByExample(storeCriteria);
    }
    public Store findByid(long id) {
        return storeMapper.selectByPrimaryKey(id);
    }

    public int deleteByuserid(long userid) {
        StoreCriteria storeCriteria=new StoreCriteria();
        StoreCriteria.Criteria criteria=storeCriteria.createCriteria();
        criteria.andStoreuseridEqualTo(userid);

        return storeMapper.deleteByExample(storeCriteria);
    }

    public Store findBystoreid(long storeuserid) {
        StoreCriteria storeCriteria=new StoreCriteria();
        StoreCriteria.Criteria criteria=storeCriteria.createCriteria();
        criteria.andStoreuseridEqualTo(storeuserid);
        return (Store) storeMapper.selectByExample(storeCriteria);
    }

    @Override
    public Store createStore(Store store) {
        StoreCriteria storeCriteria=new StoreCriteria();
        storeCriteria.createCriteria().andTelEqualTo(store.getTel());
        List<Store> list=storeMapper.selectByExample(storeCriteria);
        if (list.size()>0){
            throw new PeopleException("该手机号码已被注册");
        }else {

            int result=storeMapper.insertSelective(store);
            if (result>0){
                return store;
            }else {
                throw new PeopleException("店铺注册失败");
            }
        }

    }

    @Override
    public Store loginByName(Store store) {
        StoreCriteria storeCriteria=new StoreCriteria();
        storeCriteria.createCriteria().andStorenameEqualTo(store.getStorename());
        storeCriteria.createCriteria().andPassworldEqualTo(store.getPassworld());
        List<Store> storeList=storeMapper.selectByExample(storeCriteria);
        if (storeList.size()==0){
            throw new PeopleException("店铺不存在");
        }else {
            return storeList.get(0);
        }

    }

    @Override
    public Store loginByid(Store store) {
        StoreCriteria storeCriteria=new StoreCriteria();
        storeCriteria.createCriteria().andIdEqualTo(store.getId());
        storeCriteria.createCriteria().andPassworldEqualTo(store.getPassworld());
        List<Store> storeList=storeMapper.selectByExample(storeCriteria);
        if (storeList.size()==0){
            throw new PeopleException("店铺不存在");
        }else {
            return storeList.get(0);
        }

    }

    @Override
    public Store loginByPhone(Store store) {
        StoreCriteria storeCriteria=new StoreCriteria();
        storeCriteria.createCriteria().andTelEqualTo(store.getTel());
        storeCriteria.createCriteria().andPassworldEqualTo(store.getPassworld());
          List<Store> storeList=storeMapper.selectByExample(storeCriteria);
          if (storeList!=null&&storeList.size()<2){
              return storeList.get(0);
          }else {
              throw  new PeopleException("店铺不存在");
          }
    }

    @Override
    public Store updateStore(Store store) {
        int result=storeMapper.updateByPrimaryKeySelective(store);
        if (result>0){
            return storeMapper.selectByPrimaryKey(store.getId());
        }

        return null;
    }

    @Override
    public PageBean<Store> findAllStore(int cuurrentPage, int pageSize) {
        PageHelper.startPage(cuurrentPage,pageSize);
        StoreCriteria storeCriteria=new StoreCriteria();
         List<Store> list=storeMapper.selectByExample(storeCriteria);
         long total=countStore();
         int pages,sise;
         if (total%cuurrentPage==0){
              pages= (int) (total/cuurrentPage);
         }else {
           pages= (int) (total/cuurrentPage)+1;
         }
          if (pages*pageSize==total){
             sise=cuurrentPage*pageSize;
          }else {
              if (cuurrentPage<pages){
                  sise=cuurrentPage*pageSize;
              }else {
                  sise= (int) total;
              }
          }
        PageBean<Store> lists=new PageBean<Store>(total,cuurrentPage,pageSize,pages,sise,list);
        return lists;
    }

    @Override
    public long countStore() {
            StoreCriteria storeCriteria=new StoreCriteria();
        return storeMapper.countByExample(storeCriteria);
    }
}
