package com.ustcinfo.service.impl;

import com.ustcinfo.dao.IAccountDao;
import com.ustcinfo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Autowired:作用：自动按照类型注入。只要容器中有唯一一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *        如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错。
 *        如果Ioc容器中有多个类型匹配时：
 *        出现位置：可以在变量上，也可以在方法上
 *        细节：使用注解时，set方法就不是必须的了。
 *  Qualifier:
 *        作用：在按照类中注入的基础上再按照名称注入。它在给类成员注入时不能单独使用。但是在给方法参数注入时可以
 *        属性：
 *            value：用于指定bean的id
 *  Resource
 *        作用：直接按照bean的id注入，它可以独立使用
 *        属性：
 *            name：用于指定bean的id。
 *   以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用以上注解实现
 *   另外，集合类型的注入只能通过xml来实现。
 *
 *    Value
 *        作用：用于注入基本类型和String类型的数据
 *        属性：
 *           value：用于指定数据的值。它可以使用spring中的Spring的EL表达式
 *                  SpEL的写法：${表达式}
 *
 *   用于改变作用范围的
 *       他们的作用就和bean标签中使用Scope属性实现的功能是一样的
 *       Scope
 *            作用：用于指定bean的作用范围
 *            属性：
 *                value：指定范围的取值。常用取值：singleton prototype
 *  和生命周期相关 了解
 *       他们的作用和在bean标签中使用init-method和destroy-method的作用是一样的
 *       PreDestroy
 *           作用：用于指定销毁方法
 *       PostConstruct
 *           作用：用于指定bean创建后初始化方法
 *
 */

@Service
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao2")
    @Resource(name = "accountDao2")
    private IAccountDao accountDao2;

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行了");
    }
    @PreDestroy
    public void destroy(){
        System.err.println("销毁方法执行了");
    }

    @Override
    public void saveAccount() {
        accountDao2.saveAccount();
    }
}
