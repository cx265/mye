1.db.sql是项目中用到的表，数据库使用的是oracle11g
2.该项目使用mvn进行管理，私服为自搭建nexus,项目只用到一个第三方 jar，就是oracle的驱动；
3.默认项目为零配置启动，如果需要更改启动方式，请作如下操作：
		<1.使用xml风格测试时，需要先将/src/main/java/web/config下的全部类移动到项目外，并开启web.xml中的相关配置>
		<2.使用Bean风格测试时，需要保证/src/main/java/web/config下的全部类都存在，并关闭web.xml中的相关配置>
4.项目特征如下：
1)项目基于SpringMVC4 
2)安全控制使用SpringSecurity3.2
3)Hibernate4 + 注解式事务管理
4)基于ASpect的注解式AOP
5)基于EHCache的注解式缓存
6)JSON及XML例子,@RestController及@Controller使用对比
7)单元测试基于MockMvc
8)配置了较完整的组件，贴近实际应用

5.运行环境：tomcat8.0.9 jdk1.7 

这里对SpringMVC零配置做一个简单的说明

spring4中提供了大量的注解来支持零配置，简要说明如下：
@Configuration ： 类似于spring配置文件，负责注册bean，对应的提供了@Bean注解。需要org.springframework.web.context.support.AnnotationConfigWebApplicationContext注册到容器中。
@ComponentScan ： 注解类查找规则定义 <context:component-scan/>
@EnableAspectJAutoProxy ： 激活Aspect自动代理 <aop:aspectj-autoproxy/>
@Import @ImportResource: 关联其它spring配置  <import resource="" />
@EnableCaching ：启用缓存注解  <cache:annotation-driven/>
@EnableTransactionManagement ： 启用注解式事务管理 <tx:annotation-driven />
@EnableWebMvcSecurity ： 启用springSecurity安全验证


Servlet3.0规范，支持将web.xml相关配置也硬编码到代码中[servlet，filter，listener,等等]，并由javax.servlet.ServletContainerInitializer的实现类负责在容器启动时进行加载，
spring提供了一个实现类org.springframework.web.SpringServletContainerInitializer,
该类会调用所有org.springframework.web.WebApplicationInitializer的实现类的onStartup(ServletContext servletContext)方法，将相关的组件注册到服务器；

spring同时提供了一些WebApplicationInitializer的实现类供我们继承，以简化相关的配置，比如：
org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer ： 注册spring DispathServlet
org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer ： 注册springSecurity

同时，spring也提供了一些@Configuration的支持类供我们继承，以简化相关@Configuration的配置，比如：
org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport ： 封装了springmvc相关组件，我们可以通过注册新的@Bean和@Override相关方法，以实现对各个组件的注册；
org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter ： 封装类springsecurity相关组件