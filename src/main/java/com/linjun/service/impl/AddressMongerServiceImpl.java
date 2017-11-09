package com.linjun.service.impl;

import com.linjun.common.domain.PeopleException;
import com.linjun.dao.AddressMangerMapper;
import com.linjun.model.AddressManger;
import com.linjun.model.AddressMangerCriteria;
import com.linjun.service.AddressMongerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressMongerServiceImpl implements AddressMongerService {
    @Autowired
    AddressMangerMapper addressMangerMapper;
    public AddressManger add(AddressManger addressManger) {
        int result=addressMangerMapper.insertSelective(addressManger);
        if (result>0){
            return addressManger;
        }else {
            throw  new PeopleException("添加失败");
        }
    }

    public int deleteByuserid(long userid) {
        AddressMangerCriteria addressMangerCriteria=new AddressMangerCriteria();
        AddressMangerCriteria.Criteria criteria=addressMangerCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        return addressMangerMapper.deleteByExample(addressMangerCriteria);
    }

    public List<AddressManger> findByuser(long userid) {
        AddressMangerCriteria addressMangerCriteria=new AddressMangerCriteria();
        AddressMangerCriteria.Criteria criteria=addressMangerCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);

        return addressMangerMapper.selectByExample(addressMangerCriteria);
    }

    public AddressManger findByIsDeafult(long userid, int label) {
        AddressMangerCriteria addressMangerCriteria=new AddressMangerCriteria();
        AddressMangerCriteria.Criteria criteria=addressMangerCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andIsdefaultEqualTo((byte) label);
        return (AddressManger) addressMangerMapper.selectByExample(addressMangerCriteria);
    }

    public int deleteByuan(long userid, String name) {
        AddressMangerCriteria addressMangerCriteria=new AddressMangerCriteria();
        AddressMangerCriteria.Criteria criteria=addressMangerCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andReceivepeopleEqualTo(name);
        return addressMangerMapper.deleteByExample(addressMangerCriteria);
    }

    @Override
    public AddressManger findbyid(long id) {
        return addressMangerMapper.selectByPrimaryKey(id);
    }

    @Override
    public AddressManger findByUserid(long userid) {
        AddressMangerCriteria addressMangerCriteria=new AddressMangerCriteria();
        AddressMangerCriteria.Criteria criteria=addressMangerCriteria.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andIsdefaultEqualTo((byte) 1);
        List<AddressManger> list=addressMangerMapper.selectByExample(addressMangerCriteria);
        if (list!=null&&list.size()==1){
            AddressManger addressManger=list.get(0);
            return addressManger;
        }else {
            throw new PeopleException("查询失败");
        }
    }

    @Override
    public int delelet(long userid, long id) {
        AddressMangerCriteria addressMangerCriteria=new AddressMangerCriteria();
        addressMangerCriteria.createCriteria().andUseridEqualTo(userid);
        addressMangerCriteria.createCriteria().andIdEqualTo(id);
        return addressMangerMapper.deleteByExample(addressMangerCriteria);
    }
}
