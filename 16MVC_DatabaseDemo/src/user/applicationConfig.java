package user;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@Configuration
public class applicationConfig {

	 @Bean
	   public DataSource dataSource() {
	      BasicDataSource dataSource = new BasicDataSource();
	      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	      dataSource.setUrl("jdbc:mysql://localhost/springdemo");
	      dataSource.setUsername("root");
	      dataSource.setPassword("");
	      return dataSource;
	   }
	 
	 @Bean
	   public LocalSessionFactoryBean sessionFactory() {
	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	      sessionFactory.setDataSource(dataSource());
	      sessionFactory.setPackagesToScan(new String[] { "user" });

	      Properties properties = new Properties();
	      properties.put("hibernate.show_sql", "true");
	      properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
	      properties.put("hibernate.hbm2ddl.auto", "create");
	      
	      sessionFactory.setHibernateProperties(properties);

	      return sessionFactory;
	   }
	 
	 @Autowired
	 @Bean(name = "transactionManager")
	 public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	     HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	     return transactionManager;
	 }
	
}
