package com.config;

import org.springframework.context.annotation.*;
/**
 * 该类是一个配置类，它的作用和bean.xml是一样的
 * spring中的新注解
 * Configuration
 *     作用：指定当前类是一个配置类
 *     细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写。
 * ComponentScan
 *      作用：用于通过注解指定spring在创建容器时要扫描的包
 *      属性：
 *          value：它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包。
 *                 我们使用此注解就等同于在xml中配置了:
 *                      <context:component-scan base-package="com.itheima"></context:component-scan>
 *  Bean
 *      作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
 *      属性:
 *          name:用于指定bean的id。当不写时，默认值是当前方法的名称
 *      细节：
 *          当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
 *          查找的方式和Autowired注解的作用是一样的
 *  Import
 *      作用：用于导入其他的配置类
 *      属性：
 *          value：用于指定其他配置类的字节码。
 *                  当我们使用Import的注解之后，有Import注解的类就父配置类，而导入的都是子配置类
 *  PropertySource
 *      作用：用于指定properties文件的位置
 *      属性：
 *          value：指定文件的名称和路径。
 *                  关键字：classpath，表示类路径下
 */

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

@Configuration
@ComponentScan("com.spring")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
