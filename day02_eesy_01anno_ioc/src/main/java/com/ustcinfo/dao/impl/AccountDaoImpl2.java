package com.ustcinfo.dao.impl;

import com.ustcinfo.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("大家好，保存了账户11111111111111");
    }
}
