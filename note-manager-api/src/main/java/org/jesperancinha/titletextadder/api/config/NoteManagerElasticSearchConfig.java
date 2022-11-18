package org.jesperancinha.titletextadder.api.config;

import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.jesperancinha.titletextadder.api.solr.SolrJSearcherImpl;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by joaofilipesabinoesperancinha on 30-07-16.
 */
@Configuration
public class NoteManagerElasticSearchConfig {

    @Value("#{'${note.manager.solr.url:http://localhost:8983/solr/notemanagercol}'}")
    private String solrUrl;

    @Bean
    public Http2SolrClient solr() {
        return new Http2SolrClient.Builder(solrUrl).build();
    }

    @Bean
    public SolrJSearcherImpl solrJSearcher() {
        return new SolrJSearcherImpl();
    }
}
