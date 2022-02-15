package org.jesperancinha.titletextadder.api.solr;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by joaofilipesabinoesperancinha on 05-04-16.
 */
public interface SolrSearcher {
    SolrDocumentList getAllFilteredResults(String filter) throws SolrServerException, IOException;

    void refreshCollection() throws URISyntaxException;
}
