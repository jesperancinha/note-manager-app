package org.jesperancinha.titletextadder.api.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Service("solrJSearcher")
@Component
public class SolrJSearcherImpl {

	@Autowired
	private HttpSolrClient solr;

	public SolrDocumentList getAllFilteredResults(final String filter) throws SolrServerException, IOException {
		final SolrQuery query = new SolrQuery();
		query.setQuery("title_text:*" + filter + "*");
		query.setStart(0);
		query.setRows(1000);
		query.set("defType", "edismax");

		final QueryResponse response = solr.query(query);
		return response.getResults();
	}

	public void refreshCollection() throws URISyntaxException {
		final RestTemplate restTemplate = new RestTemplate();

		final URI url = new URI("http://localhost:8983/solr/notemanagercol/dataimport?command=full-import");
		restTemplate.getForObject(url, String.class);
	}
}
