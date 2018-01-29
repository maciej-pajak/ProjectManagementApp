package pl.maciejpajak.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.maciejpajak.repository")
@EnableSpringDataWebSupport
@PropertySource(value = { "classpath:application.properties" })
public class PersistenceConfig {

    @Autowired
    private Environment env;
    
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
 
        return dataSource;
    }
    
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, 
                                                                Environment env) {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSource);
        lcemfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        lcemfb.setPackagesToScan("pl.maciejpajak");
        
        Properties jpaProperties = new Properties();
     
        //Configures the used database dialect. This allows Hibernate to create SQL
        //that is optimized for the used database.
        jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        
        //Specifies the action that is invoked to the database when the Hibernate
        //SessionFactory is created or closed.
//        jpaProperties.put("hibernate.hbm2ddl.auto", 
//                env.getRequiredProperty("hibernate.hbm2ddl.auto")
//        );
        
        jpaProperties.put("javax.persistence.schema-generation.database.action", env.getRequiredProperty("schema-generation.database.action"));
        jpaProperties.put("javax.persistence.sql-load-script-source", env.getRequiredProperty("javax.persistence.sql-load-script-source"));
        
        //Configures the naming strategy that is used when Hibernate creates
        //new database objects and schema elements
//        jpaProperties.put("hibernate.ejb.naming_strategy", 
//                env.getRequiredProperty("hibernate.ejb.naming_strategy")
//        );
 
        //If the value of this property is true, Hibernate writes all SQL
        //statements to the console.
        jpaProperties.put("hibernate.show_sql", 
                env.getRequiredProperty("hibernate.show_sql")
        );
 
        //If the value of this property is true, Hibernate will format the SQL
        //that is written to the console.
        jpaProperties.put("hibernate.format_sql", 
                env.getRequiredProperty("hibernate.format_sql")
        );
 
        lcemfb.setJpaProperties(jpaProperties);
 
        return lcemfb;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
    
//    @Bean
//    public PlatformTransactionManager transactionManager(){
//        JpaTransactionManager transactionManager
//          = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//          entityManagerFactoryBean().getObject() );
//        return transactionManager;
//     }
    
}
