package org.jesperancinha.titletextadder.api.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by joaofilipesabinoesperancinha on 30-07-16.
 */
@Configuration
@EnableTransactionManagement
public class NoteManagerDBConfig {

    @Value("#{'${note.manager.db.ip:172.0.0.1}'}")
    private String postgresIp;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(
                "org.jesperancinha.titletextadder.api.model"
        );
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        em.setPersistenceProvider(new HibernatePersistenceProvider());
        return em;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://".concat(postgresIp).concat(":5432/tta_db"));
        dataSource.setUsername( "test" );
        dataSource.setPassword( "test" );
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
        properties.setProperty("show_sql", "false");
        properties.setProperty("hibernate.current_session_context_class", "thread");
        return properties;
    }
}
