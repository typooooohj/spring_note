package com.ustcinfo.service;

import com.ustcinfo.domain.Account;

import java.util.List;

/*
 * 账户的业务层接口
 */
public interface IAccountService {
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
}
