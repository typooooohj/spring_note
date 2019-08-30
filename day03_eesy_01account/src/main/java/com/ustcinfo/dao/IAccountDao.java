package com.ustcinfo.dao;

import com.ustcinfo.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    /**
     * 根绝名称查询账户
     * @param accountName
     * @return 如果有唯一一个结果就返回，如果没有结果就返回Null
     *         如果结果集中的结果超过一个，就抛异常。
     */
    Account findAccountByName(String accountName);
}
