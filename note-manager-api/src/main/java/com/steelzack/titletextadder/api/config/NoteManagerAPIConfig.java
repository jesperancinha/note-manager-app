package com.steelzack.titletextadder.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


/**
 * Created by joaofilipesabinoesperancinha on 24-07-16.
 */
@Configuration
@ComponentScan(basePackages = "com.steelzack.titletextadder.api")
@PropertySource("classpath:/application.properties")
@Import({
        NoteManagerDBConfig.class,
        NoteManagerElasticSearchConfig.class
})
public class NoteManagerAPIConfig {

}