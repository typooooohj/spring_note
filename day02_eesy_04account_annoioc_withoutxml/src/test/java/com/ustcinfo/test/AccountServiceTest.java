package com.ustcinfo.test;

import com.ustcinfo.domain.Account;
import com.ustcinfo.service.IAccountService;
import com.ustcinfo.service.impl.AccountServiceImpl;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试，测试我们的配置
 * Spring整合junit的配置
 *      1.导入Spring整合junit的jar
 *      2.使用Junit提供的注解把原有的main方法替换了，替换成spring提供的
 *         @Runwith
 *      3.告知spring的运行器，spring和ioc创建是基于xml还是注解，并说明位置
 *         @ContextConfiguration
 *             location:指定xml文件的位置，加上classpath关键字，表示在类路径下
 *             classes：指定注解类所在的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService as = null;
    @Test
    public void testFindAll(){
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
//        IAccountService as = ac.getBean("accountService", AccountServiceImpl.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        //1.获取容器
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
//        IAccountService as = ac.getBean("accountService", AccountServiceImpl.class);
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("test111 annotation");
        account.setMoney(11121f);
        //1.获取容器
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
//        IAccountService as = ac.getBean("accountService", AccountServiceImpl.class);
        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        //1.获取容器
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
//        IAccountService as = ac.getBean("accountService", AccountServiceImpl.class);

        Account account = as.findAccountById(4);
        account.setMoney(22222f);
//        account.setName();
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){
        //1.获取容器
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
//        IAccountService as = ac.getBean("accountService", AccountServiceImpl.class);
        as.deleteAccount(4);
        System.out.println(as.findAllAccount().toString());
    }
}
