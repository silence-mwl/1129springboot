package com.zr.dao;

import com.zr.entity.Account;
import org.apache.ibatis.annotations.Mapper;

//@Mapper // 1.在每个接口上添加一个注解
public interface AccountDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}