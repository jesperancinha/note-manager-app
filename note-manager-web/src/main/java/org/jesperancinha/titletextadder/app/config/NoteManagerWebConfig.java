package org.jesperancinha.titletextadder.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by joaofilipesabinoesperancinha on 30-07-16.
 */
@Configuration
@ComponentScan(basePackages = "org.jesperancinha.titletextadder.app.controller")
@PropertySource("classpath:/application.properties")
public class NoteManagerWebConfig {

    @Value("#{'${note.manager.api.url.add:http://localhost:8080/note-manager-api/rest/tta/titles/add}'}")
    private String noteManagerApiUrlAdd;

    @Value("#{'${note.manager.api.url.list:http://localhost:8080/note-manager-api/rest/tta/titles/list/}'}")
    private String noteManagerApiUrlList;

    @Bean
    URI noteManagerApiUrlAdd() throws URISyntaxException {
        return new URI(noteManagerApiUrlAdd);
    }

    @Bean
    URI noteManagerApiUrlList() throws URISyntaxException {
        return new URI(noteManagerApiUrlList);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
