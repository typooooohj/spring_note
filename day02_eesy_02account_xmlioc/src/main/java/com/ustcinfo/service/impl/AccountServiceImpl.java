package com.ustcinfo.service.impl;

import com.ustcinfo.dao.IAccountDao;
import com.ustcinfo.dao.impl.AccountDaoImpl;
import com.ustcinfo.domain.Account;
import com.ustcinfo.service.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public IAccountDao getAccountDao() {
        return accountDao;
    }
}
