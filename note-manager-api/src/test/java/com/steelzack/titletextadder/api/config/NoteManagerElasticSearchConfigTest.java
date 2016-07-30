package com.steelzack.titletextadder.api.config;

import com.steelzack.titletextadder.api.solr.SolrJSearcherImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

/**
 * Created by joaofilipesabinoesperancinha on 30-07-16.
 */

@Configuration
public class NoteManagerElasticSearchConfigTest {

    @Bean
    public SolrJSearcherImpl solrJSearcher() {
        return mock(SolrJSearcherImpl.class);
    }

}