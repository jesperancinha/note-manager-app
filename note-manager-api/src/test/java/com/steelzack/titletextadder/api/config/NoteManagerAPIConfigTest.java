package com.steelzack.titletextadder.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static org.mockito.Mockito.mock;

/**
 * Created by joaofilipesabinoesperancinha on 24-07-16.
 */
@Configuration
@EnableTransactionManagement
public class NoteManagerAPIConfigTest {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      return  mock(LocalContainerEntityManagerFactoryBean.class);
    }

    @Bean
    public DataSource dataSource(){
        return mock(DataSource.class);
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return mock(PlatformTransactionManager.class);
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return mock(PersistenceExceptionTranslationPostProcessor.class);
    }

}