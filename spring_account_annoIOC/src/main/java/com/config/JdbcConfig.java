package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
/**
 *     <context:component-scan base-package="com.spring"></context:component-scan> ->@ComponentScan("com.spring") (相当于base-package)
 *
 *     以下类是jar包里的类不能改(不能添加注解)，所以需要一个配置类 ->@Configuration
 *     <!-- 配置QueryRunner -->
 *     <bean id="runner" class="org.apache.commons.dbutils.QueryRunner" scope="prototype"> ->@Bean(name="runner") id相当于name
 *         <!-- 注入数据源 -->                                                 注意这里是多例的
 *         <constructor-arg name="ds" ref="dataSource"></constructor-arg>
 *     </bean>
 *
 *     <!-- 配置数据源 -->
 *     <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"> ->@Bean(name="dataSource")
 *         <!-- 连接数据集的必备信息 -->
 *         <property name="driverClass" value="com.mysql.jdbc.Driver"></property>
 *         <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/test"></property>
 *         <property name="user" value="root"></property>
 *         <property name="password" value="1111"></property>
 *     </bean>
 */

/**
 * 和spring连接数据库相关的配置类
 */
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 创建QueryRunner对象
     * @param dataSource
     * @return
     */
    @Bean(name="runner")
    @Scope("prototype")                  // @Qualifier的独立使用
    public QueryRunner createQueryRunner(@Qualifier("dataSource1") DataSource dataSource){//此时是单例的 创建QueryRunnerTest测试 加上@Scope("prototype")就是多例的
        return new QueryRunner(dataSource);
    }

    /**
     * 创建DataSource数据源对象
     * @return
     */
    @Bean(name="dataSource1")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword(password);
            return ds;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Bean(name="dataSource2")
    public DataSource createDataSource2(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);//url换一个
            ds.setUser(user);
            ds.setPassword(password);
            return ds;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
