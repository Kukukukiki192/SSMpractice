package test;

import com.dao.IRoleDao;
import com.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author K
 * Junit测试
 */
public class RoleTest {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IRoleDao roleDao;

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
        roleDao = session.getMapper(IRoleDao.class);
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
        List<Role> roles = roleDao.findAll();
        for(Role role : roles){
            System.out.println("-----每个role的信息------");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }




}
