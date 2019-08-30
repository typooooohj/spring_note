package com.ustcinfo.dao.impl;

import com.ustcinfo.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("大家好，保存了账户");
    }
}
