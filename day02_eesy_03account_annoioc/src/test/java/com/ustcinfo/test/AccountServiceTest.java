package com.ustcinfo.test;

import com.ustcinfo.domain.Account;
import com.ustcinfo.service.IAccountService;
import com.ustcinfo.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {
    @Test
    public void testFindAll(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", AccountServiceImpl.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", AccountServiceImpl.class);
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("test111");
        account.setMoney(11121f);
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", AccountServiceImpl.class);
        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", AccountServiceImpl.class);

        Account account = as.findAccountById(4);
        account.setMoney(22222f);
//        account.setName();
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", AccountServiceImpl.class);
        as.deleteAccount(4);
        System.out.println(as.findAllAccount().toString());
    }
}
