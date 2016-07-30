package com.steelzack.titletextadder.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by joaofilipesabinoesperancinha on 24-07-16.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.steelzack.titletextadder.api")
@Import({
        NoteManagerDBConfig.class,
        NoteManagerElasticSearchConfigTest.class
})
public class NoteManagerAPIConfigTest {

}