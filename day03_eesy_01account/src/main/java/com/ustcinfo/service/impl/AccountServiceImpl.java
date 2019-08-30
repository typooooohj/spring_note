package com.ustcinfo.service.impl;

import com.ustcinfo.dao.IAccountDao;
import com.ustcinfo.dao.impl.AccountDaoImpl;
import com.ustcinfo.domain.Account;
import com.ustcinfo.service.IAccountService;
import com.ustcinfo.util.TransactionManager;

import java.util.List;

/**
 * 事务的控制应该在service层，而不是Dao层
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    private TransactionManager txManager;
    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }
    @Override
    public List<Account> findAllAccount() {
       try {
           //1.开启事务
           txManager.beginTransaction();
           //2.执行操作
           List<Account> accounts = accountDao.findAllAccount();
           //3.提交事务
           txManager.commit();
           //4.返回结果
           return accounts;
       }catch (Exception e){
           //5.回滚操作
           txManager.rollback();
           throw new RuntimeException(e);
       }finally {
           //6.释放连接
           txManager.release();
       }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            Account account = accountDao.findAccountById(accountId);
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return account;
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            txManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            txManager.commit();
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
        }finally {
            //6.释放连接
            txManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            txManager.commit();
            //4.返回结果
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
        }finally {
            //6.释放连接
            txManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
        //1.开启事务
        txManager.beginTransaction();
        //2.执行操作
        accountDao.deleteAccount(accountId);
        //3.提交事务
        txManager.commit();
        //4.返回结果
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
        }finally {
            //6.释放连接
            txManager.release();
        }
    }

    public void setAccountDao(IAccountDao accountDao) {

        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money){
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
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
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
            e.printStackTrace();
        }finally {
            //6.释放连接
            txManager.release();
        }
    }

}
