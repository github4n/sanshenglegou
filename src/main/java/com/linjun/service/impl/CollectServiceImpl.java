package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.CollectMapper;
import com.linjun.model.Collect;
import com.linjun.model.CollectCriteria;
import com.linjun.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin.javascript.JSClassLoader;

import java.util.List;
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;

    public Collect add(Collect collect) {
        long result= collectMapper.insertSelective(collect);
        if (result>0){
            return  collectMapper.selectByPrimaryKey(result);
        }else {
            throw new PeopleException("添加失败");
        }
    }

    public int deleteByUserid(long id) {
        int result=collectMapper.deleteByPrimaryKey(id);
        if (result>0){
            return result;
        }else {
            throw new PeopleException("删除失败");
        }

    }

    public List<Collect> findByuserid(long userid) {
        CollectCriteria collectCriteria=new CollectCriteria();
        CollectCriteria.Criteria criteria=collectCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<Collect> list= collectMapper.selectByExample(collectCriteria);
        if (list!=null&&list.size()>0){
            return list;
        }else {
           throw new PeopleException("获取数据失败");
        }
    }
}
