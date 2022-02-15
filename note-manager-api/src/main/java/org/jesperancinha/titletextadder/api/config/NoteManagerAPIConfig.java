package org.jesperancinha.titletextadder.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


/**
 * Created by joaofilipesabinoesperancinha on 24-07-16.
 */
@Configuration
@ComponentScan(basePackages = "org.jesperancinha.titletextadder.api")
@PropertySource("classpath:/application.properties")
@Import({
        NoteManagerDBConfig.class,
        NoteManagerElasticSearchConfig.class
})
public class NoteManagerAPIConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}