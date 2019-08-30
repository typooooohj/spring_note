package com.ustcinfo;

import com.ustcinfo.dao.IUserDao;
import com.ustcinfo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

public class MybatisTest {
    public static void main(String[] args) throws Exception {
        //1读取配置
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2创建sqlSession 工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //使用工厂创建sqlsession
        SqlSession session = factory.openSession();
        //使用SqlSession创建Dao接口的代理对象（代理模式增强）
        IUserDao userDao = session.getMapper(IUserDao.class);
        //使用代理对象执行方法
        List<User> list = userDao.findAll();
        for (User user: list)
        {
            System.out.println(user);

        }
        //释放资源
        session.close();
        in.close();
    }
}
