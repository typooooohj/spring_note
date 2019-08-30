package com.ustcinfo.service.impl;

import com.ustcinfo.dao.IAccountDao;
import com.ustcinfo.domain.Account;
import com.ustcinfo.service.IAccountService;
import com.ustcinfo.util.TransactionManager;

import java.util.List;

/**
 * 事务的控制应该在service层，而不是Dao层
 */
public class AccountServiceImpl_OLD implements IAccountService {

    private IAccountDao accountDao;

    private TransactionManager txManager;
    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }
    @Override
    public List<Account> findAllAccount() {
       List<Account> accounts = accountDao.findAllAccount();
       return accounts;
    }

    @Override
    public Account findAccountById(Integer accountId) {

            Account account = accountDao.findAccountById(accountId);
            //4.返回结果
            return account;
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

    @Override
    public void transfer(String sourceName, String targetName, Float money){
            //根据名称查询转入转出账户
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            //转出账户减钱
            source.setMoney(source.getMoney()-money);
            //转入账户加钱
            target.setMoney(target.getMoney()+money);
            //更新转入转出账户
            accountDao.updateAccount(source);
            int  i = 1/0;
            accountDao.updateAccount(target);
            //3.提交事务
            txManager.commit();
            //4.返回结果
    }

}
