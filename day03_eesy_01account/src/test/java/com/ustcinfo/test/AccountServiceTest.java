package com.ustcinfo.test;

import com.ustcinfo.domain.Account;
import com.ustcinfo.service.IAccountService;
import com.ustcinfo.service.impl.AccountServiceImpl;
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
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private IAccountService as = null;

    @Test
    public void testTransfer(){
        as.transfer("aaa","bbb",100f);
    }

}
