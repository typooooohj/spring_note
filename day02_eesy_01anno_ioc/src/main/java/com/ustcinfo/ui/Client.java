package com.ustcinfo.ui;

import com.ustcinfo.service.IAccountService;
import com.ustcinfo.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("bean.xml");
        AccountServiceImpl accountService = (AccountServiceImpl) act.getBean("accountServiceImpl");
        accountService.saveAccount();
//        IAccountService as2 = (IAccountService)act.getBean("accountServiceImpl");
//        System.out.println(accountService==as2);
        act.close();
    }



}
