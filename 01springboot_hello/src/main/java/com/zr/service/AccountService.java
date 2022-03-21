package com.zr.service;

import com.zr.dao.AccountDao;
import com.zr.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // 业务层要加事务
public class AccountService {

    @Autowired
    private AccountDao accountDao;


    public int insertAccount(Account account){
        return accountDao.insert(account);
    }
}
