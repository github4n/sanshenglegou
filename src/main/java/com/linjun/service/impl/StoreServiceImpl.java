package com.linjun.service.impl;

import com.github.pagehelper.PageHelper;
import com.linjun.common.domain.PeopleException;
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
    public Store add(Store store) {
        long result=storeMapper.insertSelective(store);
        if (result>0){
            return storeMapper.selectByPrimaryKey(result);
        }else {
            throw  new PeopleException("添加失败");
        }


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
                return storeMapper.selectByPrimaryKey((long) result);
            }else {
                throw new PeopleException("店铺注册失败");
            }
        }

    }

    @Override
    public Store loginByName(Store store) {
        StoreCriteria storeCriteria=new StoreCriteria();
        StoreCriteria.Criteria criteria=storeCriteria.createCriteria();
        criteria.andStorenameEqualTo(store.getStorename());
        criteria.andPassworldEqualTo(store.getPassworld());
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
        StoreCriteria.Criteria criteria=storeCriteria.createCriteria();
        criteria.andTelEqualTo(store.getTel());
        criteria.andPassworldEqualTo(store.getPassworld());
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

    @Override
    public PageBean<Store> findStart(int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        StoreCriteria storeCriteria=new StoreCriteria();
        StoreCriteria.Criteria criteria=storeCriteria.createCriteria();
        criteria.andIsauthEqualTo((byte) 1);
        List<Store> list=storeMapper.selectByExample(storeCriteria);
        long total=countStore();
        int pages,sise;
        if (total%currentpage==0){
            pages= (int) (total/currentpage);
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
        PageBean<Store> lists=new PageBean<Store>(total,currentpage,pagesize,pages,sise,list);
        return lists;

    }

    @Override
    public PageBean<Store> findShop(int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        StoreCriteria storeCriteria=new StoreCriteria();
        StoreCriteria.Criteria criteria=storeCriteria.createCriteria();
        criteria.andIsauthEqualTo((byte) 0);
        List<Store> list=storeMapper.selectByExample(storeCriteria);
        long total=countStore();
        int pages,sise;
        if (total%currentpage==0){
            pages= (int) (total/currentpage);
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
        PageBean<Store> lists=new PageBean<Store>(total,currentpage,pagesize,pages,sise,list);
        return lists;

    }

    @Override
    public int changeList(List<Store> stores) {
        int temp=0;
        for (int i = 0; i <stores.size() ; i++) {
            int result=storeMapper.updateByPrimaryKeySelective(stores.get(i));
            if (result>0){
                temp+=1;
            }else {

            }
        }
        if (temp==stores.size()){
            return  temp;
        }else {
            throw new PeopleException("批量修改失败");
        }
    }

    @Override
    public int deleleList(List<Store> stores) {
        int temp=0;
        for (int i = 0; i < stores.size(); i++) {
          int result=storeMapper.deleteByPrimaryKey(stores.get(i).getId());
          if (result>0){
              temp+=1;
          }else {

          }
        }
if (temp==stores.size()){
            return  stores.size();
}else {
    throw  new PeopleException("批量删除失败");
}

    }

}
