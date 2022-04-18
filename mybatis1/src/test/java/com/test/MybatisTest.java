package com.test;

import com.dao.IUserDao;
import com.domain.QueryVo;
import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author K
 * Junit测试
 */
public class MybatisTest {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        InputStream in= javax.annotation.Resources.class.getResourceAsStream("/SqlMapConfig.xml");//在getResourceAsStream()前添加.class解决标红问题 在声明输入流InputStream时后面的地址要加/,这样系统才能找到该文件
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception{
        //提交事务
        session.commit();
        //6.释放资源
        session.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindById(){
        //5.使用代理对象执行方法
        User user = userDao.findById(47);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        //5.使用代理对象执行方法
        List<User> users = userDao.findByName("%王%");
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindByVo(){
        QueryVo vo=new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        vo.setUser(user);
        //5.使用代理对象执行方法
        List<User> users = userDao.findByVo(vo);
        for(User u : users){
            System.out.println(user);
        }
    }

    @Test
    public void testSave(){
        User user=new User();
        user.setUsername("xxx");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("杭州留下");

        System.out.println("保存前："+user);

        //5.使用代理对象执行保存方法
        userDao.saveUser(user);

        System.out.println("保存后："+user);
    }

    @Test
    public void testUpdate(){
        User user=new User();
        user.setId(51);
        user.setUsername("sss");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("杭州留下");

        //5.使用代理对象执行保存方法
        userDao.updateUser(user);

        System.out.println(user);
    }

    @Test
    public void testDelete(){
        //5.使用代理对象执行保存方法
        userDao.deleteUser(51);
        System.out.println("delete...");
    }

    @Test
    public void testFindTotal(){
        //5.使用代理对象执行保存方法
        int n=userDao.findTotal();
        System.out.println("总用户记录有"+n+"条");
    }
}
