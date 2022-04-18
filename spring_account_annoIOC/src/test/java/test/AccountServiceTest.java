package test;

import com.spring.domain.Account;
import com.spring.service.IAccountService;
import com.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    IAccountService as=null;

    @Test
    public void testfindAll(){
        //1. 获取容器
//        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);//(被注解过的类)
//        //2. 得到业务层对象
//        IAccountService as=ac.getBean("accountService",IAccountService.class);
        //3. 执行方法
        List<Account> accounts=as.findAllAccount();
        for (Account account:accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testfindOne(){
        //1. 获取容器
//        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        //2. 得到业务层对象
//        IAccountService as=ac.getBean("accountService",IAccountService.class);
        //3. 执行方法
        Account account=as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        //1. 获取容器
//        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        //2. 得到业务层对象
//        IAccountService as=ac.getBean("accountService",IAccountService.class);
        //3. 执行方法
        Account account=new Account();
        account.setName("xxx");
        account.setMoney(999.0f);//浮点型数据记得加f/F
        as.saveAccount(account);
        System.out.println("已保存一条账户信息");
    }

    @Test
    public void testUpdate(){
        //1. 获取容器
//        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        //2. 得到业务层对象
//        IAccountService as=ac.getBean("accountService",IAccountService.class);
        //3. 执行方法
        Account account=as.findAccountById(5);
        account.setMoney(777.0f);
        as.updateAccount(account);
        System.out.println("已更新一条账户信息");
    }

    @Test
    public void testdeleteOne(){
        //1. 获取容器
//        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        //2. 得到业务层对象
//        IAccountService as=ac.getBean("accountService",IAccountService.class);
        //3. 执行方法
        as.deleteAccountById(4);
        System.out.println("已删除一条账户信息");
    }

}
